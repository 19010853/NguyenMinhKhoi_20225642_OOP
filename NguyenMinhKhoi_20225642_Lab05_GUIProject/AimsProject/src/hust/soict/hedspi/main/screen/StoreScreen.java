package hust.soict.hedspi.screen;

import AimsProject.src.hust.soict.hedspi.main.Cart.Cart;
import AimsProject.src.hust.soict.hedspi.main.Store.Store;
import AimsProject.src.hust.soict.hedspi.main.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.main.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.main.aims.media.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public static JPanel center=new JPanel();
    JPanel createNorth(Cart cart){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader(cart));
        return north;
    };
    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem add_book = new JMenuItem("Add Book");
        add_book.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Book book= null;
                try {
                    book = new Book(null,null,0);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                AddBookToStoreScreen addBookToStoreScreen = new AddBookToStoreScreen(store,cart,book);
                dispose();
            }
        });
        smUpdateStore.add(add_book);
        JMenuItem add_cd = new JMenuItem("Add CD");
        add_cd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CompactDisc cd = null;
                try {
                    cd = new CompactDisc(null,null,0);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                AddCompactDiscToStoreScreen addCdToStoreScreen = new AddCompactDiscToStoreScreen(store,cart,cd);
                dispose();
            }
        });
        smUpdateStore.add(add_cd);
        JMenuItem add_dvd = new JMenuItem("Add DVD");
        add_dvd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DigitalVideoDisc dvd = null;
                try {
                    dvd = new DigitalVideoDisc(null,null,0);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                AddDVDToStoreScreen addDVDToStoreScreen = new AddDVDToStoreScreen(store,cart,dvd);
                dispose();
            }
        });
        smUpdateStore.add(add_dvd);

        menu.add(smUpdateStore);
        JMenuItem view_store = new JMenuItem("View Store");
        menu.add(view_store);
        JMenuItem view_cart=new JMenuItem("View Cart");
        menu.add(view_cart);
        view_cart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CartScreen cartScreen=new CartScreen(store,cart);
                cartScreen.setDefaultCloseOperation(1);
            }
        });


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    JPanel createHeader(Cart cart){

        JPanel header=new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title=new JLabel("NguyenMinhKhoi_20225642_AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton view_cart=new JButton("View Cart");
        view_cart.setPreferredSize(new Dimension(100,50));
        view_cart.setMaximumSize(new Dimension(100,50));
        view_cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartScreen cartScreen=new CartScreen(store,cart);
                cartScreen.setDefaultCloseOperation(1);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(view_cart);

        return header;
    }
    public void createCenter(){
        center.setLayout(new GridLayout(4,4));
    }
    public StoreScreen(Store store,Cart cart) {

        this.store = store;
        this.cart = cart;
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(createNorth(cart), BorderLayout.NORTH);
        createCenter();
        container.add(center, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1074, 728);
    }

    public static void main(String[] args) throws Exception{
        Store store = new Store();
        Cart cart=new Cart();
        Book book1 = new Book("duong","123",100);
        CompactDisc cd1=new CompactDisc("long","123",200);
        DigitalVideoDisc dvd1=new DigitalVideoDisc("duc","123",300);
        Book book2 = new Book("duy","123",100);
        CompactDisc cd2=new CompactDisc("linh","123",200);
        DigitalVideoDisc dvd2=new DigitalVideoDisc("dung","123",300);
        Book book3 = new Book("huy","123",100);
        CompactDisc cd3=new CompactDisc("hung","123",200);
        DigitalVideoDisc dvd3=new DigitalVideoDisc("cuong","123",300);
        store.addMedia(book1);
        store.addMedia(cd1);
        store.addMedia(dvd1);
        store.addMedia(book2);
        store.addMedia(cd2);
        store.addMedia(dvd2);
        store.addMedia(book3);
        store.addMedia(cd3);
        store.addMedia(dvd3);
        StoreScreen screen = new StoreScreen(store,cart);
    }

}
