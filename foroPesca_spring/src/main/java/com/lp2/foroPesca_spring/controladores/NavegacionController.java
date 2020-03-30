/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Addis Flerida Muñoz
 */
@Controller
public class NavegacionController {

    @GetMapping("/")
    public String page() {
        return "Inicio";
    }

    @GetMapping("/Informacion")
    public String informacion() {
        return "Informacion";
    }
}
