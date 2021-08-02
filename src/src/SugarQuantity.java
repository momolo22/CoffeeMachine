package src;

public enum SugarQuantity {
	WITHOUT_SUGAR("no sugar"),
	ONE_SUGAR("1 sugar"),
	TWO_SUGARS("2 sugars"),
	THREE_SUGARS("3 sugars");

	private String code;
	
	SugarQuantity(String i) {
		this.setCode(i);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
