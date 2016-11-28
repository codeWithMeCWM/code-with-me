package br.org.venturus.codewithme.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Simple controller to demonstrate how Spring MVC works.
 */
@Controller
public class HelloWorldController {
	private String injected = "This message was injected through the Controller";

	@RequestMapping("/hello/{name}")
	public ModelAndView showMessage(@PathVariable String name) {
		System.out.println("in controller - name = " + name);

		ModelAndView mv = new ModelAndView("helloSpring");
		mv.addObject("injected", injected);
		mv.addObject("name", name);
		
		return mv;
	}
}