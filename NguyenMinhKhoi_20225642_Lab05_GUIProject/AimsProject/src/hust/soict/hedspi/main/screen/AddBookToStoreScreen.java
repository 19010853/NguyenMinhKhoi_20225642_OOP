package hust.soict.hedspi.screen;

import AimsProject.src.hust.soict.hedspi.main.Cart.Cart;
import AimsProject.src.hust.soict.hedspi.main.Store.Store;
import AimsProject.src.hust.soict.hedspi.main.aims.media.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    public AddBookToStoreScreen(Store store, Cart cart, Book book) {
        super(store,cart,book);
    }
}
