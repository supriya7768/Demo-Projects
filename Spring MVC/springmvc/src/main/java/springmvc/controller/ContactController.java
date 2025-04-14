package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;

@Controller
public class ContactController {
	
	@RequestMapping("/contact")
	public String showForm() {
		return "contact";
	}
	
//	@RequestMapping(path = "/processform", method= RequestMethod.POST)
//	public String handleForm(@RequestParam("email") String email, 
//							@RequestParam("userName") String userName,
//							@RequestParam("password") String password, Model model) {
//	
//		System.out.println("user email " + email);
//		System.out.println("user userName " + userName);
//		System.out.println("user password " + password);
//		
//		model.addAttribute("name", userName);
//		model.addAttribute("email", email);
//		model.addAttribute("password", password);
//		return "success";
//	}
	
	
	
//	@RequestMapping(path = "/processform", method= RequestMethod.POST)
//	public String handleForm(@RequestParam("email") String email, 
//							@RequestParam("userName") String userName,
//							@RequestParam("password") String password, Model model) {
//	
//	User user = new User();
//	user.setEmail(email);
//	user.setUserName(userName);
//	user.setPassword(password);
//	System.out.println(user);
//	
//	model.addAttribute("user", user);
//		return "success";
//	}
	
	
	@RequestMapping(path = "/processform", method= RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		return "success";
	}


}
