package jp.jinjinshop.www.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jp.jinjinshop.www.object.ProductObj;

public class ProductService {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String user = "postgres";
	String password = "postgres";

	/**
	 * データベースを連接
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Connection getDb() {
		if (conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement();
			} catch (SQLException | ClassNotFoundException ex) {
			}
		}
		return conn;
	}

	public void insert(String sql) throws SQLException {
		System.out.println(sql);
		stmt.execute(sql);
	}
	/**
	 * データベースを閉める
	 */
	public void closeDb() {
		try {
			if (rset != null) {
				rset.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * データがSQLに書き込む
	 * 
	 */
	public void createProductInfo(ProductObj productObj) {

		conn = this.getDb();
		System.out.println(1233);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		
		sb.append(
				"insert into tbl_product (product_id, product_name,	price, imformation, model, category, brand, producing_area,	stockpile_num,	show_flg,	del_flg,	date_created,	date_modified\n"
						+ ")");
		sb.append("values(");
		sb.append("'" + productObj.getProductId() + "',");
		sb.append("'" + productObj.getProductName() + "',");
		sb.append(productObj.getPrice() + ",");
		sb.append("'" + productObj.getImformation() + "',");
		sb.append("'" + productObj.getModel() + "',");
		sb.append("'" + productObj.getCategory() + "',");
		sb.append("'" + productObj.getBrand() + "',");
		sb.append("'" + productObj.getProducingArea() + "',");
		sb.append(productObj.getStockpileNum() + ",");
		sb.append("'" + productObj.getShowFlg() + "',");
		sb.append("'" + productObj.getDelFlg() + "',");
		sb.append("'" + timestamp + "',");
		sb.append("'" + timestamp + "'");
		sb.append(");");
		System.out.println(sb.toString());

		try {
			stmt = conn.createStatement();
			stmt.execute(sb.toString());

		} catch (SQLException e) {

			e.printStackTrace();
		}

		this.closeDb();
	}
	
	
	public List<ProductObj> productList () {
		List<ProductObj> list = new ArrayList<ProductObj>();
		try {
			conn = this.getDb();
			stmt = conn.createStatement();
			
			ResultSet resultset = stmt.executeQuery("SELECT * FROM tbl_product order by product_id asc");
			while (resultset.next()) {
				
				ProductObj productlistInfo = new ProductObj();
				
				productlistInfo.setProductId(resultset.getString("product_id"));
				productlistInfo.setProductName(resultset.getString("product_name"));
				productlistInfo.setPrice(resultset.getInt("price"));
				productlistInfo.setImformation(resultset.getString("imformation"));
				productlistInfo.setModel(resultset.getString("model"));
				productlistInfo.setCategory(resultset.getString("category"));
				productlistInfo.setBrand(resultset.getString("brand"));
				productlistInfo.setProducingArea(resultset.getString("producing_area"));
				productlistInfo.setStockpileNum(resultset.getInt("stockpile_num"));
				productlistInfo.setShowFlg(resultset.getString("show_flg"));
				productlistInfo.setDelFlg(resultset.getString("del_flg"));
				productlistInfo.setDateCreated(resultset.getString("date_created"));
				productlistInfo.setDateModified(resultset.getString("date_modified"));

				list.add(productlistInfo);
			}

			conn.close();
		} catch (SQLException ex) {
			System.out.println("SQLException");
		}
		return list;

	}
}

