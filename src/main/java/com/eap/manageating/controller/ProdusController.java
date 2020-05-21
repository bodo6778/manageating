package com.eap.manageating.controller;

import com.eap.manageating.model.Produs;
import com.eap.manageating.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produs")
public class ProdusController {
    private ProdusService produsService;

    @Autowired
    public ProdusController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @GetMapping("/list")
    public String listProduse(Model model){
        List<Produs> produse = produsService.findAll();
        model.addAttribute("produse",produse);
        return "produs/listaproduse";
    }

    @GetMapping("/add")
    public String addProdus(Model model){
        List<Produs> produse = produsService.findAll();
        Produs produs = new Produs();

        model.addAttribute("produse",produse);
        model.addAttribute("produs",produs);

        return "produs/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("produs") Produs produs) {

        produsService.save(produs);

        // use a redirect to prevent duplicate submissions
        return "redirect:/produs/list";
    }

    @GetMapping("/update")
    public String updateProdus(@RequestParam("idProdus") int idProdus, Model model){
        List<Produs> produse = produsService.findAll();
        Produs produs = produsService.findById(idProdus);

        model.addAttribute("produse", produse);
        model.addAttribute("produs",produs);

        return "produs/form";
    }

    @GetMapping("/delete")
    public String stergeProdus(@RequestParam("idProdus") int idProdus){
        produsService.deleteById(idProdus);
        return "redirect:/produs/list";
    }


}
