package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

/**
 * Servlet implementation class EditUnitServlet
 */
@WebServlet("/editUnitServlet")
public class EditUnitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUnitServlet() {
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
		// TODO Auto-generated method stub
		UnitHelper dao = new UnitHelper();
		
		String unitName = request.getParameter("unitName");
		String unitType = request.getParameter("unitType");
		Integer unitCost = Integer.parseInt(request.getParameter("unitCost"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Unit unitToUpdate = dao.searchForUnitById(tempId);
		unitToUpdate.setUnitName(unitName);
		unitToUpdate.setUnitType(unitType);
		unitToUpdate.setUnitCost(unitCost);
		
		dao.updateUnit(unitToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllUnitsServlet").forward(request, response);
	}

}
