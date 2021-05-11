package com.workspace.settingweb;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.workspace.sungjukVO.sungjukVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/sungjuk")
public class SungjukController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/sungjuk", method = RequestMethod.GET)
	public String sungjuk(Model model) {
		
		logger.info("=========sungjuk===================");
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);*/
		
		ArrayList arrList = new ArrayList();
		arrList.add("홍길동");
		arrList.add("홍길순");
		arrList.add("김길동");
		arrList.add("김길순");
		arrList.add("최길동");
		arrList.add("최길순");
		arrList.add("이길동");
		arrList.add("이길순");
		arrList.add("박길동");
		arrList.add("박길순");
		
		model.addAttribute("arrList", arrList);
		
		ArrayList arrList2 = new ArrayList();
		arrList2.add("컴공");
		arrList2.add("컴공");
		arrList2.add("컴공");
		arrList2.add("컴공");
		arrList2.add("컴공");
		arrList2.add("비컴공");
		arrList2.add("비컴공");
		arrList2.add("비컴공");
		arrList2.add("비컴공");
		arrList2.add("비컴공");
		model.addAttribute("arrList2", arrList2);
		
		
		return "sungjuk";
	}
	
	@RequestMapping(value = "/sungjukpyo", method = RequestMethod.POST)
	public  String SunjukPyo(sungjukVO sungjukVo , Model model)
	
	{
	logger.info("==============SunjukPyo ==========");
	
	String[] name=  sungjukVo.getName().split(",");     // 이름
	String[] junge=  sungjukVo.getJunge().split(",");    // 전산학개론
	String[] java= sungjukVo.getJava().split(",");     // 자바
	String[] program= sungjukVo.getProgram().split(",");  //프로그래밍
	String[] tongge= sungjukVo.getTongge().split(",");   // 통계학
	String[] juneng= sungjukVo.getJuneng().split(",");   // 전산영어
	String[] junCal= sungjukVo.getJunCal().split(",");   // 전산수학
	
	
	ArrayList arrList = new ArrayList();
	
	for(int i=0; i<10;i++)
	{
		sungjukVO sung = new sungjukVO();
		sung.setName(name[i]);
		sung.setJunge(junge[i]);
		sung.setJava(java[i]);
		sung.setProgram(program[i]);
		sung.setTongge(tongge[i]);
		sung.setJuneng(juneng[i]);
		sung.setJunCal(junCal[i]);
		arrList.add(sung);
		
	}
		
		model.addAttribute("sungjuk", arrList);
		
		return  "sungjukDisplay";
		
	}
	
}
