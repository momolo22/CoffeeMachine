package test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import src.DrinkMakerProtocol;
import src.DrinkMakerStorage;
import src.DrinkType;
import src.SugarQuantity;

public class DrinkStorageTest {
	DrinkMakerStorage drinkStorage = DrinkMakerStorage.getInstance();
	
	@Test
	public void testReports() {
		DrinkMakerProtocol drink = new DrinkMakerProtocol(DrinkType.COFFEE, SugarQuantity.WITHOUT_SUGAR, 0.2d);
		DrinkMakerProtocol drink2 = new DrinkMakerProtocol(DrinkType.TEA, SugarQuantity.ONE_SUGAR, 1d, true);
		DrinkMakerProtocol drink3 = new DrinkMakerProtocol(DrinkType.CHOCOLATE, SugarQuantity.THREE_SUGARS, 0.5d);
		DrinkMakerProtocol drink4 = new DrinkMakerProtocol(DrinkType.ORANGE_JUICE, SugarQuantity.WITHOUT_SUGAR, 0.6d);
		List<DrinkMakerProtocol> drinks = Arrays.asList(drink, drink2, drink4, drink3);
		drinks.stream().forEach(drinkMaked -> {
			drinkMaked.resumeCommand(drinkMaked.drinktype, drinkMaked.money, drinkStorage);
		});
		assertTrue(drinkStorage.getReports().size() == 3);
	}

}
