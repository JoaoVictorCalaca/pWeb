package mensageria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enviarMensagem")
public class EmailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final int NUM_EMAILS = 10;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> emails = generateEmails(NUM_EMAILS);
        req.setAttribute("emailList", emails);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("destinatario");
        String emailType = req.getParameter("tipoEmail");
        String autoResponse = req.getParameter("auto");
        String subject = req.getParameter("assunto");
        String messageBody = req.getParameter("corpoMensagem");

        if (isValidInput(subject, messageBody)) {
            String message = generateMessage(emailType, messageBody, autoResponse);
            req.getRequestDispatcher("sucesso.html").forward(req, resp);
        } else {
            List<String> emails = generateEmails(NUM_EMAILS);
            req.setAttribute("failure", true);
            req.setAttribute("emailList", emails);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    private List<String> generateEmails(int numEmails) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < numEmails; i++) {
            emails.add("user" + (i + 1) + "@example.com");
        }
        return emails;
    }

    private boolean isValidInput(String subject, String messageBody) {
        return subject != null && !subject.isBlank() && messageBody != null && !messageBody.isEmpty();
    }

    private String generateMessage(String emailType, String messageBody, String autoResponse) {
        String message;
        if ("f".equals(emailType)) {
            message = "Mensagem: Caro, " + messageBody;
        } else if ("h".equals(emailType)) {
            message = generateGreeting(messageBody);
        } else {
            message = "";
        }
        if (autoResponse != null) {
            message += "\nAviso: Este é um e-mail gerado automaticamente, por favor, não responda.";
        }
        return message;
    }

    private String generateGreeting(String name) {
        return "Mensagem: Olá, " + name;
    }
}
