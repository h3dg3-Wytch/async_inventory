package inventorysystem;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderManager implements Runnable{

    private Inventory inventory;
    private InventoryReader reader;

    private String filePath;

    private int time;

    public OrderManager(Inventory inventory, int time, String filePath){
        this.inventory = inventory;
        this.reader = new InventoryReader();
        this.time = time;
        this.filePath = filePath;
    }

    public void run() {
        while (true){
            System.out.println("\nStarting Order Manager, we will being setup by reading the input file\n");
            try {
                List<Integer> integers = reader.readFile(filePath);


                int i = 0;
                while(i < integers.size()) {

                    System.out.println("\nAttempting to retrieve from Inventory...");
                    if (inventory.retrieveFromInventory(integers.get(i))) {
                        System.out.println("Retrieved! Inventory is now at " + inventory.getAmountOfWidgets() + " units. Sending out inventory items!");
                        i++;
                    } else {
                        System.out.println("Cannot retrieve items, waiting for more stock");
                        try {
                            TimeUnit.SECONDS.sleep(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                System.out.println("\nAll orders have been filled! This program will now exit.\n");
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
