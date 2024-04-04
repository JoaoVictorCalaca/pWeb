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

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] emails = new String[10];

		for (int i = 0; i < emails.length; i++) {
			emails[i] = "usuario" + (i + 1) + "@email.com";
		}

		final String destinatario = req.getParameter("dest");
		final String mailType = req.getParameter("mailType");
		final String autoMail = req.getParameter("auto");

		final String titulo = req.getParameter("title");
		final String mensagem = req.getParameter("msg");
		

		req.setAttribute("email", emails);

		String msg = "";

		/*if(titulo != null || mensagem != null) {
			System.out.println(destinatario + " recebeu uma nova mensagem!");
			System.out.println("Titulo: " + titulo);
			if (mailType != null && mailType.equals("f")) {
				msg = "Mensagem: Prezado(a); " + mensagem;
				
				if(autoMail != null) {
				    msg += "\nAtenção: este é um e-mail automático e não deve ser respondido";
				}
			} else if (mailType != null && mailType.equals("f")) {
			    Calendar cal = Calendar.getInstance();
			    int hour = cal.get(Calendar.HOUR_OF_DAY);
			    if (hour >= 5 && hour < 12) {
			        msg = "Mensagem: Bom dia; " + mensagem;
			    } else if (hour >= 12 && hour < 19) {
			        msg = "Mensagem: Boa tarde; " + mensagem;
			    } else {
			        msg = "Mensagem: Boa noite; " + mensagem;
			    }
			    
			    if(autoMail != null) {
				    msg += "\nAtenção: este é um e-mail automático e não deve ser respondido";
				}
			}
			req.setAttribute("sucesso", Boolean.TRUE);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println(msg);
		}else {
			req.setAttribute("falha", Boolean.TRUE);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}*/
		
		if ((titulo != null && !titulo.isEmpty()) && (mensagem != null && !mensagem.isEmpty())) {
		    System.out.println(destinatario + " recebeu uma nova mensagem!");
		    System.out.println("Titulo: " + titulo);
		    
		    if (mailType != null && mailType.equals("f")) {
		        msg = "Mensagem: Prezado(a); " + mensagem;
		        if (autoMail != null) {
		            msg += "\nAtenção: este é um e-mail automático e não deve ser respondido";
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
		    }
		    System.out.println(mensagem);
		    req.setAttribute("sucesso", true);
		} else {
		    req.setAttribute("falha", true); 
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);


		
	}
}
