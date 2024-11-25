package test.store;

import DVD.DigitalVideoDisc;
import Store.Store;

public class StoreTest {
    public static void main(String[] args) {

        // Make DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 14.99f);

        // Create a store a capacity of 4 DVDs
        Store store = new Store(4);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Display the DVDs in the store
        store.displayStore();

        // Remove a DVD by ID and display the store again
        store.removeDVD(dvd2.getId()); // Removing the second DVD
        store.displayStore();

        // Remove an undefined DVD
        store.removeDVD(97);
    }
}
