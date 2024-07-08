package com.aftermidnight.speleohub.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aftermidnight.speleohub.model.Role;
import com.aftermidnight.speleohub.service.RoleService;

@Controller
public class TestController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/teste")
	public ModelAndView teste() {
		List<Role> a = roleService.getAll();
		ModelAndView mv = new ModelAndView("teste");
	
		System.out.println(a);
		return mv;
	}
	
	@GetMapping("/teste/simples")
	public ModelAndView TesteLayoutSimples() {
		ModelAndView mv = new ModelAndView("testes/TesteLayoutSimples");
		return mv;
	}
	
	@GetMapping("/teste/padrao")
	public ModelAndView TesteLayoutPadrao() {
		ModelAndView mv = new ModelAndView("testes/TesteLayoutPadrao");
		return mv;
	}
}