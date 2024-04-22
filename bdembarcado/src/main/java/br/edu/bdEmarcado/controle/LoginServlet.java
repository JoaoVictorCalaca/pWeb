package br.edu.bdEmarcado.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.bdEmarcado.entidade.Usuario;
import br.edu.bdEmarcado.respositorio.UsuarioRepositorio;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String email = req.getParameter("email");
		final String senha = req.getParameter("password");
		
		if (email.contains("@ifgoiano")) {
			if (senha.equals("123456")) {
				try {
					UsuarioRepositorio repositorio = new UsuarioRepositorio();
					
					List<Usuario> lstUsuario = repositorio.listarUsuarios();
					
					req.setAttribute("usuarios", lstUsuario);
					
					req.getRequestDispatcher("listaUsuarios.jsp").forward(req, resp);;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		}
	}
}
