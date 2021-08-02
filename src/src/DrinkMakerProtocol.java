package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class DrinkMakerProtocol extends AbstractDrinkMakerProtocol {
	
	public DrinkMakerProtocol(DrinkType drinkType, SugarQuantity sugarQuantity, double money) {
		this.drinktype = drinkType;
		this.sugarQuantity = sugarQuantity;
		this.money = money;
		this.isExtraHot = false;
	}
	
	public DrinkMakerProtocol(DrinkType drinkType, SugarQuantity sugarQuantity, double money, boolean isExtraHot) {
		this.drinktype = drinkType;
		this.sugarQuantity = sugarQuantity;
		this.money = money;
		this.isExtraHot = isExtraHot;
	}
	
	public String resumeCommand(DrinkType drinkType, double money, DrinkMakerStorage drinkStorage) {
		if(money >= drinkType.getPrice()) {
			ReportModel report = new ReportModel(drinkType, new Date());
			drinkStorage.addReport(report);
			return getCommand(drinkType);
			
		} else {
			return "It is missing " + getMoneyMissingMessage() + "for a " + drinkType.getCode();
		}
	}

	private String getCommand(DrinkType drinktype) {
		switch(drinktype) {
			case ORANGE_JUICE :
				DrinkMakerProtocolOrangeJuice orangeJuice = new DrinkMakerProtocolOrangeJuice();
				return orangeJuice.resumeOrangeJuiceCommand();
		default:
			return getDrinkMakerMakesMessage() + drinktype.getCode() +
					" "+this.sugarQuantity.getCode() + getStickMessage();		
		}
	}
	
	private String getStickMessage() {
		return this.sugarQuantity.equals(SugarQuantity.WITHOUT_SUGAR) ? " - and therefore no stick"
				: " and a stick";
	}
	
	private BigDecimal getMissingMoney() {
		BigDecimal moneyMissing = new BigDecimal(drinktype.getPrice()).subtract(new BigDecimal(this.money));
		return moneyMissing.setScale(1, RoundingMode.HALF_EVEN);
	}
	
	private String getMoneyMissingMessage() {
		return getMissingMoney().toString() + "€ ";
	}
}
