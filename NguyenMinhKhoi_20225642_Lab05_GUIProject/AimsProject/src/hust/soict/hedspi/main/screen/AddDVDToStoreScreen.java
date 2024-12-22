package hust.soict.hedspi.screen;

import AimsProject.src.hust.soict.hedspi.main.Cart.Cart;
import AimsProject.src.hust.soict.hedspi.main.Store.Store;
import AimsProject.src.hust.soict.hedspi.main.aims.media.DigitalVideoDisc;

public class AddDVDToStoreScreen extends AddItemToStoreScreen{
    public AddDVDToStoreScreen(Store store, Cart cart, DigitalVideoDisc dvd) {
        super(store,cart,dvd);
    }
}
