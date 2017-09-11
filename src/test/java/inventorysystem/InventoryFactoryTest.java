package inventorysystem;

import org.junit.Before;
import org.junit.Test;

public class InventoryFactoryTest {


    private Inventory inventory;
    private InventoryFactory inventoryFactory;

    @Before
    public void setUp(){
        this.inventory = new Inventory();
        this.inventoryFactory = new InventoryFactory(this.inventory,5 );
    }

    @Test
    public void TestThreadCreation(){
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }
    }

    @Test
    public void TestThatYouCanAddToInventory(){

        new Thread(inventoryFactory).start();

    }
}
