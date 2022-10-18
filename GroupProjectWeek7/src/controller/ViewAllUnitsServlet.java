package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllUnitsServlet
 */
@WebServlet("/viewAllUnitsServlet")
public class ViewAllUnitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllUnitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/startApp.html"; //start by setting up the path to go back to the start page/add item page
		UnitHelper uh = new UnitHelper();
		
		if(!uh.showAllUnits().isEmpty()) { //if there is an item in the list then you will go to the unit-list.jsp page instead
			request.setAttribute("allItems", uh.showAllUnits());
			path = "/unit-list.jsp";
		}
		
		getServletContext().getRequestDispatcher((path)).forward(request, response); //sends you to the needed path.
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
