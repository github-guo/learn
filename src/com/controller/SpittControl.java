package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.controller.exception.DefineHandleException;
import com.controller.exception.DuplicateSpittleException;
import com.entity.Spitter;

@Controller
public class SpittControl {
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String processRegistration(@RequestParam("profilePic")MultipartFile image,String t1){
		try {
			System.out.println(image.getOriginalFilename()+t1);
			File file=new File("/data/spittr/"+getExt(image.getOriginalFilename()));
			
			System.out.println(file.getAbsolutePath());
			image.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test";
	}

	private String getExt(String originalFilename) {
		
		return originalFilename.substring(originalFilename.lastIndexOf(File.separator)+1);
	}
	
	@RequestMapping("/handleException")
	public void handleException(){
		throw new DefineHandleException();
	}
	
	@RequestMapping("/handleExceptionMethod")
	public void handleExceptionByMethod(){
		throw new DefineHandleException();
	}
	
	
	@ExceptionHandler(DefineHandleException.class)
	public String handleMethod(){
		return "error";
	}
	
	@RequestMapping("/duplicate")
	public String duplicateSpittle(){
		throw new DuplicateSpittleException();
	}
	
	@RequestMapping("/redirect")
	public String redirectWithParams(){
		return "redirect:/redirect/ding";
	}
	
	@RequestMapping("/redirect/{name}")
	public String processRedirect(@PathVariable("name")String nme){
		System.out.println(nme);
		return "processRedirect";
	}
	
	@RequestMapping("/processReg")
	public String processReg(RedirectAttributesModelMap ra){
		Spitter sp=new Spitter();
		sp.setId(1);
		sp.setUsername("test");
		sp.setPassword("23123");
		ra.addFlashAttribute("sp", sp);
		return "redirect:/processRegRedirect";
	}
	
	@RequestMapping("/processRegRedirect")
	public String processRegRedirect(Model ra){
		Map<String, Object> map=ra.asMap();
		Spitter sp=(Spitter) map.get("sp");
		System.out.println("name:"+sp.getUsername()+",password:"+sp.getPassword());
		return "/redirectAttributes";
	}
}
