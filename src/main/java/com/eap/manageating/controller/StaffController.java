package com.eap.manageating.controller;

import com.eap.manageating.dao.RoleDao;
import com.eap.manageating.model.Staff;
import com.eap.manageating.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private StaffService staffService;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/list")
    public String listaStaff(Model model){
        List<Staff> staffList = staffService.findAll();
        model.addAttribute("staffList",staffList);
        return "staff/listaStaff";
    }

    @GetMapping("/promoveaza")
    @Transactional
    public String promoveazaChelner(@RequestParam("idChelner") int idChelner,
                                    Model model){
        Staff staff = staffService.findById(idChelner);
        staff.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_CHELNER"),roleDao.findRoleByName("ROLE_ADMIN")));
        return "redirect:/staff/list";
    }
}
