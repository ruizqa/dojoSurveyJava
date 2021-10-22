package com.example.demo;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index(Model model) {
    	ArrayList<String> countries = new ArrayList<String>();
    	ArrayList<String> languages = new ArrayList<String>();
    	countries.add("Costa Rica");
    	countries.add("Ecuador");
    	countries.add("Mexico");
    	languages.add("Python");
    	languages.add("Java");
    	languages.add("Javascript");
    	model.addAttribute("countries", countries);
    	model.addAttribute("languages", languages);
        return "index";
    }
    
    @RequestMapping(value ="/", method =  RequestMethod.POST)
    public String index(@RequestParam(value="name") String name,
    		@RequestParam(value="location") String location,
    		@RequestParam(value="language") String language,
    		@RequestParam(value="comment") String comment,
    		HttpSession session) {
    		
    		String java = new String("Java");
    		session.setAttribute("name", name);
    		session.setAttribute("location", location);
    		session.setAttribute("language", language);
    		session.setAttribute("comment", comment);
    		if(language.equals(java)) {
    		return "redirect:/java";}
    		else {
    			return "redirect:/result";
    		}
    }
    
    @RequestMapping(value ="/result", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
    	
    	
    	model.addAttribute("name", session.getAttribute("name"));
    	model.addAttribute("location", session.getAttribute("location"));
    	model.addAttribute("language", session.getAttribute("language"));
    	model.addAttribute("comment", session.getAttribute("comment"));
    	
    	
        return "result";
    }
    
    
    @RequestMapping(value ="/java", method = RequestMethod.GET)
    public String java(Model model, HttpSession session) {
    	
    	System.out.println("Redirected");
    	model.addAttribute("name", session.getAttribute("name"));
    	model.addAttribute("location", session.getAttribute("location"));
    	model.addAttribute("language", session.getAttribute("language"));
    	model.addAttribute("comment", session.getAttribute("comment"));
    	
    	
        return "result_java";
    }
    
}


