package inventorysystem;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryTest {


    private Inventory inventory;
    @Before
    public void setUp(){
        this.inventory = new Inventory();
    }


    @Test
    public void TestThatYouCanAddToInventory(){
        inventory.addToInventory(5);
        assertThat(inventory.getAmountOfWidgets(), is(5));

    }

    @Test
    public void TestThatYouCannotDeleteTooFromInventory() {
        inventory.retrieveFromInventory(5);
        assertThat(inventory.getAmountOfWidgets(), is(0));
    }

    @Test
    public void TestThatYouCanRetrieveFromInventory() {
        inventory.addToInventory(10);
        inventory.retrieveFromInventory(5);
        assertThat(inventory.getAmountOfWidgets(), is(5));
    }

}
