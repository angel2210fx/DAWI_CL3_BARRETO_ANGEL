package org.ciberfarma.controller;

import java.util.List;

import org.ciberfarma.Model.Carrera;
import org.ciberfarma.repository.ICarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class CarreraController {

	@Autowired
	private ICarreraRepository repo;

	@PostMapping("/grabar")
	public String grabarform(@ModelAttribute Carrera Carrera, Model model) {

		model.addAttribute("lstcarrera", repo.findAll());

		try {
			repo.save(Carrera);
			model.addAttribute("success", "Procesos realizado con exito");
		} catch (Exception e) {
			model.addAttribute("error", "Error al registrar");
		}

		System.out.println(Carrera);

		return "registrar";
	}

}
