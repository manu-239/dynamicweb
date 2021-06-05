package com.carworld.servlet.car;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carworld.dao.DbConnectionFactory;
import com.carworld.service.AllService;
import com.carworld.service.CarService;

/**
 * Servlet implementation class CarListServlet
 * @author: mmathew@manh.com
 */

public class CarListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	@Override
	public void init() {
		try {
			String path = "WEB-INF/resource/dbscripts.sql";
			InputStream is=this.getServletContext().getResourceAsStream(path);
			BufferedReader reader= new BufferedReader(new InputStreamReader(is));
			List<String> queries= new ArrayList<String>();
			String line=reader.readLine();
			String query="";
			while(line!=null){
				query+=line;
				if(query.endsWith(";")){
					queries.add(query);
					//System.out.println(query);
					query="";
				}
				line=reader.readLine();
			}
			Connection connection=DbConnectionFactory.getDataSource().getConnection();
			Statement statmement=connection.createStatement();
			for(String sql:queries){
				statmement.executeUpdate(sql);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("cars", carService().getAllCar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Cars.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private CarService carService(){		
		return AllService.getCarService();
	}
}