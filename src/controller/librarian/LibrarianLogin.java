package controller.librarian;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DatabaseUtil;

/**
 * 该类用于处理Librarian登录的业务逻辑
 * 
 * @author zengyaoNPU
 *
 */
public class LibrarianLogin extends HttpServlet {
	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * 处理Librarian登录的业务逻辑
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 测试用：NPU，710072
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		// System.out.println(userName);
		// System.out.println(password);
		try {
			Connection conn = DatabaseUtil.getInstance().getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from librarian where librarian_name='" + userName + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				if (userName.equals(rs.getString("librarian_name"))) {
					if (password.equals(rs.getString("librarian_password"))) {
						System.out.println("登录成功");
					} else {
						System.out.println("密码错误");
					}
				}
			} else {
				System.out.println("该用户不存在");
			}

		} catch (Exception e) {

		} finally {

		}
	}
}