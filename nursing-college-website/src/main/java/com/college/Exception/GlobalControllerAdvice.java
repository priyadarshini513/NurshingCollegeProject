package com.college.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	 @ModelAttribute("currentPath")
	    public String currentPath(HttpServletRequest request) {
	        return request.getRequestURI();
	    }

}
