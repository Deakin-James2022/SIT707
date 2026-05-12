package web.handler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class HealthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("application/json");
        resp.getWriter().println(
                "{\"status\":\"UP\",\"server\":\"running\"}");
    }
}
