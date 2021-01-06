package com.applaguna.empleospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarHome(Model model) {

        model.addAttribute("mensaje", "Binevenidos a Empleos App");
        //model.addAttribute("fecha", new Date());

        String nombre = "Auxiliar contabiliad";
        Date fechapub = new Date();
        double salario = 9000.00;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fechapub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);

        return "home";

    }

    @GetMapping("/listado")
    public String mostarListado(Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de sistemas");
        lista.add("Auxiliar de contabiliad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";
    }
}
