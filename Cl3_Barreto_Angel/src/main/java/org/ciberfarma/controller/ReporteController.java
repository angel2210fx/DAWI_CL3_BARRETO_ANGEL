package org.ciberfarma.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.ciberfarma.repository.ICarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ReporteController {

	@Autowired
	private ICarreraRepository repo;

	@GetMapping("/reporte/cargar")
	public String cargarform(Model model) {
		model.addAttribute("lstcarrera", repo.findAll());
		// model.addAttribute("producto", new Producto());
		return "registrar";
	}

	@GetMapping("/reporte/listar")
	public String listarform(@RequestParam(name = "carrera") int reserva, Model model) {
		model.addAttribute("lstCarrera", repo.findAll());
		model.addAttribute("lstCarrera", repo.findByIdcarrera(reserva));
		return "registrar";
	}

	@Autowired
	private DataSource dataSource; //javasql
	@Autowired
	private ResourceLoader resourceLoader; //springframework.core.io

	@GetMapping("/reporte")
	public void reportepdf(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reporte.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@GetMapping("/grafico")
	public void reportegrafico(HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=\"grafico.pdf\";");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:grafico.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
