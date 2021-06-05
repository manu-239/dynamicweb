package com.carworld.servlet.car;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.model.Car;
import com.carworld.service.AllService;
import com.carworld.service.CarService;
import com.carworld.service.EngineService;
import com.carworld.service.ManufacturerService;

/**
 * Servlet implementation class CarServlet
 */
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Car car = new Car();
			car.setModel(request.getParameter("model"));
			car.setColor(request.getParameter("color"));
			car.setPrice(Double.valueOf(request.getParameter("price")));
			car.setEngine(engineService().getEngine(Long.valueOf(request.getParameter("engine"))));
			car.setManufacturer(manufacturerService().getManufacturer(Long.valueOf(request.getParameter("manufacturer"))));
			carService().addCar(car);
			request.setAttribute("cars", carService().getAllCar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Cars.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("engines", carService().getAllEngine());
			request.setAttribute("manufactures", carService().getAllManufacturer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("AddCar.jsp").forward(request, response);
	}
	
	private CarService carService(){		
		return AllService.getCarService();
	}
	
	private EngineService engineService(){		
		return AllService.getEngineService();
	}
	
	private ManufacturerService manufacturerService(){		
		return AllService.getManufacturerService();
	}

}