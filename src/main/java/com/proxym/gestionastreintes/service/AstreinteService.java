package com.proxym.gestionastreintes.service;

import com.proxym.gestionastreintes.model.Astreinte;
import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.repository.AstreinteRepository;
import com.proxym.gestionastreintes.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
//defining the business logic
@Service("AstreinteService")
public class AstreinteService {
    @Autowired
    private AstreinteRepository astreinteRepository;
    @Autowired
    private CollaborateurRepository collaborateurRepository;

    //getting all configastreintes record by using the method findaAll() of CrudRepository
    public List<Astreinte> getAllAstreintes()
    {
        return this.astreinteRepository.findAll();
    }
    //getting a specific record by using the method findById() of CrudRepository
    public Astreinte getastreinteById(long id)
    {
        return astreinteRepository.getById(id);
    }

//    private void get(Configastreinte configsById) {
//    }

    //saving a specific record by using the method save() of CrudRepository
    public Astreinte save(Astreinte astreinte,long idcollab)
    {

        Collaborateur c =  collaborateurRepository.getById(idcollab);
        astreinte.setCollaborateur(c);
        return astreinteRepository.save(astreinte);
    }
 public Astreinte saveastrainte(Astreinte astreinte)
    {

        return astreinteRepository.save(astreinte);
    }

//    Collaborateur c =  collaborateurRepository.getById(idcollab);
//        configastreinte.setCollaborateur(c);
//    int x=configastreinte.nombrecollaborateurs;
//    int z = configastreinte.dureeastreinte;
//    int e = configastreinte.periodeastreinte;
//    int d = z/e;
//    float abc = (float)d/(float)x;
//        configastreinte.setAstreintebycollaborateur(abc);
//         configastreinte.setNombreastreintes(d);



    public List<Astreinte> getAstreinteByIdCollaborateur(long idcollab) {

        return astreinteRepository.findAstreinteByCollaborateurId(idcollab);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(long id)
    {
        astreinteRepository.deleteById(id);
    }
    //updating a record
    public Astreinte update(Astreinte astreinte, long id)
    {
        return  astreinteRepository.saveAndFlush(astreinte);
    }
}
