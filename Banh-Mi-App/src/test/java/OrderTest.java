import com.pluralsight.deli.application.*;
import com.pluralsight.deli.enums.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testAddItemToOrder() {
        // Create a new order
        Order order = new Order("Jane Doe");

        // Add a sandwich to the order
        Sandwich sandwich = new Sandwich();
        sandwich.setBread(BreadType.WHEAT);
        sandwich.setSize(SandwichSize.EIGHT_INCH);
        sandwich.setRegularToppings(List.of(new RegularTopping[]{RegularTopping.LETTUCE, RegularTopping.TOMATOES}));
        sandwich.setPremiumToppings(List.of(new PremiumTopping[]{PremiumTopping.STEAK}));
        sandwich.setSauces(List.of(new SauceType[]{SauceType.MAYO}));
        sandwich.setToasted(true);

        order.addItem(sandwich);

        // Assert that the order contains the sandwich
        assertTrue(order.getItems().contains(sandwich), "The order should contain the sandwich.");
    }
}
