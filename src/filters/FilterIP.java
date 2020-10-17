package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "FilterIP")
public class FilterIP implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String ip=req.getRemoteHost();
        if(ip.matches("0:0:0:0:0:0:0:1"))
        {
            PrintWriter pw=resp.getWriter();
            pw.println("127.0.0.1 is Blocked!");
        }
        else
        {
            chain.doFilter(req, resp);
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
