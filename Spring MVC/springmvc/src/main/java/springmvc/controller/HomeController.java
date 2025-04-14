package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	//@RequestMapping(path = "/home", method = RequestMethod.POST)     // This will not work because we are getting that not posting
	public String home(Model model) {
		System.out.println("this is home page");
		model.addAttribute("name", "Supriya");
		model.addAttribute("id", 123345);
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("this is about page");
		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("This is help page");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "Supriya");
		modelAndView.setViewName("help");
		return modelAndView;
	}
}


