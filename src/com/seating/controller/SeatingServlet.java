package com.seating.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seating.model.*;

@WebServlet("/SeatingServlet")
public class SeatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeatingService seatingService;
	
	@Override
    public void init() throws ServletException {
		seatingService = new SeatingService();
    	super.init();
    }    
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doPost(req, res);
    	
    }
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.addHeader("Access-Control-Allow-Origin", "*");
		String action = req.getParameter("action");
		String screen = req.getParameter("screen");

		if ("booking".equals(action)) {
			String booked = req.getParameter("booked");

			try {
				
				String unavailable = seatingService.getUnavailable(screen);
				unavailable = unavailable + "," + booked.substring(1,booked.length()-1);
				seatingService.newBooking(screen, unavailable);					
				
				System.out.println(action);
				System.out.println(screen);
				System.out.println(unavailable);				
				
				res.getWriter().write("true");

			} catch (Exception e) {
				e.printStackTrace();
				
				System.out.println(action);
				System.out.println(screen);
				System.out.println(booked);
				
				res.getWriter().write("false");
			}
			return;
		}
			
		if ("retrieving".equals(action)) {

			try {
				
				
				String dbUnavailable = "["+ seatingService.getUnavailable(screen) + "]";					
				
				System.out.println(action);
				System.out.println(screen);
				System.out.println(dbUnavailable);				
				
				res.getWriter().write(dbUnavailable);

			} catch (Exception e) {
				e.printStackTrace();
				
				System.out.println(action);
				System.out.println(screen);
				
				res.getWriter().write("false");
			}
			return;
		}
	}

	
	
}
