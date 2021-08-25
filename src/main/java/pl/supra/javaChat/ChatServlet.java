package pl.supra.javaChat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class ChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = createMessage(request);
        saveMessageInHistory(message, request);
        response.sendRedirect(request.getContextPath());
    }

    private void saveMessageInHistory(Message message, HttpServletRequest request) {
        ServletContext context = getServletContext();
        List<Message> messageHistory = (List<Message>)context.getAttribute("messageHistory");
        if (messageHistory == null){
            messageHistory = new ArrayList<>();
        }
        messageHistory.add(message);
        context.setAttribute("messageHistory", messageHistory);
    }

    private Message createMessage(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userMessage = request.getParameter("userMessage");
        return new Message(userName, userMessage);
    }
}
