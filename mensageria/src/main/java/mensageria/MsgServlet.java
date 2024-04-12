package mensageria;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendMsg")
public class MsgServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] emails = new String[10];

		for (int i = 0; i < emails.length; i++) {
			emails[i] = "usuario" + (i + 1) + "@email.com";
		}

		req.setAttribute("email", emails);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String destinatario = req.getParameter("dest");
		final String mailType = req.getParameter("mailType");
		final String autoMail = req.getParameter("auto");

		final String titulo = req.getParameter("title");
		final String mensagem = req.getParameter("msg");

		String msg = "";

		if ((titulo != null && !titulo.isBlank()) && (mensagem != null && !mensagem.isEmpty())) {
			System.out.println(destinatario + " recebeu uma nova mensagem!");
			System.out.println("Titulo: " + titulo);
			System.out.println("Mensagem: " + mensagem);
			
			if (mailType != null && mailType.equals("f")) {
				msg = "Mensagem: Prezado(a); " + mensagem;
				if (autoMail != null) {
					msg += "\nAtenção: este é um e-mail automático e não deve ser respondido";
					System.out.println(msg);
				}
			} else if (mailType != null && mailType.equals("h")) {
				Calendar cal = Calendar.getInstance();
				int hour = cal.get(Calendar.HOUR_OF_DAY);
				if (hour >= 5 && hour < 12) {
					msg = "Mensagem: Bom dia; " + mensagem;
				} else if (hour >= 12 && hour < 19) {
					msg = "Mensagem: Boa tarde; " + mensagem;
				} else {
					msg = "Mensagem: Boa noite; " + mensagem;
				}
				if (autoMail != null) {
					msg += "\nAtenção: este é um e-mail automático e não deve ser respondido";
				}
				System.out.println(msg);
			}
			req.getRequestDispatcher("sucesso.html").forward(req, resp);
		} else {
			String[] emails = new String[10]; 
			
			for (int i = 0; i < emails.length; i++) {
				emails[i] = "usuario" + (i + 1) + "@email.com";
			}
			req.setAttribute("falha", true);
			req.setAttribute("email", emails);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}