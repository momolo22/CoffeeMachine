package src;

import java.util.Date;

public class ReportModel {
	
	private DrinkType drinkType;
	
	private Date date;
	
	public ReportModel(DrinkType drinkType, Date date) {
		this.date = date;
		this.drinkType = drinkType;
	}

	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
