package Store;

import aims.media.*;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media item){
        for (Media checkItem : itemsInStore){
            if (item.equals(checkItem)){
                System.out.println(item.getTitle() + " has already exist!");
            } else {
                itemsInStore.add(item);
                System.out.println(item.getTitle() + " has succesfully added to the store!");
            }
        }
    }

    public void removeMedia(Media item){
        for (Media checkItem : itemsInStore){
            if (!item.equals(checkItem)){
                System.out.println(item.getTitle() + " is not on the store!");
            } else {
                itemsInStore.add(item);
                System.out.println(item.getTitle() + " has succesfully removed to the store!");
            }
        }
    }

    // Generate getter and setter
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }
}
