package test.cart;

import Cart.Cart;
import aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
                "Roger Allers",87,19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star wars","Science Fiction",
                "Geogre Lucas",87,24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.Print();

        //Test search by ID method
        cart.searchDVDsByID(3);
        cart.searchDVDsByID(97);

        //Test search by Title method
        cart.searchDVDsByTitle("The Lion King");
        cart.searchDVDsByTitle("Thien Ly Oi");
    }
}
