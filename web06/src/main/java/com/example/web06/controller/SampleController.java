package com.example.web06.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.web06.model.dto.MemberVO;
import com.example.web06.service.MemberService;

@Controller
public class SampleController {
	
	/*@Inject*/
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/calc")
	public String calc(HttpServletRequest request, HttpServletRequest response){
		return "board/calc";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletRequest response,
			Model model){
		
		int i = Integer.parseInt(request.getParameter("t1"));
		int j = Integer.parseInt(request.getParameter("t1"));
		int k = i+j;
		model.addAttribute("result", k);
		return "board/display";
	}
	
	@RequestMapping("/member/memberinsert.do")
	public String insert(){
		return "member/memberAdd";
	}
	
	@RequestMapping(value="/member/memberAdd.do", method=RequestMethod.POST)
	public String memberinsert(@ModelAttribute MemberVO vo){
		System.out.println("멤버 입력 Controller 입니다.");
        System.out.println(vo.getUserid());
        System.out.println(vo.getUserpw());
        System.out.println(vo.getUsername());
        System.out.println(vo.getEmail());
        
        memberService.insert(vo);
		return "redirect:/member/memberlist.do";
	}
	
	@RequestMapping("/member/memberlist.do")
	public ModelAndView memberlist(@ModelAttribute MemberVO vo, ModelAndView mav){
		
		List<MemberVO> list = memberService.listAll();
		mav.addObject("list", list);
		mav.setViewName("member/member_list");
		return mav;
	}

	
	@RequestMapping(value="/member/view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam String userid){
        System.out.println(userid);
		ModelAndView mav = new ModelAndView();
        mav.addObject("dto", memberService.read(userid));
		mav.setViewName("member/memberView"); // member/memberView.jsp
		return mav;
	}
	
	@RequestMapping("/member/update.do")
	public String update(@ModelAttribute MemberVO vo){
		
		System.out.println(vo.getUserid());
		System.out.println(vo.getUserpw());
		System.out.println(vo.getUsername());
		System.out.println(vo.getEmail());
		
		memberService.update(vo);
		return "redirect:/member/memberlist.do";
	}
	
	@RequestMapping("/member/delete.do")
	public String delete(@RequestParam String userid){
		memberService.delete(userid);
		return "redirect:/member/memberlist.do";
	}

}
