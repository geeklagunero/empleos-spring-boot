package com.applaguna.empleospring.controller;

import com.applaguna.empleospring.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes", lista);

        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero en comunicaciones");
        vacante.setDescripcion("Se solicita ing para soprote tecnico en redes");
        vacante.setFecha(new Date());
        vacante.setSalario(98000.0);
        model.addAttribute("vacante", vacante);

        return "detalle";
    }

    private List<Vacante> getVacantes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<Vacante>();

        try {
            //creamos la primera oferta d etrabajo
            Vacante vacante = new Vacante();
            vacante.setId(1);
            vacante.setNombre("Ingeniero en comunicaciones");
            vacante.setDescripcion("Se solicita ing para soprote tecnico en redes");
            vacante.setFecha(sdf.parse("08-02-2019"));
            vacante.setSalario(98000.0);

            //creamos la segunda oferta de trabajo
            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador Publico");
            vacante2.setDescripcion("Se solicita ing para soprote tecnico en redes");
            vacante2.setFecha(sdf.parse("08-02-2019"));
            vacante2.setSalario(98000.0);

            //creamos la tercera oferta de trabajo
            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Se solicita ing para soprote tecnico en redes");
            vacante3.setFecha(sdf.parse("08-02-2019"));
            vacante3.setSalario(98000.0);

            //creamos la cuarta oferta de trabajo
            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("DIseñador Grafico");
            vacante4.setDescripcion("Se solicita ing para soprote tecnico en redes");
            vacante4.setFecha(sdf.parse("08-02-2019"));
            vacante4.setSalario(98000.0);

            //agregamos los cuatro objetos tipo vacante a la lista de objetos vacante
            lista.add(vacante);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("el Error es = " + e.getMessage());
        }

        return lista;
    }
}
