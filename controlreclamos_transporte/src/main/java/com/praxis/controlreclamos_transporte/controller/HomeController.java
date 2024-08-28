package com.praxis.controlreclamos_transporte.controller;

import com.praxis.controlreclamos_transporte.model.entity.Role;
import com.praxis.controlreclamos_transporte.model.entity.User;
import com.praxis.controlreclamos_transporte.model.service.RoleService;
import com.praxis.controlreclamos_transporte.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final UserService service;
    private final RoleService roleService;

    public HomeController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/home/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAll());
        return "register";
    }

    @PostMapping("/home/register")
    public String registerUser(@ModelAttribute User user, @RequestParam("id") int roleId, Model model) {
        try {
            Role role = roleService.findById(roleId);
            if (role != null) {
                List<Role> roles = new ArrayList<>();
                roles.add(role);
                user.setRoles(roles);
            }
            service.create(user);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("registrationError", "Error al registrar el usuario");
            return "register";
        }
    }

}