package com.proxym.gestionastreintes.service;

import com.proxym.gestionastreintes.enumuration.StatusEnum;
import com.proxym.gestionastreintes.model.Astreinte;
import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Configastreinte;
import com.proxym.gestionastreintes.model.Departement;
import com.proxym.gestionastreintes.repository.CollaborateurRepository;
import com.proxym.gestionastreintes.repository.ConfigastreinteRepository;
import com.proxym.gestionastreintes.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import java.time.temporal.ChronoUnit;

//defining the business logic
@Service
public class ConfigastreinteService {

    @Autowired
    private ConfigastreinteRepository configastreinteRepository;
    @Autowired
    private CollaborateurRepository collaborateurRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private AstreinteService astreinteService;



public  Astreinte astreinte;
    //getting all configastreintes record by using the method findaAll() of CrudRepository
    public List<Configastreinte> getAllConfigs() {

        return this.configastreinteRepository.findAll();
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Configastreinte getConfigsById(long id) {
        return configastreinteRepository.getById(id);
    }

//    private void get(Configastreinte configsById) {
//    }



    //saving a specific record by using the method save() of CrudRepository

    public Configastreinte saveConfigastreinte(Configastreinte configastreinte, long idcollab) {
        Collaborateur c = collaborateurRepository.getById(idcollab);
       long dep = c.getDepartment().getId();
        List<Collaborateur> collaborateurList= this.getcollabwithroleuseranddepartment(dep);
        configastreinte.setCollaborateur(c);
        Long range = ChronoUnit.DAYS.between(configastreinte.getDatedebutconfig(),configastreinte.getDatefinconfig());
        System.out.println("range"+range);
        configastreinte.setDureeconfigastreinte(range.intValue());
        int nombrecollaborateurs = configastreinte.nombrecollaborateurs;
        int dureeastreinte = configastreinte.dureeconfigastreinte;
        int periodeastreinte = configastreinte.periodeastreinte;
        int nombreastreintes = dureeastreinte / periodeastreinte;
        float astreintebycollaborateurs = (float) nombreastreintes / (float) nombrecollaborateurs;
        configastreinte.setAstreintebycollaborateur(astreintebycollaborateurs);
        configastreinte.setNombreastreintes(nombreastreintes);
        LocalDate datedebut =configastreinte.datedebutconfig;
        for (int i =0; i <= nombreastreintes; i++) {
            for (int j=0;j<collaborateurList.size();j++){
                Astreinte a = new Astreinte();
                a.setDatedebut(datedebut);
                a.setDatefin(datedebut.plusDays(periodeastreinte));
                a.setStatus(StatusEnum.EN_ATTENTE);
                a.setIntervention("prod et support");
                a.setDureeastreinte(configastreinte.periodeastreinte);
                a.setPrime(150.2);
                a.setType("astreinte de jour");
                if(i==nombreastreintes){
                    a.setDatefin(configastreinte.getDatefinconfig());
                }
                System.out.println(j);
                System.out.println(collaborateurList.size());
                a.setCollaborateur(collaborateurList.get(j));
                configastreinte.getAstreinteList().add(a);
                this.astreinteService.saveastrainte(a);
                datedebut=a.getDatefin().plusDays(1);
                i++;
            }
        }
        return configastreinteRepository.save(configastreinte);
    }

    public List<Collaborateur> getcollabwithroleuseranddepartment(long iddepartment) {

        return collaborateurRepository.getcollabwithroleuseranddepartment(iddepartment);
    }




    //        Astreinte nombreastreintes = new Astreinte();
//        Collaborateur nombrecollaborateurs = new Collaborateur();
//        configastreinteRepository.save(d);


    //        public Configastreinte save(Configastreinte configastreinte,long idcollab)
//        {
//
//            Collaborateur c =  collaborateurRepository.getById(idcollab);
//            configastreinte.setCollaborateur(c);
//            return configastreinteRepository.save(configastreinte);
//        }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(long id) {
        configastreinteRepository.deleteById(id);
    }

    //updating a record
    public Configastreinte update(Configastreinte configastreinte, long id) {
        return configastreinteRepository.saveAndFlush(configastreinte);
    }

//    public Configastreinte getTotal(Configastreinte configastreinte, long id,long idastreinte,long idcollab)
//    {
//
//        Collaborateur nombrecollaborateurs = new Collaborateur();
//        Astreinte nombreastreintes = new Astreinte();
//        int c = (nombreastreintes/nombrecollaborateurs);
//        return  configastreinteRepository.getById(id);
//
//    }


}


//    public static List<Configastreinte> getAllConfigs() {
//    }
//
//    public Configastreinte getConfigsById(int id) {
//    }
//
//    public void delete(int id) {
//    }
//
//    public void saveOrUpdate(Configastreinte configastreinte) {
//    }

