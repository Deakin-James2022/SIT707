package web.handler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class AboutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html");
        String html =
                "<html>" +
                "<head><title>About</title></head>" +
                "<body>" +
                "<h1>About This Application</h1>" +
                "<p>Simple Java Servlet Web Application using Jetty.</p>" +
                "</body>" +
                "</html>";
        resp.getWriter().println(html);
    }
}
