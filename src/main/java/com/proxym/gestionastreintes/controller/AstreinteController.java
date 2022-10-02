package com.proxym.gestionastreintes.controller;

import com.proxym.gestionastreintes.model.Astreinte;
import com.proxym.gestionastreintes.model.Historique;
import com.proxym.gestionastreintes.repository.AstreinteRepository;
import com.proxym.gestionastreintes.service.AstreinteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//mark class as Controller
@RestController
public class AstreinteController {
    //autowire the astreinteservice class
    @Autowired
    AstreinteService astreinteService;
    //creating a get mapping that retrieves all the astreinte detail from the database
    @GetMapping("/getallastreinte")
    private List<Astreinte> getAllAstreintes()
    {
        return astreinteService.getAllAstreintes();
    }
    //creating a get mapping that retrieves the detail of a specific astreinte
    @GetMapping("/astreinte/{id}")
    private Astreinte getAstreinte(@PathVariable("id") long id)
    {
        return astreinteService.getastreinteById(id);
    }


    @GetMapping("/astreintebyidcollab/{idcollab}")
    private List<Astreinte> getAstreinteByIdCollaborateur(@PathVariable("idcollab") long idcollab)
    {
        return astreinteService.getAstreinteByIdCollaborateur(idcollab);
    }


    //creating a delete mapping that deletes a specified astreinte
    @DeleteMapping("/astreinte/{id}")
    private void deleteAstreinte(@PathVariable("id") long id)
    {
        astreinteService.delete(id);
    }
    //creating post mapping that post the astreinte detail in the database
    @PostMapping("/astreinte/{idcollab}")
    private Astreinte saveastreinte(@RequestBody Astreinte astreinte,@PathVariable("idcollab")Long idcollab)
    {
        return astreinteService.save(astreinte,idcollab);

    }



    //creating put mapping that updates the astreinte detail
    @Autowired
    private AstreinteRepository astreinteRepository;
    @PutMapping("/astreinte/{id}")
    public ResponseEntity<Astreinte> update(@PathVariable("id") long id, @RequestBody Astreinte astreinte){
        Optional<Astreinte> astreinteData = astreinteRepository.findById(id);

        if(astreinteData.isPresent()) {
            Astreinte _astreinte = astreinteData.get();
            _astreinte.setType(astreinte.getType());
            _astreinte.setDatedebut(astreinte.getDatedebut());
            _astreinte.setDatefin(astreinte.getDatefin());
            _astreinte.setDureeastreinte(astreinte.getDureeastreinte());
            _astreinte.setDatepermutation(astreinte.getDatepermutation());
            _astreinte.setPrime(astreinte.getPrime());
            _astreinte.setIntervention(astreinte.getIntervention());
            _astreinte.setStatus(astreinte.getStatus());
            _astreinte.setRaison(astreinte.getRaison());
            _astreinte.setCollaborateur(_astreinte.getCollaborateur());

            return new ResponseEntity<>(astreinteRepository.saveAndFlush(_astreinte), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}