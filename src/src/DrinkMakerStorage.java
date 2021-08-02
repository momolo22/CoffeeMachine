package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class DrinkMakerStorage {
	
	private static DrinkMakerStorage instance;
	
	private ArrayList<ReportModel> reports = new ArrayList<>();
	
	public DrinkMakerStorage() {}
	
	public static DrinkMakerStorage getInstance() {
		if(instance == null) {
			return new DrinkMakerStorage();
		}
		return instance;
	}
	
	public void addReport(ReportModel model) {
		reports.add(model);
	}

	public void printReports() {
		int numberCoffeeSold = getNombreDrink(DrinkType.COFFEE);
		int numberTeaSold = getNombreDrink(DrinkType.TEA);
		int numberChocoSold = getNombreDrink(DrinkType.CHOCOLATE);
		int numberOrangeJuiceSold = getNombreDrink(DrinkType.ORANGE_JUICE);
		
		getDrinkMessage(DrinkType.COFFEE, numberCoffeeSold);
		getDrinkMessage(DrinkType.TEA, numberTeaSold);
		getDrinkMessage(DrinkType.CHOCOLATE, numberChocoSold);
		getDrinkMessage(DrinkType.ORANGE_JUICE, numberOrangeJuiceSold);
		System.out.println("the selling's total amount : " + 
		getTotalAmount(numberCoffeeSold, numberTeaSold, numberChocoSold, numberOrangeJuiceSold));
	}
	
	private int getNombreDrink(DrinkType drinkType) {
		return (int) reports.stream().filter(model 
				-> model.getDrinkType().equals(drinkType)).count();
		
	}
	
	private void getDrinkMessage(DrinkType drinkType, int numberDrinks) {
		System.out.println("We sell " + numberDrinks + " " + drinkType.getCode());
	}
	
	private double getTotalAmount(int numCoffee, int numTea, int numChoco, int numOrange) {
		BigDecimal coffee = getAmountByDrink(DrinkType.COFFEE, numCoffee);
		BigDecimal tea = getAmountByDrink(DrinkType.TEA, numTea);
		BigDecimal choco = getAmountByDrink(DrinkType.CHOCOLATE, numChoco);
		BigDecimal orange = getAmountByDrink(DrinkType.ORANGE_JUICE, numOrange);
		
		return coffee.add(orange).add(tea).add(choco).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
	}
	
	private BigDecimal getAmountByDrink(DrinkType drink, int numDrinks) {
		return new BigDecimal(drink.getPrice()).multiply(new BigDecimal(numDrinks));
	}

	public ArrayList<ReportModel> getReports() {
		return reports;
	}
}
