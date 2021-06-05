package com.carworld.servlet.car;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.service.AllService;
import com.carworld.service.CarService;

/**
 * Servlet implementation class CarServlet
 */

public class CarDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("carId"));
		try {
			request.setAttribute("car", carService().getCar(Long.valueOf(request.getParameter("carId"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("CarDetails.jsp").forward(request, response);
	}
	
	private CarService carService(){		
		return AllService.getCarService();
	}
}
