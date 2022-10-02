package com.proxym.gestionastreintes.controller;

import com.proxym.gestionastreintes.model.Collaborateur;
import com.proxym.gestionastreintes.model.Configastreinte;
import com.proxym.gestionastreintes.repository.ConfigastreinteRepository;
import com.proxym.gestionastreintes.service.ConfigastreinteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//mark class as Controller
@RestController
public class ConfigastreinteController {
    // autowire the configastreinteservice class
    @Autowired
    ConfigastreinteService configastreinteService;

    // creating a get mapping that retrieves all the configs detail from the
    // database
    @GetMapping("/getallconfigastreinte")
    private List<Configastreinte> getAllConfigs() {
        return configastreinteService.getAllConfigs();
    }

    // creating a get mapping that retrieves the detail of a specific
    // configastreinte
    @GetMapping("/configastreinte/{id}")
    private Configastreinte getConfigastreinte(@PathVariable("id") long id) {
        return configastreinteService.getConfigsById(id);
    }

    @GetMapping("/getcollabwithroleuseranddepartment/{iddepartment}")
    private List<Collaborateur> getcollabwithroleuseranddepartment(@PathVariable("iddepartment") long iddepartment) {
        return configastreinteService.getcollabwithroleuseranddepartment(iddepartment);
    }

    // @GetMapping("/gettotal/{id}")
    // private Configastreinte getTotal(@PathVariable("id") long
    // id,@PathVariable("idastreinte") long idastreinte,@PathVariable("idcollab")
    // long idcollab)
    // {
    // return configastreinteService.getTotal(id,idastreinte,idcollab);
    // }
    // creating a delete mapping that deletes a specified configastreinte
    @DeleteMapping("/configastreinte/{id}")
    private void deleteConfigastreinte(@PathVariable("id") long id) {
        configastreinteService.delete(id);
    }

    // creating post mapping that post the Configastreinte detail in the database
    @PostMapping("/configastreinte/{idcollab}")
    private Configastreinte saveConfigastreinte(@RequestBody Configastreinte configastreinte,
            @PathVariable("idcollab") Long idcollab) {

        return configastreinteService.saveConfigastreinte(configastreinte, idcollab);
    }

    // creating put mapping that updates the configastreinte detail
    @Autowired
    private ConfigastreinteRepository configastreinteRepository;

    @PutMapping("/configastreinte/{id}")
    public ResponseEntity<Configastreinte> update(@PathVariable("id") long id,
            @RequestBody Configastreinte configastreinte) {
        Optional<Configastreinte> configastreinteData = configastreinteRepository.findById(id);

        if (configastreinteData.isPresent()) {
            Configastreinte _configastreinte = configastreinteData.get();
            _configastreinte.setDureeconfigastreinte(configastreinte.getDureeconfigastreinte());
            _configastreinte.setPeriodeastreinte(configastreinte.getPeriodeastreinte());
            _configastreinte.setNombrecollaborateurs(configastreinte.getNombrecollaborateurs());
            _configastreinte.setDatedebutconfig(configastreinte.getDatedebutconfig());
            _configastreinte.setDatefinconfig(configastreinte.getDatefinconfig());
            _configastreinte.setCollaborateur(_configastreinte.getCollaborateur());
            return new ResponseEntity<>(configastreinteRepository.saveAndFlush(_configastreinte), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // @PutMapping("/configastreinte/{id}")
    // private Configastreinte update(@RequestBody Configastreinte
    // configastreinte,@PathVariable("id")Long id)
    // {
    //
    // return configastreinteService.update(configastreinte,id);
    // }

}
