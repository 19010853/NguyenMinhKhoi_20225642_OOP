package aims;

import Cart.Cart;
import aims.media.*;

public class Aims {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        Media dvd1 = new Media("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);
        Media dvd2 = new Media("Star wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);
        Media dvd3 = new Media("Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);
        Media dvd4 = new Media("Cu Lao Xac Song", "Horror", 12.03f);

        System.out.println("Total cost is: " + Math.round(anOrder.totalCost() * 100.0) / 100.0);

        //Successfully remove dvd1
        anOrder.removeMedia(dvd1);
        System.out.println("Total cost is: " + Math.round(anOrder.totalCost() * 100.0) / 100.0);
        //Not DVD match
        anOrder.removeMedia(dvd4);
    }
}
