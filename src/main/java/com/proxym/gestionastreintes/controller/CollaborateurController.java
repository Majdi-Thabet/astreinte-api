package com.proxym.gestionastreintes.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proxym.gestionastreintes.exception.UserAlreadyExistException;
import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Departement;
import com.proxym.gestionastreintes.model.Role;
import com.proxym.gestionastreintes.repository.CollaborateurRepository;
import com.proxym.gestionastreintes.security.JWTUtil;
import com.proxym.gestionastreintes.service.AccountService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class CollaborateurController {
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    private AccountService accountService;

    public CollaborateurController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "/getall")

    public List<Collaborateur> getAllCollaborateurs() {
        return accountService.listCollaborateurs();
    }

    @GetMapping(path = "/getallrole")

    public List<Role> getAllRoles() {
        return accountService.listRoles();
    }

    @GetMapping(path = "/getalldepartement")

    public List<Departement> getAllDepartements() {
        return accountService.listDepartements();
    }

    @GetMapping("/collaborateur/{id}")
    public ResponseEntity<Collaborateur> getCollaborateurById(@PathVariable("id") long id) {
        Optional<Collaborateur> collaborateurData = collaborateurRepository.findById(id);

        if (collaborateurData.isPresent()) {
            return new ResponseEntity<>(collaborateurData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/collaborateurByUserName/{userName}")
    public Collaborateur getCollaborateurByUserName(@PathVariable("userName") String userName) {
        Collaborateur collaborateurData = collaborateurRepository.findByUsername(userName);

        return collaborateurData;
    }

    @DeleteMapping("/deleteCollaborateur/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            collaborateurRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //
    // @DeleteMapping(path="/deleteCollaborateur/{id}")
    // private void deleteCollaborateur(@PathVariable("id") Long id)
    // {
    // return collaborateurRepository.deleteById(id);
    // }
    //

    @PutMapping("/updateCollaborateur/{id}")
    public ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable("id") long id,
            @RequestBody Collaborateur collaborateur) {
        Optional<Collaborateur> collaborateurData = collaborateurRepository.findById(id);

        if (collaborateurData.isPresent()) {
            Collaborateur _collaborateur = collaborateurData.get();
            _collaborateur.setNom(collaborateur.getNom());
            _collaborateur.setPrenom(collaborateur.getPrenom());
            _collaborateur.setEmail(collaborateur.getEmail());
            _collaborateur.setPoste(collaborateur.getPoste());
            return new ResponseEntity<>(collaborateurRepository.save(_collaborateur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // public Collaborateur deletePost(@PathVariable Long id) {
    //
    // var isRemoved = accountService.delete(id);
    //
    // if (!isRemoved) {
    // return new Collaborateur(HttpStatus.NOT_FOUND);
    // }
    //
    // return new Collaborateur(id, HttpStatus.OK);
    // }

    @PostMapping(path = "/addcollaborateur/{idRole}/{iddepartment}")
    // @PostAuthorize("hasAuthority('ADMIN')")
    public Collaborateur saveUser(@RequestBody Collaborateur collaborateur, @PathVariable Long idRole,
            @PathVariable Long iddepartment) throws UserAlreadyExistException {
        return accountService.addNewCollaborateur(collaborateur, idRole, iddepartment);

    }

    /*
     * @PostMapping(path = "/addRoleToUser")
     * 
     * @PostAuthorize("hasAuthority('ADMIN')")
     * public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
     * accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.
     * getRoleName());
     * }
     */
    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authToken = request.getHeader(JWTUtil.AUTH_HEADER);
        if (authToken != null && authToken.startsWith(JWTUtil.PREFIX)) {
            try {
                String jwt = authToken.substring(JWTUtil.PREFIX.length());
                Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username = decodedJWT.getSubject();
                Collaborateur collaborateur = accountService.loadUserByUsername(username);
                String jwtAccessToken = JWT.create()
                        .withSubject(collaborateur.getUsername())
                        // .withExpiresAt(new Date(System.currentTimeMillis() +JWTUtil.PREFIX))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",
                                collaborateur.getRoles().stream().map(r -> r.getRoleName())
                                        .collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> idToken = new HashMap<>();
                idToken.put("access-token", jwtAccessToken);
                idToken.put("refresh-token", jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);

                // intercepter la requete faire les verifications puis je passe au filtre
                // suivant wou mba3ed requete temchi lil dipatcher servlets
                // authentifier l'user
                // generer un nouvel token cad renouveler le access token
            } catch (Exception e) {

                throw e;

            }
        } else {
            throw new RuntimeException(("Refresh token required!!!"));
        }

    }

}
