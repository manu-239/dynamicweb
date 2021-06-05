package com.carworld.servlet.manufacturer;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.model.Manufacturer;
import com.carworld.service.AllService;
import com.carworld.service.ManufacturerService;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/addmanufacturer")
public class AddManufacturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setName(request.getParameter("name"));
			manufacturer.setAddress(request.getParameter("address"));
			manufacturer.setContactNumber(Long.valueOf(request.getParameter("contactNumber")));
			manufacturerService().addManufacturer(manufacturer);;
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