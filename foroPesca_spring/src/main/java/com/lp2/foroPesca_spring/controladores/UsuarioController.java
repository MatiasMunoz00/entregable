/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.controladores;

import com.lp2.foroPesca_spring.dao.UsuarioDAO;
import com.lp2.foroPesca_spring.modelo.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Addis Flerida Muñoz
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDAO uDao;

    @GetMapping("/Login/RegistrationForm")
    public String muestraForm(Model model) {
        model.addAttribute("nuevoUsuario", new Usuario());
        return "RegistrationForm";
    }

    @PostMapping("/Login/RegistrationForm")
    public String crearUsuario(@ModelAttribute Usuario u) {
        uDao.save(u);
        return "Inicio";
    }

    @GetMapping("/Login")
    public String muestraFormLogin(Model model) {
        model.addAttribute("loginUsuario", new Usuario());
        return "Login";
    }

    @PostMapping("/Login")
    public String Login(
            Model model,
            @ModelAttribute Usuario u,
            HttpServletRequest request
    ) {

        Usuario usuarioBd = uDao.findByCorreoAndContrasena(u.getCorreo(), u.getContrasena());

        if (usuarioBd != null) {
            request.getSession().setAttribute("usuarioLogueado", usuarioBd);
            return "Inicio";
        } else {
            model.addAttribute("nuevoUsuario", new Usuario());
            model.addAttribute("Error", true);
            return "Inicio";
        }
    }

    @PostMapping("/logout")
    public String logout(
            Model model,
            HttpServletRequest request
    ) {
        request.getSession().invalidate();
        return "Inicio";
    }

}
