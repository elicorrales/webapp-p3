package com.eli.calc.shape.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eli.calc.shape.domain.CalculationRequest;
import com.eli.calc.shape.service.ShapeCalculatorService;

@Controller
public class RequestResponseController {

	@Autowired
	private ShapeCalculatorService calculator;
	

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView welcomeTheSlash() {

    	System.err.println("\n\n\nWelcome: The / (slash) ; Index page\n\n\n");

		return new ModelAndView("/index","message","Slash Index Page: dynamic message from Controller");
	}


	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView welcomeTheIndex() {

    	System.err.println("\n\n\nWelcome2: The /index Index page\n\n\n");

		return new ModelAndView("/index","message","Index Index Page: dynamic message from Controller");
	}


	@RequestMapping(value="/newreq",method=RequestMethod.GET)
	public ModelAndView newreq() {

    	System.err.println("\n\n\nNew Request\n\n\n");

		return new ModelAndView("/newreq","message","New Request Page: message from Controller");

	}

	@RequestMapping(value="/pending",method=RequestMethod.GET)
	public ModelAndView pending() {

    	System.err.println("\n\n\nPending Requests\n\n\n");
    	List<CalculationRequest> calcReqList = calculator.getAllPendingRequests();

		if (null==calcReqList || calcReqList.isEmpty()) {
			return new ModelAndView("/pending","message", "There are NO Pending CalculationRequests");
		}

		return new ModelAndView("/pending","calcReqList",calcReqList);

	}

	@RequestMapping(value="/results",method=RequestMethod.GET)
	public ModelAndView results() {

    	System.err.println("\n\n\nCalculated Results\n\n\n");

		return new ModelAndView("/results","message","Calculated ResultsPage: message from Controller");

	}


}
