package aims;

import Cart.Cart;
import DVD.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Cu Lao Xac Song", "Horror", 12.03f);

        System.out.println("Total cost is: " + Math.round(anOrder.totalCost() * 100.0) / 100.0);
        //Successfully remove dvd1
        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.println("Total cost is: " + Math.round(anOrder.totalCost() * 100.0) / 100.0);
        //Not DVD match
        anOrder.removeDigitalVideoDisc(dvd4);
    }
}
