package aims;

import java.util.*;
import Cart.Cart;
import Store.Store;
import aims.media.*;

public class AimsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store(); // Store initialization
        Cart cart = new Cart();   // Cart initialization

        // Add initial items to the store
        initializeStore(store);

        int choice;
        do {
            showMenu();
            choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> storeMenu(scanner, store, cart);
                case 2 -> updateStoreMenu(scanner, store);
                case 3 -> cartMenu(scanner, cart);
                case 0 -> System.out.println("Thank you for using AIMS! Goodbye.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Initialize the store with default items
    private static void initializeStore(Store store) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "Cu Lao Xac Song", "Survival", 4.0f, "Nhat Trung", 93);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Khong Phai Dang Vua Dau", 4));
        tracks.add(new Track("Anh Sai Roi", 3));
        tracks.add(new Track("Am Tham Ben Em", 5));
        CompactDisc cd = new CompactDisc(2, "m-tp MTP", "Vietnamese Pop", 6.3f, "Son Tung M-TP", tracks);

        List<String> authors = new ArrayList<>();
        authors.add("George R.R. Martin");
        Book book = new Book(3, "Game of Thrones", "Fantasy", 3.99f, authors);

        store.addMedia(book);
        store.addMedia(cd);
        store.addMedia(dvd);
    }

    // Display the main menu
    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Get user choice with input validation
    private static int getUserChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    // Store menu operations
    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println("\nStored Items:");
        for (Media media : store.getItemsInStore()) {
            System.out.println(media);
        }

        int choice;
        do {
            displayStoreMenu();
            choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> seeMediaDetails(scanner, store, cart);
                case 2 -> addMediaToCart(scanner, store, cart);
                case 3 -> cart.Print();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void displayStoreMenu() {
        System.out.println("\nStore Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
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
        System.out.println("\nMedia Details Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");

        int choice = getUserChoice(scanner);
        switch (choice) {
            case 1 -> {
                cart.addMedia(media);
                System.out.println("Added to cart: " + media.getTitle());
            }
            case 2 -> {
                if (media instanceof Playable playable) {
                    playable.play();
                } else {
                    System.out.println("This media cannot be played.");
                }
            }
            case 0 -> System.out.println("Returning...");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addMediaToCart(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                cart.addMedia(media);
                System.out.println("Added to cart: " + title);
                return;
            }
        }
    }

    public static void updateStoreMenu(Scanner scanner, Store store) {
        int choice;
        do {
            displayUpdateStoreMenu();
            choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> addMediaToStore(scanner, store);
                case 2 -> removeMediaFromStore(scanner, store);
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void displayUpdateStoreMenu() {
        System.out.println("\nUpdate Store Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void addMediaToStore(Scanner scanner, Store store) {
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

    public static void removeMediaFromStore(Scanner scanner, Store store) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        for (Media media : store.getItemsInStore()){
            if (media.getTitle().equals(title) && media instanceof Playable){
                ((Playable) media).play();
            }
        }
        System.out.println("Media not found or unplayable!");
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        int choice;
        do {
            displayCartMenu();
            choice = getUserChoice(scanner);
            switch (choice) {
                case 1 -> filterMediaInCart(scanner, cart);
                case 2 -> sortMediaInCart(scanner, cart);
                case 3 -> removeMediaFromCart(scanner, cart);
                case 4 -> playMediaInCart(scanner, cart);
                case 5 -> placeOrder(cart);
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void displayCartMenu() {
        System.out.println("\nCart Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void filterMediaInCart(Scanner scanner, Cart cart) {
        System.out.println("\nFilter Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int filterChoice = getUserChoice(scanner);
        switch (filterChoice) {
            case 1 -> {
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                cart.searchItemsByID(id);
            }
            case 2 -> {
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                cart.searchItemsByTitle(title);
            }
            case 0 -> System.out.println("Returning...");
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void sortMediaInCart(Scanner scanner, Cart cart) {
        System.out.println("\nSort Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title then Cost");
        System.out.println("2. Sort by Cost then Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int sortChoice = getUserChoice(scanner);
        switch (sortChoice) {
            case 1 -> {
                cart.sortByTitleCost();
                cart.Print();
            }
            case 2 -> {
                cart.sortByCostTitle();
                cart.Print();
            }
            case 0 -> System.out.println("Returning...");
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void removeMediaFromCart(Scanner scanner, Cart cart) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart: " + title);
        } else {
            System.out.println("No media found in the cart with the title: " + title);
        }
    }

    public static void playMediaInCart(Scanner scanner, Cart cart) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("This media is not playable or not found in the cart.");
        }
    }

    public static void placeOrder(Cart cart) {
        cart.cartAfterPlaceOrder();
        System.out.println("Total cost is:" + cart.totalCost() + "! Thank you for shopping.");
    }

}
