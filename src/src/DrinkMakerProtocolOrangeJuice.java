package src;

import java.util.Date;

public class DrinkMakerProtocolOrangeJuice extends AbstractDrinkMakerProtocol {
	
	public DrinkMakerProtocolOrangeJuice() {
	}
	
	public String resumeOrangeJuiceCommand() {
		ReportModel report = new ReportModel(DrinkType.ORANGE_JUICE, new Date());
		DrinkMakerStorage.getInstance().addReport(report);
		return getDrinkMakerMakesMessage() + DrinkType.ORANGE_JUICE.getCode();
	}

}
