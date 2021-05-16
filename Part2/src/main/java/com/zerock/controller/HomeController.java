package com.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/gugudan_YsY", method = RequestMethod.GET)
	public String dan(Model model)
	{
		logger.info("danYsY--------------------");
		
		String danString="";
		int sum=0;
		
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
				danString=danString+i+"*"+j+"="+(i*j)+"<br/>";
				
				sum = sum+i*j;

			}
			model.addAttribute("dan"+i,danString);
			model.addAttribute("danSum"+i, sum);
			
			danString="";
			sum=0;
		}
		 return "gugudan_YsY"; 

	}
	
	@RequestMapping(value = "/end", method = RequestMethod.GET)
	public String endPage(Model model)
	{
		 return "end"; 

	}
}
