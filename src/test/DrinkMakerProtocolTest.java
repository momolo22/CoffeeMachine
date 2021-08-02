package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.DrinkMakerProtocol;
import src.DrinkMakerStorage;
import src.DrinkType;
import src.SugarQuantity;

public class DrinkMakerProtocolTest {
	
	DrinkMakerStorage drinkStorage = DrinkMakerStorage.getInstance();
	
	@Test
	public void notEnoughMoneyTest() {
		DrinkMakerProtocol drink = new DrinkMakerProtocol(DrinkType.COFFEE, SugarQuantity.WITHOUT_SUGAR, 0.2d);
		assertTrue("It is missing 0.4€ for a coffee".equalsIgnoreCase(drink.resumeCommand(drink.drinktype, drink.money, drinkStorage)));
	}
	
	@Test
	public void makeExtraHotTeaWithOneSugarTest() {
		DrinkMakerProtocol drink = new DrinkMakerProtocol(DrinkType.TEA, SugarQuantity.ONE_SUGAR, 1d, true);
		assertTrue("Drink maker will make an extra hot tea 1 sugar and a stick".equalsIgnoreCase(drink.resumeCommand(drink.drinktype, drink.money, drinkStorage)));
	}
	
	@Test
	public void makeChocolateWithThreeSugars() {
		DrinkMakerProtocol drink = new DrinkMakerProtocol(DrinkType.CHOCOLATE, SugarQuantity.THREE_SUGARS, 0.5d);
		assertTrue("Drink maker makes 1 chocolate 3 sugars and a stick".equalsIgnoreCase(drink.resumeCommand(drink.drinktype, drink.money, drinkStorage)));
	}
	
	@Test
	public void makeChocolateWithoutSugar() {
		DrinkMakerProtocol drink = new DrinkMakerProtocol(DrinkType.CHOCOLATE, SugarQuantity.WITHOUT_SUGAR, 0.5d);
		assertTrue("Drink maker makes 1 chocolate no sugar - and therefore no stick".equalsIgnoreCase(drink.resumeCommand(drink.drinktype, drink.money, drinkStorage)));
	}
	
	@Test
	public void makeAnOrangeJuice() {
		DrinkMakerProtocol drink = new DrinkMakerProtocol(DrinkType.ORANGE_JUICE, SugarQuantity.WITHOUT_SUGAR, 0.6d);
		assertTrue("Drink maker makes 1 orange juice".equalsIgnoreCase(drink.resumeCommand(drink.drinktype, drink.money, drinkStorage)));
	}

}
