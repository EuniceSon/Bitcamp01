

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.model.EmployeeDAO;
import com.controller.model.EmployeeDTO;
import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ajaxTest
 */
@WebServlet(urlPatterns= "/ajaxTest.do")
public class ajaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json ;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO mdao = new MemberDAO();
		List<MemberDTO> list =  mdao.getMemberList();
//		System.out.println(list);
		JSONArray jarr =JSONArray.fromObject(list);
		out.print(jarr);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
