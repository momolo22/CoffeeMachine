package src;

public abstract class AbstractDrinkMakerProtocol {
	public DrinkType drinktype;
	
	public SugarQuantity sugarQuantity;
	
	public double money;
	
	public boolean isExtraHot;
	
	protected String getDrinkMakerMakesMessage() {
		return isExtraHot ? "Drink maker will make an extra hot " 
				: "Drink maker makes 1 ";	
	}
}
