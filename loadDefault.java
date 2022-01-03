package com.classes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadDefault")
public class loadDefault extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public loadDefault() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clg,lang,questag;
		questag=request.getParameter("questag");
		lang=request.getParameter("lang");
		System.out.println("questag "+questag);
		clg= (String) request.getSession().getAttribute("college");
		try
		{
			File f = new File("C:\\Users\\Shibbu\\eclipse-workspace\\CodeChamber\\codes\\"+clg+"\\"+questag+"\\"+questag+"."+lang);
			Scanner sc = new Scanner(f);
			sc.useDelimiter("\\Z");
			response.getWriter().print(sc.next());
			sc.close();
		}
		catch(Exception e)
		{
			System.out.println("loadDef :"+e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
