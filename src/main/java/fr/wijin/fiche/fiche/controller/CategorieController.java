package fr.wijin.fiche.fiche.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.wijin.fiche.fiche.dto.CategorieDto;
import fr.wijin.fiche.fiche.form.CategorieForm;
import fr.wijin.fiche.fiche.service.CategorieService;
import jakarta.validation.Valid;

@Controller
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listcategories")
    public String showListFiches(Model model) {
        List<CategorieDto> categorieDto = categorieService.findAll();

        model.addAttribute("categories", categorieDto);

        return "categorie/listcategories";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createcategorie")
    public String createCategorie(CategorieForm categorieForm, BindingResult bindingResult, Model model) {
        model.addAttribute("categorieForm", new CategorieForm());
        return "categorie/createcategorie";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createcategorie")
    public String createPostCategorie(@Valid CategorieForm categorieForm, BindingResult bindingResult, Model model) {

        if (!bindingResult.hasErrors()) {
            CategorieDto categorieDto = new CategorieDto();
            categorieDto.setNom(categorieForm.getNom());
            CategorieDto created = categorieService.save(categorieDto);
            return "redirect:/showcategorie/" + created.getId();
        }

        return "categorie/createcategorie";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletecategorie/{id}")
    public String deleteCategorie(@RequestParam("id") Integer id, Model model) {
        try {
            Optional<CategorieDto> categorie = categorieService.findById(id);
            if (categorie.isPresent()) {
                categorieService.delete(categorie.get());
            }
        } catch (Exception e) {
        }
        return "redirect:/listcategories";
    }
}
