package com.example.web06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


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
		// model 은 view 단으로 데이터를 넘기기 위한 Map형 자료구조이다.
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/* http://localhost:8080/web06/doA - http://localhost:8080/ContextPath/doA             */	
	@RequestMapping("/doA") 
	public String doA(){
		logger.info("test/calldoA.jsp called ----------------");
		
		return "test/calldoA";  // views/test/calldoA.jsp
	}
	
	@RequestMapping("/doB") 
	public String doB(Model model){
		logger.info("test/calldoB.jsp called ----------------");
		model.addAttribute("name","shim");
		return "test/calldoB";  // views/test/calldoA.jsp
	}
	
	@RequestMapping("/doC") 
	public ModelAndView doC(ModelAndView mav){
		logger.info("test/doC.jsp called ----------------");
		mav.setViewName("test/doC"); // WEB-INF/views/test/doC.jsp
		mav.addObject("message", "ModelAndView 객체를 이용해서 데이터를 전달합니다.");
		mav.addObject("name", "심상수");
		return mav;  
	}
	
}
