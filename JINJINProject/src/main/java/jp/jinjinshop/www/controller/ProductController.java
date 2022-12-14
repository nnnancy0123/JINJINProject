package jp.jinjinshop.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.jinjinshop.www.object.ProductObj;
import jp.jinjinshop.www.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		ProductService productService = new ProductService();
		List<ProductObj> productInfoList = productService.productList();
		for (ProductObj p : productInfoList) {
			System.out.println(p.toString());
		}
		 request.setAttribute("List", productInfoList);
			request.getRequestDispatcher("/Product.jsp").forward(request, response);
			response.getWriter().append("Served at: ").append(request.getContextPath());
}
	
	/**
	 * @see HttpServlet#doUpdate(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(123);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
