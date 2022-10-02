package com.proxym.gestionastreintes.service;

import com.proxym.gestionastreintes.exception.UserAlreadyExistException;
import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Departement;
import com.proxym.gestionastreintes.model.Role;
import com.proxym.gestionastreintes.repository.CollaborateurRepository;
import com.proxym.gestionastreintes.repository.DepartementRepository;
import com.proxym.gestionastreintes.repository.RoleRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
@Resource
@Service
@Transactional
public class AccountServiceImpl implements AccountService {


    private CollaborateurRepository collaborateurRepository;
   private RoleRepository roleRepository;
   private DepartementRepository departementRepository;

   private PasswordEncoder passwordEncoder;


    public AccountServiceImpl(CollaborateurRepository collaborateurRepository, RoleRepository roleRepository, DepartementRepository departementRepository, PasswordEncoder passwordEncoder) {
        this.collaborateurRepository = collaborateurRepository;
        this.roleRepository = roleRepository;
        this.departementRepository = departementRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Collaborateur addNewCollaborateur(Collaborateur collaborateur,Long idRole,Long iddepartment) throws UserAlreadyExistException {
        //Let's check if user already registered with us
        if(checkIfUserExist(collaborateur.getUsername())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        String pw=collaborateur.getPassword();
          Role role=roleRepository.getById(idRole);
        collaborateur.setPassword(passwordEncoder.encode(pw));
        Departement departement=departementRepository.getById(iddepartment);
   collaborateur.setDepartment(departement);
        collaborateurRepository.save(collaborateur);
        addRoleToUser(collaborateur.getUsername(),role.getRoleName());

        return collaborateur ;

    }

     //verify if user exits or not

    public boolean checkIfUserExist(String username) {
        return collaborateurRepository.findByUsername(username) !=null ? true : false;
    }




    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public Departement addNewDepartement(Departement departement) {
           return departementRepository.save(departement);

    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        Collaborateur appUser= collaborateurRepository.findByUsername(username);
        Role role=roleRepository.findByRoleName(roleName);
       appUser.getRoles().add(role);




    }

    @Override
    //pour charger un utilisateur par son username
    public Collaborateur loadUserByUsername(String username) {

        return collaborateurRepository.findByUsername(username);
    }

    @Override
    //pour retourner la liste de tout les utilisateurs
    public List<Collaborateur> listCollaborateurs() {

        return collaborateurRepository.findAll();
    }
//pour retouner la liste de tout les roles
    public List<Role> listRoles() {

       return roleRepository.findAll();
    }

    //pour retouner la liste de tout les departements
    public List<Departement> listDepartements() {

        return departementRepository.findAll();
    }


}
