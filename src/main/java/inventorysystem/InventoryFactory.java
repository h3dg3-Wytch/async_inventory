package inventorysystem;

import java.util.concurrent.TimeUnit;

public class InventoryFactory implements Runnable{

    private Inventory inventory;
    private int unitsToBeProduced;

    public InventoryFactory(Inventory inventory, int unitsToBeProduced) {
        this.inventory = inventory;
        this.unitsToBeProduced = unitsToBeProduced;
    }

    public void addToInventory(int number){

        System.out.println("\nAdding " + number + " units to inventory!");
        inventory.addToInventory(number);
        System.out.println("Inventory is now at " + inventory.getAmountOfWidgets() + " units");

    }

    public void run() {
        System.out.println("Inventory Factory is online, we will now begin the creation of widgets. First will come in 1");
        while(true){
            try{
                TimeUnit.SECONDS.sleep(1);
                addToInventory(unitsToBeProduced);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
