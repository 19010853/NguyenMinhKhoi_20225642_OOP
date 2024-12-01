package Cart;
import aims.media.*;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media item){
        if (itemsOrdered.contains(item)) {
            System.out.println(item.getTitle() + " has already in the cart!");
        } else {
            itemsOrdered.add(item);
            System.out.println(item.getTitle() + " has succesfully added to the cart!");
        }
    }

    public void removeMedia(Media item){
        if (!itemsOrdered.contains(item)) {
            System.out.println(item.getTitle() + " is not in the cart");
        } else {
            itemsOrdered.remove(item);
            System.out.println(item.getTitle() + " has succesfully removed from the cart!");
        }
    }

    //Function which calculate total cost
    public float totalCost() {
        float sum = 0.00f;
        for(Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    //Print function
    public void Print(){
        StringBuilder output = new StringBuilder();

        output.append("***********************CART***********************\n");
        output.append("Ordered Items:\n");
        int i = 1;
        for (Media item : itemsOrdered){
            output.append(String.format("%d. [%s] - [%s] - [%s] - [%d]: %.2f $\n",
                    i,
                    item.getTitle(),
                    item.getCategory(),
                    item.getCost()
                    ));
            i++;
        }
        output.append("Total cost: ").append("[").append(totalCost()).append("]");
        System.out.println(output.toString());
    }
}
