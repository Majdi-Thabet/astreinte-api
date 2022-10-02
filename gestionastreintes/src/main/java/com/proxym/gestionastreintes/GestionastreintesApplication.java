package com.proxym.gestionastreintes;

import com.proxym.gestionastreintes.model.Departement;
import com.proxym.gestionastreintes.model.Role;
import com.proxym.gestionastreintes.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GestionastreintesApplication {


    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionastreintesApplication.class, args);
    }

    @Bean
//cette annotation bean est utilisee pour que l'application s'execute
    CommandLineRunner start(AccountService accountService) {
        return args -> {
      /*       accountService.addNewRole(new Role(1L,"USER","membre equipe"));
            accountService.addNewRole(new Role(2L,"ADMIN","chef equipe"));*/

//            accountService.addNewDepartement(new Departement(1L,"Support"));
//            accountService.addNewDepartement(new Departement(2L,"BEST"));
//            accountService.addNewDepartement(new Departement(3L,"FinLab"));
//            accountService.addNewDepartement(new Departement(4L,"Digix"));




        };

    }
}
