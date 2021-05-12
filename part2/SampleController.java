package org.zerock.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.Animal.animalVO;
import org.zerock.login.loginVO;

@Controller
@RequestMapping("/sample/*")

public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String basic()
	{
		logger.info("basic----------------------");
	
		 return "home"; 
	}
	
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa( Model model)
	{
		logger.info("aaa----------------------");
	
		model.addAttribute("aaa", "강아지....");
		
		 return "aaa"; 
	}
	@RequestMapping(value = "/gugu/dan", method = RequestMethod.GET)
	public String dan(Model model)
	{
		logger.info("dan----------------------");
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
		 return "gugu/dan"; 

	}
	
	

	@RequestMapping( value = "/bbb", method = RequestMethod.GET )
	public String bbb(@RequestParam String dan, Model model)
	{
		logger.info("bbb----------------------");

		if(dan.equals("2"))
		{
			String danString ="";
			 for(int i=1;i<10;i++) {
				 danString = danString + 2+ "*" +i + "=" + 2*i +"<br/>"; 
			 }
				 model.addAttribute("dan2", danString);
			 
			 return "gugu/dan2"; 
		}else if(dan.equals("3"))
		{
			String danString2 ="";
			 for(int i=1;i<10;i++) {
				 danString2 = danString2 + 3+ "*" +i + "=" + 3*i +"<br/>"; 
			 }
			
			model.addAttribute("dan3", danString2);
			 return "gugu/dan3"; 
		
		}else if(dan.equals("4"))
		{
			String danString3 ="";
			for(int i=1;i<10;i++) {
				danString3 = danString3+4+"*"+i+"="+4*i+"<br/>";
			}
			model.addAttribute("dan4", danString3);
			 return "gugu/dan4"; 
		
		}else if(dan.equals("5"))
		{
			 return "gugu/dan5"; 
		
		}else if(dan.equals("6"))
		{
			 return "gugu/dan6"; 
			
		}
		model.addAttribute("dan2", "2*1=2");
		return "gugu/dan2";
			
		
	}

	
	@RequestMapping(value = "/ccc", method = RequestMethod.GET)
	public String ccc()
	{
		logger.info("ccc----------------------");
	
		 return "ccc"; 
	}

	@RequestMapping(value = "/ddd", method = RequestMethod.GET)
	public String ddd()
	{
		logger.info("ddd----------------------");
	
		 return "ddd"; 
	}
	
	@RequestMapping(value = "/eee", method = RequestMethod.GET)
	public String eee()
	{
		logger.info("eee----------------------");
	
		
		
		 return "eee"; 
	}
		
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model)
	{
		logger.info("dashboard----------------------");
	
		
		model.addAttribute("aaa", "강아지");
		 return "dashboard"; 
	}
	
	@RequestMapping( value = "/htmlsample", method = RequestMethod.GET )
	public String htmlsample(@RequestParam String html, Model model)
	{
		logger.info(html);
		
		return "htmlsample/"+html;
	}
	
	@RequestMapping( value = "/login", method = RequestMethod.POST)
	public String login(loginVO logVo, Model model)
	{
		logger.info(logVo.getLoginId());
		logger.info(logVo.getLoginName());
		
		model.addAttribute("logvo", logVo);
		return "htmlsample/htmlSample3";
	}
	
	@RequestMapping( value = "/animal", method = RequestMethod.POST)
	public String animal(String message,Model model)
	{
		logger.info("==========animal 함수===========");
		logger.info("=========="+message+"===========");
		animalVO animal1 = new animalVO();
		animal1.setAnimalValue("01");
		animal1.setAnimalName("고양이");
		
		animalVO animal2 = new animalVO();
		animal2.setAnimalValue("02");
		animal2.setAnimalName("강아지");
		
		animalVO animal3 = new animalVO();
		animal3.setAnimalValue("03");
		animal3.setAnimalName("송아지");
		
		animalVO animal4 = new animalVO();
		animal4.setAnimalValue("04");
		animal4.setAnimalName("염소");
		
		ArrayList<animalVO> arrList = new ArrayList<animalVO>();  //배열 보내는 형식 :animalVO
		arrList.add(animal1);
		arrList.add(animal2);
		arrList.add(animal3);
		arrList.add(animal4);
		model.addAttribute("animal",arrList);
		return "htmlsample/htmlSample5";
	}
	
	
}
