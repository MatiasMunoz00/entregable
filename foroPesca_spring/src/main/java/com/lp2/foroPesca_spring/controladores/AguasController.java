/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.controladores;

import com.lp2.foroPesca_spring.dao.AguasDAO;
import com.lp2.foroPesca_spring.dao.ComentarioDAO;
import com.lp2.foroPesca_spring.dao.PecesDAO;
import com.lp2.foroPesca_spring.dao.RegionDAO;
import com.lp2.foroPesca_spring.dao.UbicacionDAO;
import com.lp2.foroPesca_spring.dao.UsuarioDAO;
import com.lp2.foroPesca_spring.modelo.Aguas;
import com.lp2.foroPesca_spring.modelo.Comentario;
import com.lp2.foroPesca_spring.modelo.Region;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lp2.foroPesca_spring.modelo.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Addis Flerida Muñoz
 */
@Controller
public class AguasController {

    @Autowired
    private ComentarioDAO cDao;
    @Autowired
    private UsuarioDAO uDao;

    @Autowired
    private RegionDAO rDao;

    @Autowired
    private AguasDAO aDao;
    @Autowired
    private UbicacionDAO ubDao;
    @Autowired
    private PecesDAO pDao;

    @GetMapping("/IIIregion/CaletaObispito")
    public String muestraCaletaObispito(
            Model model
    ) {
        //Carga Comentarios
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 1) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario()); //Sube comentario
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(1); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(1); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(1); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "CaletaObispito";

    }

    @PostMapping("/IIIregion/CaletaObispito") //Recupera comentario y lo guarda.
    public String crearComentario11(
            @ModelAttribute Comentario c,
            HttpServletRequest request
    ) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/IIIregion/CaletaObispito";
        }

    }

    @GetMapping("/IIIregion/Pulpos")
    public String muestraPulpos(Model model) {
        //Carga Comentarios
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 2) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(2); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(1); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(2); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Pulpos";
    }

    @PostMapping("/IIIregion/Pulpos") //Recupera comentario y lo guarda.
    public String crearComentario10(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/IIIregion/Pulpos";
        }

    }

    @GetMapping("/IIIregion/CaletaPatos")
    public String muestraCaletaPatos(Model model) {
        //Carga comentario.
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 3) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga aguas
        List<Aguas> lAguas = aDao.findAllById(3); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(1); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(3); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "CaletaPatos";
    }

    @PostMapping("/IIIregion/CaletaPatos")//Recupera comentario y lo guarda.
    public String crearComentario9(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/IIIregion/CaletaPatos";
        }

    }

    @GetMapping("/VIIregion/Cipreses")
    public String muestraCipreses(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 4) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        List<Aguas> lAguas = aDao.findAllById(4); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(2); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(4); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Cipreses";
    }

    @PostMapping("/VIIregion/Cipreses") //Recupera comentario y lo guarda.
    public String crearComentario8(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/VIIregion/Cipreses";
        }

    }

    @GetMapping("/VIIregion/EmbalseColbun")
    public String muestraEmbalseColbun(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 5) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga aguas
        List<Aguas> lAguas = aDao.findAllById(5); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(2); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(5); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "EmbalseColbun";
    }

    @PostMapping("/VIIregion/EmbalseColbun")//Recupera comentario y lo guarda.
    public String crearComentario7(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/VIIregion/EmbalseColbun";
        }

    }

    @GetMapping("/VIIregion/Rapel")
    public String muestraRapel(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 6) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga aguas
        List<Aguas> lAguas = aDao.findAllById(6); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(2); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(6); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Rapel";
    }

    @PostMapping("/VIIregion/Rapel")//Recupera comentario y lo guarda.
    public String crearComentario6(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/VIIregion/Rapel";
        }

    }

    @GetMapping("/VIIIregion/Niuble")
    public String muestraNiublel(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 7) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(7); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(3); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(7); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Niuble";
    }

    @PostMapping("/VIIIregion/Niuble")//Recupera comentario y lo guarda.
    public String crearComentario5(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/VIIIregion/Niuble";
        }

    }

    @GetMapping("/VIIIregion/LagunaChicaSanPedro")
    public String muestraLagunaChicaSanPedro(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 8) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(8); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(3); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(8); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "LagunaChicaSanPedro";
    }

    @PostMapping("/VIIIregion/LagunaChicaSanPedro")//Recupera comentario y lo guarda.
    public String crearComentario4(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/VIIIregion/LagunaChicaSanPedro";
        }

    }

    @GetMapping("/VIIIregion/Laja")
    public String muestraLaja(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 9) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(9); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(3); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(9); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Laja";
    }

    @PostMapping("/VIIIregion/Laja")//Recupera comentario y lo guarda.
    public String crearComentario3(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/VIIIregion/Laja";
        }

    }

    @GetMapping("/Xregion/Tarahuin")
    public String muestraTarahuin(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 10) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(10); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(4); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(10); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Tarahuin";
    }

    @PostMapping("/Xregion/Tarahuin")//Recupera comentario y lo guarda.
    public String crearComentario2(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/Xregion/Tarahuin";
        }

    }

    @GetMapping("/Xregion/Cucao")
    public String muestraCucao(Model model) {
        //Carga Comentario
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 11) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(11); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(4); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(11); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "Cucao";
    }

    @PostMapping("/Xregion/Cucao")//Recupera comentario y lo guarda.
    public String crearComentario1(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/Xregion/Cucao";
        }
    }

    @GetMapping("/Xregion/LagoLlanquihue")
    public String muestraLagoLlanquihue(Model model) {
        //Carga Comentarios
        List<Comentario> lComentarios = cDao.findAll();
        ArrayList<Comentario> lComentariosFil = new ArrayList<>();
        for (int i = 0; i < lComentarios.size(); i++) {
            if (lComentarios.get(i).getIdUbicacion().getId() == 12) {
                lComentariosFil.add(lComentarios.get(i));
            }
        }
        model.addAttribute("listaComentarios", lComentariosFil);
        model.addAttribute("nuevoComentario", new Comentario());
        //Carga Aguas
        List<Aguas> lAguas = aDao.findAllById(12); //Busca el agua indicada por ID 
        model.addAttribute("listaAguas", lAguas);
        List<Region> lRegiones = rDao.findAllById(4); //Busca la region indicada por ID del Agua
        model.addAttribute("listaRegiones", lRegiones);
        List<Ubicacion> lUbicacion = ubDao.findAllById(12); //Busca la ubicacion indicada por ID del Agua
        model.addAttribute("listaUbicaciones", lUbicacion);
        return "LagoLlanquihue";
    }

    @PostMapping("/Xregion/LagoLlanquihue")//Recupera comentario y lo guarda.
    public String crearComentario12(
            @ModelAttribute Comentario c,
            HttpServletRequest request) {
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogueado");
        if (u == null) {
            return "redirect:/Login";
        } else {
            cDao.save(c);
            return "redirect:/Xregion/LagoLlanquihue";
        }
    }
}
