package inventorysystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryReader {

    public InventoryReader(){

    }
    public List<Integer> readFile(String filePath) throws FileNotFoundException, IOException, NumberFormatException{

        ArrayList<Integer> integers = new ArrayList<Integer>();
        File file = new File(filePath);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String cleanLine = line.replace(" ","");
                String[] currentLinesNumbers = cleanLine.split(",");

                for(String number : currentLinesNumbers){
                    if(!number.equals(" ")) {
                        int parsedNumber = Integer.parseInt(number);
                        if(parsedNumber <= 0){
                            System.out.println("ERROR: Cannot enter request of zero or less! Skipping the value " + parsedNumber);
                        }else{
                            integers.add(new Integer(parsedNumber));
                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("ERROR: File not found! Please enter a valid inventory file!");
            return null;
        }catch (NumberFormatException e ){
            System.out.println(("ERROR: Bad input file! Please enter a valid inventory file!"));
            return null;
        } catch (IOException e ){
            System.out.println("ERROR: Something went wrong!");
            return null;
        }
        return integers;
    }
}
