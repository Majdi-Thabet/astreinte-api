package com.proxym.gestionastreintes.service;


import com.proxym.gestionastreintes.exception.UserAlreadyExistException;
import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Departement;
import com.proxym.gestionastreintes.model.Role;
import com.proxym.gestionastreintes.repository.CollaborateurRepository;

import java.util.List;

//tous les methodes qu'on on veut tester  sont dans cette interface
public interface AccountService {

//    AppUser addNewUser(AppUser appUser);
    Collaborateur addNewCollaborateur(Collaborateur collaborateur,Long idRole,Long iddepartment) throws UserAlreadyExistException;

   Role addNewRole(Role appRole);
    Departement addNewDepartement(Departement departement);
    void addRoleToUser(String username, String roleName);
    Collaborateur loadUserByUsername(String username);
    List<Collaborateur> listCollaborateurs();
    List<Role> listRoles();
    List<Departement> listDepartements();


    static void delete(Long id) {
        
    }
//  public void delete(int id){
//      CollaborateurRepository.deleteById(id);
//  }


}
