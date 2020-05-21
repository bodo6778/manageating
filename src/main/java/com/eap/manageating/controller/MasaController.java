package com.eap.manageating.controller;

import com.eap.manageating.model.Comanda;
import com.eap.manageating.model.Masa;
import com.eap.manageating.model.Staff;
import com.eap.manageating.service.ComandaService;
import com.eap.manageating.service.MasaService;
import com.eap.manageating.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/masa")
public class MasaController {
    private MasaService masaService;
    private ComandaService comandaService;
    private StaffService staffService;

    public MasaController(MasaService masaService) {
        this.masaService = masaService;
    }

    @Autowired
    public MasaController(MasaService masaService, ComandaService comandaService, StaffService staffService) {
        this.masaService = masaService;
        this.comandaService = comandaService;
        this.staffService = staffService;
    }

    @GetMapping("/list")
    public String listMese(Model model){
        List<Masa> mese = masaService.findAll();
        model.addAttribute("mese",mese);
        return "mese/listamese";
    }

    @GetMapping("/preluare")
    public String preluareComanda(@RequestParam("masa") int theMasa,
                                  @RequestParam("chelner") int idStaff){
        Comanda comanda = new Comanda();
        Staff staff = staffService.findById(idStaff);
        comanda.setStaff(staff);
        comanda.setMasa(masaService.findById(theMasa));
        comanda.setDataComanda(new java.util.Date());
        comandaService.save(comanda);
        return "redirect:/comenzi/list";
    }
}
