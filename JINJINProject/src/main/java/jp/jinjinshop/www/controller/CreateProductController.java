package jp.jinjinshop.www.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.jinjinshop.www.object.ProductObj;
import jp.jinjinshop.www.service.ProductService;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/CreateProduct")
public class CreateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProductController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletConfig().getServletContext().getRequestDispatcher("/CreateProduct.html").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//オブジェクトから値を取得する
		ProductObj productObj = new ProductObj();
		productObj.setProductId(request.getParameter("product_id"));
		productObj.setProductName(request.getParameter("product_name"));
		productObj.setPrice(Integer.valueOf(request.getParameter("product_price")));
		productObj.setImformation(request.getParameter("information"));
		productObj.setModel(request.getParameter("model"));
		productObj.setCategory(request.getParameter("category"));
		productObj.setBrand(request.getParameter("brand"));
		productObj.setProducingArea(request.getParameter("country"));
		productObj.setStockpileNum(Integer.valueOf(request.getParameter("stockpilenum")));
		productObj.setDelFlg("0");
		productObj.setShowFlg("1");
		
		//メソッドを呼び出す
		ProductService productservice = new ProductService();
		//从object取到的值带入方法中，插到数据库中
		productservice.createProductInfo(productObj);

		// 次の画面に遷移
		request.getRequestDispatcher("/Product.jsp").forward(request, response);
		doGet(request, response);
	}

}