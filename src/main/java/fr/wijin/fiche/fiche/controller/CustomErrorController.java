package fr.wijin.fiche.fiche.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        System.out.println("CustomErrorController.handleError() appelé");
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            System.out.println("Code d'erreur: " + statusCode);
            model.addAttribute("errorCode", statusCode);
            
            switch (statusCode) {
                case 404:
                    model.addAttribute("errorMessage", "Page non trouvée");
                    break;
                case 500:
                    model.addAttribute("errorMessage", "Erreur interne du serveur");
                    break;
                case 403:
                    model.addAttribute("errorMessage", "Accès interdit");
                    break;
                default:
                    model.addAttribute("errorMessage", "Une erreur s'est produite");
                    break;
            }
        } else {
            System.out.println("Pas de code d'erreur trouvé");
            model.addAttribute("errorCode", "Unknown");
            model.addAttribute("errorMessage", "Une erreur s'est produite");
        }
        
        System.out.println("Redirection vers template error.html");
        return "error";
    }
}