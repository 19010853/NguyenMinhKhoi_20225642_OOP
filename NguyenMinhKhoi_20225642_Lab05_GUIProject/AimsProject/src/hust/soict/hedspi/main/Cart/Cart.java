package Cart;
import aims.media.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

    public Media findMediaByTitle(String title){
        for (Media media : itemsOrdered){
            if (media.getTitle().equals(title)){
                return media;
            }
        }
        return null;
    }

    //Function which search items by ID
    public void searchItemsByID(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) { // Kiểm tra nếu ID khớp
                System.out.println("Result for ID " + id + ":\n");
                System.out.println(String.format("[%d] - [%s] - [%s]: %.2f $\n",
                        item.getId(),
                        item.getTitle(),
                        item.getCategory(),
                        item.getCost()
                ));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID " + id + "!");
        }
    }


    //Function which search items by Title
    public void searchItemsByTitle(String title) {
        StringBuilder output = new StringBuilder();
        boolean rightTitle = false;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media item = itemsOrdered.get(i);
            if (item.getTitle().equalsIgnoreCase(title)) {
                output.append("Result for Title ").append(item.getTitle()).append(":\n");
                output.append(String.format("[%d] - [%s] - [%s]: %.2f $\n",
                        item.getId(),
                        item.getTitle(),
                        item.getCategory(),
                        item.getCost()
                ));
                rightTitle = true;
                break;
            }
        }
        if (!rightTitle) {
            output.append("No DVD found!\n");
        }
        System.out.println(output.toString());
    }

    //Function which sort by title cost
    public void sortByTitleCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    //Function which sort by cost title
    public void sortByCostTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
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
            output.append(String.format("%d. [%s] - [%s]: %.2f $\n",
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

    //Remove All Items after Place Order
    public void cartAfterPlaceOrder(){
        itemsOrdered.removeAll(itemsOrdered);
    }
}
