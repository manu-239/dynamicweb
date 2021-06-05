package com.carworld.servlet.engine;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.model.Car;
import com.carworld.model.Engine;
import com.carworld.service.AllService;
import com.carworld.service.CarService;
import com.carworld.service.EngineService;
import com.carworld.service.ManufacturerService;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/addengine")
public class AddEngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Engine engine = new Engine();
			engine.setEngineName(request.getParameter("engineName"));
			engine.setEngineType(request.getParameter("engineType"));
			engine.setDisplacement(Integer.valueOf(request.getParameter("displacement")));
			engine.setEngineManufacturer(manufacturerService().getManufacturer(Long.valueOf(request.getParameter("engineManufacturer"))));
			engineService().addEngine(engine);
			request.setAttribute("engines", engineService().getAllEngine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Engines.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("engineManufactures", manufacturerService().getAllManufacturer());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("AddEngine.jsp").forward(request, response);
	}
	
	private EngineService engineService(){		
		return AllService.getEngineService();
	}
	
	private ManufacturerService manufacturerService(){		
		return AllService.getManufacturerService();
	}

}