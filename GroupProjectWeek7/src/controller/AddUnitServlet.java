package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class addUnitServlet
 */
@WebServlet("/addUnitServlet")
public class AddUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUnitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String unitName = request.getParameter("unitName"); //get's the parameters from the jsp file.
		String unitType = request.getParameter("unitType");
		Integer unitCost = Integer.parseInt(request.getParameter("unitCost"));
		
		System.out.println("Adding unit: [Name: " + unitName + ",Type: " + unitType + ",Cost: " + unitCost + "]"); //outputs all the parameters so you can see if they're right
		Unit newUnit = new Unit(unitName,unitType,unitCost); //makes the new unit
		
		UnitHelper uh = new UnitHelper(); 
		uh.insertUnit(newUnit); //sets the new unit
		
		getServletContext().getRequestDispatcher("/startApp.html").forward(request, response); //sends you back to the add-item/start page
		
	}

}
