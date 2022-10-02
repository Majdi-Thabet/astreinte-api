package com.proxym.gestionastreintes.security;

import com.proxym.gestionastreintes.security.filters.JWTAuthenticationFilter;

import com.proxym.gestionastreintes.security.filters.JWTAuthorizationFiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //ki nji lech naamel bil sql nbadel fi hethi nhot jdbc authentication
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
       /* auth.userDetailsService(new UserDetailsService() {
              //hethi maneha ki yji mech yesta3mel user fait moi appel a cette methode
               @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            //recuperer l'utilisateur a partir de la base de donnees
            Collaborateur appUser=accountService.loadUserByUsername(username);
            Collection<GrantedAuthority> authorities=new ArrayList<>();
            appUser.getRoles().forEach(r->{
                authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
            });
            return new User(appUser.getUsername(),appUser.getPassword(),authorities);
        }
    });*/

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests().antMatchers( "/**").permitAll();
//
//         http.authorizeRequests().anyRequest().authenticated();
//         http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
//         http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //Securiser les resources et les mots de passes
         // la protection csrf utilise les sessions
        http.cors().configurationSource(corsConfigurationSource()).and().csrf().disable();
        //pas de session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
        STATELESS);
        //http.headers().frameOptions().disable();

       //
        http.authorizeRequests().antMatchers("/**").permitAll();
        //http.authorizeRequests().antMatchers("/registration/**").permitAll();

        //http.authorizeRequests().antMatchers("/login").hasRole("ADMIN");
        //pour activer un formulaire d'authentification
        //http.formLogin();
      /*  http.authorizeRequests().antMatchers("/users/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasRole("USER");*/

        http.authorizeRequests().anyRequest().authenticated().and();

        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);




    }


        @Bean
        CorsConfigurationSource corsConfigurationSource () {
            final CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("*"));
            configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
//            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Arrays.asList("*"));
            configuration.setExposedHeaders(Arrays.asList("X-Auth-Token", "Authorization", "Access-Control-Allow-Origin",
                    "Access-Control-Allow-Credentials"));
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }


}



//on utilise les filtres une fois l'uilisateur est authentifié on va génerer le jwt et tester l'application avec le json web token
//jwt authentication filter qui va etre utilisee au moment de l'authentification genereer un token jwt
//jwt authorized filter cad des qu'un utilisateur demande une resource je recupere le jwt je verifie et a partir de ce token je recupere l'user et avec le role