package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import  org.springframework.web.servlet.ModelAndView;

import com.example.crud.DAO.UserDAO;
import com.example.crud.model.*;

@Controller
public class UserController {
	
	@RequestMapping("index")
	public String index() {
		return "Index.jsp";
	}
	
	@Autowired
	UserDAO userdao;
 
	@RequestMapping("addUser")
	public String Usermethod(User us) {
		userdao.save(us);
		return "Index.jsp";
		
	}
	
	@RequestMapping("ShowUser")
	public ModelAndView show(@RequestParam("idfind") int id){
		
		ModelAndView mav= new ModelAndView("Show.jsp");  //response mentioned in parameter show.jsp
		 User us1=userdao.findById(id).orElse(new User()) ; //optional newly came(if user given new id which not there in db. so used new user creating new object
		 mav.addObject("details",us1);
		 System.out.println(userdao.findByage(10));
		 System.out.println(userdao.findByageGreaterThan(4));
		 //mav.setViewName("show.jsp");
		return mav;
		
		
	}
	
	///Rest API
	
	@RequestMapping("/hello")
	@ResponseBody
	public String apimeth()     
	{
		return userdao.findAll().toString();
	}
	
	@RequestMapping("/hello/{id}")
	@ResponseBody
	public String method1(@PathVariable("id") int id)     
	{
		return userdao.findById(id).toString();
	}
	
	
	
	
	
	
}
