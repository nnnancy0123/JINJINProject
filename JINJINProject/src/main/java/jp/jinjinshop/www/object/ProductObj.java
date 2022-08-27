package jp.jinjinshop.www.object;

public class ProductObj {
	private String productId;
	private String productName;
	private int price;
	private String imformation;
	private String model;
	private String category;
	private String brand;
	private String producingArea;
	private int stockpileNum;
	private String showFlg;
	private String delFlg;
	private String dateCreated;
	private String dateModified;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImformation() {
		return imformation;
	}

	public void setImformation(String imformation) {
		this.imformation = imformation;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProducingArea() {
		return producingArea;
	}

	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}

	public int getStockpileNum() {
		return stockpileNum;
	}

	public void setStockpileNum(int stockpileNum) {
		this.stockpileNum = stockpileNum;
	}

	public String getShowFlg() {
		return showFlg;
	}

	public void setShowFlg(String showFlg) {
		this.showFlg = showFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	@Override
	public String toString() {
		return "ProductObj [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", imformation=" + imformation + ", model=" + model + ", category=" + category + ", brand=" + brand
				+ ", producingArea=" + producingArea + ", stockpileNum=" + stockpileNum + ", showFlg=" + showFlg
				+ ", delFlg=" + delFlg + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + "]";
	}

}