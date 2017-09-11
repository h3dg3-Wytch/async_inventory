package inventorysystem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        if(args.length != 3){
            System.out.println("Please enter the correct parameters! java -jar filename TimeForTheFactory TimeFortheOrder");
        }else{
            try {
                String fileName = args[0];
                int factoryTime = Integer.parseInt(args[1]);
                int orderTime = Integer.parseInt(args[2]);

                Inventory inventory = new Inventory();
                new Thread(new InventoryFactory(inventory, factoryTime)).start();
                new Thread(new OrderManager(inventory, orderTime, fileName)).start();
            }catch (NumberFormatException e){
                System.out.println("Please enter the correct parameters! It seems your numbers are off!");
            }
        }
    }
}
