package src;

public enum DrinkType {
	COFFEE("coffee", 0.6d),
	TEA("tea", 0.4d),
	CHOCOLATE("chocolate", 0.5d),
	ORANGE_JUICE("orange juice", 0.6d);
	
	private String code;
	private double price;
	
	DrinkType(String string, double price) {
		this.setCode(string);
		this.setPrice(price);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
