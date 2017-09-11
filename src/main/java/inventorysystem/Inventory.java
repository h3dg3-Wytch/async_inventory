package inventorysystem;

public class Inventory {

    private volatile int amountOfWidgets;

    public Inventory(){
        this.amountOfWidgets = 0;
    }

    public synchronized void addToInventory(int number){
            this.amountOfWidgets += number;
    }

    public synchronized boolean retrieveFromInventory(int number){

            if(number > amountOfWidgets){
                return false;
            }

            this.amountOfWidgets -= number;
            return true;
    }

    @Override
    public String toString() {
        return "Amount of Widgets in Stock: " + amountOfWidgets;
    }

    public int getAmountOfWidgets() {
        return amountOfWidgets;
    }


}
