package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean login = false;
		if (session != null) {
			if (session.getAttribute("memberDto") != null) {
				login = true;
			}
		}
		if (login) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpReepnse = (HttpServletResponse) response;
			
		//	httpReepnse.sendRedirect("/openProject/login/login.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
			dispatcher.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
