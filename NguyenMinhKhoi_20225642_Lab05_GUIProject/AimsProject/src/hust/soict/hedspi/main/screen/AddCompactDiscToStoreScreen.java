package hust.soict.hedspi.screen;

import AimsProject.src.hust.soict.hedspi.main.Cart.Cart;
import AimsProject.src.hust.soict.hedspi.main.Store.Store;
import AimsProject.src.hust.soict.hedspi.main.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    public AddCompactDiscToStoreScreen(Store store, Cart cart, CompactDisc compactDisc) {
        super(store,cart,compactDisc);
    }
}
