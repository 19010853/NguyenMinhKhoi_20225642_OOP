package Store;

import DVD.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int nbItems;

    // Constructor to initialize the store with a specified size
    public Store(int storeSize) {
        itemsInStore = new DigitalVideoDisc[storeSize];
        nbItems = 0;
    }

    // Add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore[nbItems] = dvd;
        nbItems++;
        System.out.println("DVD " + dvd.getId() + " have successfully added to the store.");
    }

    // Remove a DVD from the store
    public void removeDVD(int id) {
        boolean rightID = false;
        for (int i = 0; i < nbItems; i++) {
            if (itemsInStore[i].getId() == id) {
                // Shift the remaining DVDs to the left to remove the DVD
                for (int j = i; j < nbItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[nbItems - 1] = null; // Nullify the last item
                nbItems--;
                rightID = true;
                System.out.println("DVD with ID " + id + " have succesfully removed from the store.");
                break;
            }
        }
        if (!rightID) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Method to display all DVDs in the store
    public void displayStore() {
        if (nbItems == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("********** DVDs in Store **********");
            for (int i = 0; i < nbItems; i++) {
                System.out.println(i + 1 + ". " + itemsInStore[i].getTitle());
            }
            System.out.println("***********************************");
        }
    }
}
