package fr.wijin.fiche.fiche.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.wijin.fiche.fiche.dto.FicheDto;
import fr.wijin.fiche.fiche.service.FicheService;

@Controller
public class FicheController {

    @Autowired
    private FicheService ficheService;

    @GetMapping("/listfiches")
    public String showListFiches(Model model){
        List<FicheDto> ficheDtos = ficheService.findAll();

        model.addAttribute("fiches", ficheDtos);

        return "fiche/listfiches";
    }


    @GetMapping("/showfiche/{id}")
    public String showficheById(@PathVariable("id") Integer id, Model model) {

        FicheDto ficheDto = ficheService.findById(id).orElse(null);

        model.addAttribute("fiche", ficheDto);
        return "fiche/showfiche";
    }
}
