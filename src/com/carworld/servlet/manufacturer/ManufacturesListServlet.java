package com.carworld.servlet.manufacturer;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.service.AllService;
import com.carworld.service.ManufacturerService;

/**
 * Servlet implementation class CarListServlet
 * @author: mmathew@manh.com
 */
@WebServlet("/manufactureslist")
public class ManufacturesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("manufactures", manufacturerService().getAllManufacturer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Manufactures.jsp").forward(request, response);
	}

	private ManufacturerService manufacturerService(){		
		return AllService.getManufacturerService();
	}
}