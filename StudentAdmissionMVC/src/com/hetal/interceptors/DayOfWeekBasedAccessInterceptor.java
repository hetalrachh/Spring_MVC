package com.hetal.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	//executed below the user request is processed
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar c = Calendar.getInstance();

		int day = c.get(c.DAY_OF_WEEK);
		if (day == 5) { // day = 5 means its thursday
			response.getWriter().write("Sorry the application is not available");
			return false;
		}
		return true;
	}

	//after the request is processed in submitAdmissionForm() method
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		System.out.println("post handle called" + request.getRequestURI().toString());
	}

	//after the view admissionform is displayed
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
		System.out.println("afterCompletion called" + request.getRequestURI().toString());
	}

}
