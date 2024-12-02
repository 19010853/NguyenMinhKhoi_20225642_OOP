package aims;

import java.util.*;
import Cart.Cart;
import Store.Store;
import aims.media.*;

public class Aims {
    public static void main(String[] args) {

        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Cu Lao Xac Song", "Survival", 3.0f, "Nhat Trung", 93);

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Khong Phai Dang Vua Dau", 4));
        tracks.add(new Track("Anh Sai Roi", 3));
        tracks.add(new Track("Am Tham Ben Em", 5));

        CompactDisc cd = new CompactDisc(2, "m-tp MTP", "Vietnames Pop", 6.3f, "Son Tung M-TP", tracks);

        List<String> authors = new ArrayList<String>();
        authors.add("George R.R. Martin");

        Book book = new Book(3, "Game of Thrones", "Fantasy", 3.99f, authors );

        Scanner scanner = new Scanner(System.in);
        Store store = new Store(); // Initialize your store
        Cart cart = new Cart();   // Initialize your cart

        store.addMedia(book);
        store.addMedia(cd);
        store.addMedia(dvd);

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine()); // Ensure numeric input
            switch (choice) {
                case 1 -> storeMenu(scanner, store, cart);
                case 2 -> updateStoreMenu(scanner, store); // Assuming `Cart` has a print method
                case 3 -> {
                    cart.Print();
                    cartMenu(scanner, cart, store);
                }
                case 0 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Wrong option. Please choose again!");
            }
        } while (choice != 0);
    }

    // Show main menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // View store menu
    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("Stored Items:");
        for (Media media : store.getItemsInStore()) {
            System.out.println(media.toString());
        }

        int choice;
        do {
            displayStoreMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> seeMediaDetails(scanner, store, cart);
                case 2 -> {
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    for (Media media : store.getItemsInStore()) {
                        if (media.getTitle().equals(title)) {
                            cart.addMedia(media);
                            System.out.println("Added to cart: " + title);
                            return;
                        }
                    }
                    System.out.println("Media not found!");
                }
                case 3 -> {
                    System.out.println("Enter the title of media you want to play:");
                    String title = scanner.nextLine();
                    for (Media media : store.getItemsInStore()){
                        if (media.getTitle().equals(title) && media instanceof Playable){
                            ((Playable) media).play();
                        }
                    }
                    System.out.println("Media not found or unplayable!");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Wrong option. Please choose again!");
            }
        } while (choice != 0);
    }

    public static void displayStoreMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void seeMediaDetails(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter the title of the item: ");
        String title = scanner.nextLine();
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                System.out.println(media.toString());
                mediaDetailsMenu(scanner, cart, media);
                return;
            }
        }
        System.out.println("No items match your choice!");
    }

    public static void mediaDetailsMenu(Scanner scanner, Cart cart, Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> cart.addMedia(media);
            case 2 -> {
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media is unplayable!");
                }
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Wrong option. Please choose again!");
        }
    }

    public static void updateStoreMenu(Scanner scanner, Store store) {
        int choice;
        do {
            displayUpdateStoreMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1 -> {
                    System.out.println("Choose type of media you want to choose:");
                    System.out.println("--------------------------------");
                    System.out.println("1. Book");
                    System.out.println("2. Digital Video Disc");
                    System.out.println("3. Compact Disc");
                    System.out.println("0. Back");
                    System.out.println("--------------------------------");
                    System.out.print("Please choose a number: 0-1-2-3: ");
                    int choiceOfType = Integer.parseInt(scanner.nextLine());

                    // Enter id, title, category, cost (whose objects that every types need)
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();

                    switch (choiceOfType){
                        // Book option
                        case 1 -> {
                            System.out.println("Author's name: ");
                            StringBuilder author = new StringBuilder(scanner.nextLine());
                            ArrayList<String> authors = new ArrayList<String>();
                            do {
                                authors.add(author.toString());
                                store.addMedia(new Book(id, title, category, cost, authors));
                            } while (!author.isEmpty());
                        }

                        // DVD option
                        case 2 -> {
                            System.out.print("Director's name: ");
                            String director = scanner.nextLine();
                            System.out.print("DVD's length: ");
                            int length = scanner.nextInt();
                            scanner.nextLine();
                            store.addMedia(new DigitalVideoDisc(id,title,category,cost,director,length));
                        }

                        //Compact Disc option
                        case  3 -> {
                            System.out.println("Artist's name: ");
                            StringBuilder artist = new StringBuilder(scanner.nextLine());
                            System.out.println("Number of tracks: ");
                            int nbOfTracks = scanner.nextInt();
                            scanner.nextLine();
                            ArrayList<Track> tracks = new ArrayList<Track>();

                            for (int i = 0; i < nbOfTracks; i++){
                                System.out.println("Track " + (i+1) + "'s name: " );
                                String trackName = scanner.nextLine();
                                System.out.println("Track " + (i+1) + "'s length: " );
                                int trackLength = Integer.parseInt(scanner.nextLine());
                                tracks.add(new Track(trackName, trackLength));
                            }
                            store.addMedia(new CompactDisc(id, title, category, cost, artist, tracks));
                        }
                    }
                }

                case 2 -> {
                    System.out.println("Enter title's name that you want to delete: ");
                    scanner.nextLine();
                    String titleToDelete = scanner.nextLine();

                    ListIterator<Media> listIterator = store.getItemsInStore().listIterator();
                    boolean removed = false;
                    while (listIterator.hasNext()){
                        Media media = listIterator.next();
                        if (media.getTitle().equals(titleToDelete)){
                            listIterator.remove();
                            System.out.println(media.getClass().getSimpleName() + " '" + media.getTitle() + "' has been removed from the store.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("No media found with title '" + titleToDelete + "'!");
                    }
                }
            }
        } while (choice != 0);
    }

    public static void displayUpdateStoreMenu(){
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu(Scanner scanner, Cart cart, Store store) {
        int choice;
        do {
            displayCartMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Which kind of filter do you want: ");

                    System.out.println("--------------------------------");

                    System.out.println("1. Filter medias by ID");

                    System.out.println("2. Filter medias in title");

                    System.out.println("0. Back");

                    System.out.println("--------------------------------");

                    System.out.println("Please choose a number: 0-1-2");

                    int kindOfFilter = scanner.nextInt();
                    ;
                    scanner.nextLine();
                    if (kindOfFilter == 1) {
                        int id = scanner.nextInt();
                        cart.searchItemsByID(id);
                    } else if (kindOfFilter == 2) {
                        String title = scanner.nextLine();
                        cart.searchItemsByTitle(title);
                    } else if (kindOfFilter == 0) {
                        return;
                    } else {
                        System.out.println("Wrong number. Please choose again!");
                    }
                }

                case 2 -> {
                    System.out.println("Which kind of sort do you want: ");

                    System.out.println("--------------------------------");

                    System.out.println("1. Sort by title cost");

                    System.out.println("2. Sort by cost title");

                    System.out.println("0. Back");

                    System.out.println("--------------------------------");

                    System.out.println("Please choose a number: 0-1-2");

                    int kindOfSort = scanner.nextInt();
                    ;
                    scanner.nextLine();
                    if (kindOfSort == 1) {
                        cart.sortByTitleCost();
                        cart.Print();
                    } else if (kindOfSort == 2) {
                        cart.sortByCostTitle();
                        cart.Print();
                    } else if (kindOfSort == 0) {
                        return;
                    } else {
                        System.out.println("Wrong number. Please choose again!");
                    }
                }

                case 3 -> {
                    System.out.println("Enter the media's title you want to delete: ");
                    String titleToDelete = scanner.nextLine();
                    Media item = cart.findMediaByTitle(titleToDelete);
                    if (item != null) {
                        cart.removeMedia(item);
                    } else {
                        System.out.println("No items in your cart match with the title: " + titleToDelete + "!");
                    }
                }

                case 4 -> {
                    System.out.println("Enter the media's title you want to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media item = cart.findMediaByTitle(titleToPlay);
                    if (item != null) {
                        if (item instanceof DigitalVideoDisc dvd) {
                            dvd.play();
                        } else if (item instanceof CompactDisc cd) {
                            cd.play();
                        } else {
                            System.out.println("No items in your cart match with the title: " + titleToPlay + "!");
                        }
                    }
                }

                case 5 -> {
                    cart.cartAfterPlaceOrder();
                    System.out.println("Thank you for your payment!");
                }
            }

        } while (choice != 0) ;

    }

    public static void displayCartMenu () {

        System.out.println("Options: ");

        System.out.println("--------------------------------");

        System.out.println("1. Filter medias in cart");

        System.out.println("2. Sort medias in cart");

        System.out.println("3. Remove media from cart");

        System.out.println("4. Play a media");

        System.out.println("5. Place order");

        System.out.println("0. Back");

        System.out.println("--------------------------------");

        System.out.println("Please choose a number: 0-1-2-3-4-5");

    }
}
