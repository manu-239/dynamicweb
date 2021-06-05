package com.carworld.servlet.engine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.service.AllService;
import com.carworld.service.EngineService;

/**
 * Servlet implementation class CarDelServlet
 */
@WebServlet("/delengine")
public class DeleteEngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//System.out.println(request.getParameter("engineId"));
    	try {
    		engineService().deleteEngine(Long.valueOf(request.getParameter("engineId")));
			request.setAttribute("engines", engineService().getAllEngine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Engines.jsp").forward(request, response);
	}

	private EngineService engineService(){		
		return AllService.getEngineService();
	}

}
