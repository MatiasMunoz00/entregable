/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.foroPesca_spring.controladores;

import com.lp2.foroPesca_spring.dao.ComentarioDAO;
import com.lp2.foroPesca_spring.modelo.Comentario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Addis Flerida Muñoz
 */
@Controller
public class ComentarioController {

    @Autowired
    private ComentarioDAO cDao;

    // GET (PEDIR) POST (ENVIAR) DELETE PUT
    //Eliminar Comentarios.
    //Métodos por Caleta debido a que los comentarios cargan por caleta
    //filtrados por el ID, haciendo que estos sean con rutas dinámicas pero la caleta por ruta "directa".
    @GetMapping("/IIIregion/CaletaObispito/deleteComentario/{id}")
    public String eliminarComentarioObispito(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/IIIregion/Pulpos/deleteComentario/{id}")
    public String eliminarComentarioPulpos(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/IIIregion/CaletaPatos/deleteComentario/{id}")
    public String eliminarComentarioCaletaPatos(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/VIIregion/Cipreses/deleteComentario/{id}")
    public String eliminarComentarioCipreses(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/VIIregion/EmbalseColbun/deleteComentario/{id}")
    public String eliminarComentarioEmbalseColbun(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/VIIregion/Rapel/deleteComentario/{id}")
    public String eliminarComentarioRapel(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/VIIIregion/Niuble/deleteComentario/{id}")
    public String eliminarComentarioNiuble(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/VIIIregion/LagunaChicaSanPedro/deleteComentario/{id}")
    public String eliminarComentarioLagunaChicaSanPedro(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/VIIIregion/Laja/deleteComentario/{id}")
    public String eliminarComentarioLaja(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/Xregion/Tarahuin/deleteComentario/{id}")
    public String eliminarComentarioTarahuin(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/Xregion/Cucao/deleteComentario/{id}")
    public String eliminarComentarioCucao(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

    @GetMapping("/Xregion/LagoLlanquihue/deleteComentario/{id}")
    public String eliminarComentarioLagoLlanquihue(
            @PathVariable("id") Integer idComentario
    ) {
        cDao.deleteById(idComentario);
        return "Inicio";
    }

}
