

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
@WebServlet(urlPatterns= "/ajaxModiTest.do")
public class ajaxModiTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxModiTest() {
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
		
		String IdValue = request.getParameter("Id");
		String newValue = request.getParameter("newName");
		
		System.out.println("  :          "+IdValue+"  :          "+newValue);
		PrintWriter out = response.getWriter();
		MemberDAO mdao = new MemberDAO();
		int val=  mdao.updateMember(IdValue, newValue);
		MemberDAO mdao2 = new MemberDAO();
		List<MemberDTO> list  = mdao2.getMemberList();
		System.out.println("   커넥션풀이 답인가...     :   "+list);
		//List<MemberDTO> list = mdao.getMemberList();
		
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
