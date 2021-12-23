
package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAOViatura;
import model.Viatura;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class ControllerViatura extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAOViatura dao = new DAOViatura();
	
	/** The contacto. */
	Viatura viatura = new Viatura();

	/**
	 * Instantiates a new controller.
	 */
	public ControllerViatura() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			contactos(request, response);
		} else if (action.equals("/insert")) {
			novoContacto(request, response);
		} else if (action.equals("/select")) {
			listarContacto(request, response);
		} else if (action.equals("/update")) {
			editarContacto(request, response);
		} else if (action.equals("/delete")) {
			removerContacto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contactos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contactos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Viatura> lista = dao.listar();

		request.setAttribute("viatura", lista);
		RequestDispatcher rd = request.getRequestDispatcher("viatura.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo contacto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novoContacto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		viatura.setNome(request.getParameter("nome"));
		viatura.setMarca(request.getParameter("marca"));
		viatura.setFabrico( (Date) request.getAttribute("fabrico"));
		viatura.setTipo((Long) request.getAttribute("tipo"));
		

		dao.inserirContacto(viatura);

		response.sendRedirect("main");
	}

	/**
	 * Listar contacto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarContacto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		viatura.setCod((Long) request.getAttribute("cod"));
		

		dao.selecionarContacto(viatura);

		request.setAttribute("cod", viatura.getCod());
		request.setAttribute("nome", viatura.getNome());
		request.setAttribute("marca", viatura.getMarca());
		request.setAttribute("fabrico", viatura.getFabrico());
		//request.setAttribute("tipo", viatura.getTipo());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar contacto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContacto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		viatura.setCod((Long) request.getAttribute("cod"));
		viatura.setNome(request.getParameter("nome"));
		viatura.setMarca(request.getParameter("marca"));
		viatura.setFabrico((Date) request.getAttribute("fabrico"));
		viatura.setTipo((Long) request.getAttribute("tipo")); 
		

		dao.actualizarContacto(viatura);

		response.sendRedirect("main");
	}

	/**
	 * Remover contacto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerContacto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		viatura.setCod((Long) request.getAttribute("cod"));

		dao.deletarContacto(viatura);

		response.sendRedirect("main");

	}

	
	

}

