package web.handler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.getWriter().println(
                "<html><body><h2>User logged out successfully.</h2></body></html>");
    }
}
