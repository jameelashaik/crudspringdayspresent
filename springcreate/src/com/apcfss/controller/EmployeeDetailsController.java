package com.apcfss.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apcfss.model.EmployeeDetails;
import com.apcfss.model.Worker;
import com.apcfss.service.EmployeeDetailsService;

@Controller
@RequestMapping("/employeedetails")
public class EmployeeDetailsController {
	@Autowired
	EmployeeDetailsService employeeservice;
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	ModelAndView create(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 modelAndView.addObject("employeedetails",new EmployeeDetails());
	
		modelAndView.setViewName("emp");
		 return modelAndView;
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	ModelAndView save(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("employeedetails")EmployeeDetails emp)
	{
		
		System.out.println("Name"+ emp.getName());
		System.out.println("id"+ emp.getId());
		System.out.println("salary"+ emp.getSalary());
		employeeservice.createEmployee(emp);
		return null;
	}
	@RequestMapping(value="/viewemp",method = RequestMethod.GET)
	ModelAndView viewemp(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 List<EmployeeDetails> emplist=employeeservice.getEmployees();
		 modelAndView.addObject("emplist",emplist);
	
		modelAndView.setViewName("viewemp");
		 return modelAndView;
	}
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	ModelAndView deleteemp(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{
		//ModelAndView modelAndView=new ModelAndView();
		int eid = employeeservice.delete(id);
		if(eid>0){
			System.out.println("deleted successfully");
		}
		System.out.println("deleted failed");
		return null;
	}
	@RequestMapping(value="/editemp/{id}",method = RequestMethod.GET)
	ModelAndView edit(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{
		System.out.println("Hello ");
		ModelAndView modelAndView=new ModelAndView();
		
		 EmployeeDetails getedit = employeeservice.getEmpById(id);
		 modelAndView.addObject("employeedetails",getedit);
		 System.out.println(getedit.getId());
	request.setAttribute("id", getedit.getId());
		modelAndView.setViewName("editform");
		 return modelAndView;
	}
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public String editsave(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("employeedetails")EmployeeDetails emp)
	{
		 
		 System.out.println("----------"+request.getParameter("id"));
		 boolean edit = employeeservice.edit(emp,request);
		 //modelAndView.addObject("edit",edit);
		 System.out.println(edit);
		// return "redirect:/viewemp";  
		//modelAndView.setViewName("editform");
		 //return modelAndView;
		return null;
	}
	@RequestMapping(value="/dropdown",method = RequestMethod.GET)
	ModelAndView dropdown(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 List<EmployeeDetails> emplist1=employeeservice.getEmployees();
		 modelAndView.addObject("emplist1",emplist1);
		 System.out.println("iam coming here-------------------------------------"+emplist1);
		modelAndView.setViewName("emp");
		 return modelAndView;
	}
	/*@RequestMapping(value="/savedropdown",method = RequestMethod.POST)
	ModelAndView savedropdown(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("employeedetails")EmployeeDetails emp)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("employeedetails",emp);
		
		System.out.println("Name"+ emp.getName());
		System.out.println("id"+ emp.getId());
		System.out.println("salary"+ emp.getSalary());
		employeeservice.savedayspresent(emp);
		return modelAndView;
	}*/
	/*@RequestMapping(value="/dropdown1",method = RequestMethod.GET)
	ModelAndView dropdown1(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 List<EmployeeDetails> emplist1=employeeservice.getEmployees();
		 modelAndView.addObject("emplist1",emplist1);
		 System.out.println("iam coming here-------------------------------------"+emplist1);
		modelAndView.setViewName("dropdown");
		 return modelAndView;
	}	*/
	@RequestMapping(value="/down028",method = RequestMethod.GET)
	ModelAndView dropdown2(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 List<EmployeeDetails> emplist1=employeeservice.getEmployees1();
		 modelAndView.addObject("emplist1",emplist1);
		 System.out.println("iam coming here-------------------------------------"+emplist1);
		modelAndView.setViewName("emp");
		 return modelAndView;
	}
}
