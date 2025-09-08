package fr.wijin.fiche.fiche.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String createPostCategorie(@Valid CategorieForm categorieForm, BindingResult bindingResult, Model model,
            RedirectAttributes redirectAttributes) {

        if (!bindingResult.hasErrors()) {
            CategorieDto categorieDto = new CategorieDto();
            categorieDto.setNom(categorieForm.getNom());
            categorieService.save(categorieDto);
            redirectAttributes.addFlashAttribute("success", "Catégorie créée avec succès");
            return "redirect:/listcategories";
        }
        redirectAttributes.addFlashAttribute("error", "Impossible de créer la catégorie");
        return "categorie/createcategorie";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/deletecategorie")
    public String deleteCategorie(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        Optional<CategorieDto> categorie = null;
        try {
            categorie = categorieService.findById(id);
            if (categorie.isPresent()) {
                categorieService.delete(categorie.get());
                redirectAttributes.addFlashAttribute("success", "Catégorie supprimée avec succès");
            } else {
                redirectAttributes.addFlashAttribute("error", "Catégorie introuvable");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Impossible de supprimer la catégorie");
        }
        return "redirect:/listcategories";
    }
}
