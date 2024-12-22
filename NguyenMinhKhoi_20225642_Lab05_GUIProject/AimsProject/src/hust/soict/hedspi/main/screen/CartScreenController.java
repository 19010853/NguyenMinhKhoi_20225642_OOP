package hust.soict.hedspi.screen;

import AimsProject.src.hust.soict.hedspi.main.Cart.Cart;
import AimsProject.src.hust.soict.hedspi.main.Store.Store;
import AimsProject.src.hust.soict.hedspi.main.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.main.aims.media.Playable;
import AimsProject.src.hust.soict.hedspi.main.exception.PlayerException;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.naming.LimitExceededException;
import javax.swing.*;

public class CartScreenController {

    private Store store;
    private Cart cart;


    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    public Label totalCost;

    @FXML
    private float totalCost(){
        return this.cart.totalCost();
    }

    @FXML
    public void PlaceOrder(javafx.event.ActionEvent event) {
        this.cart.removeAll();
        JOptionPane.showMessageDialog(null,"Complete Transaction!");
        totalCost.setText(String.valueOf(totalCost()));
    }


    public CartScreenController(Store store,Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
    }

    @FXML
    void btnPlayPressed(javafx.event.ActionEvent event) {
        Media media=tblMedia.getSelectionModel().getSelectedItem();
        if(media instanceof Playable){
            Playable playable=(Playable)media;
            try {
                playable.play();
            } catch (PlayerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnRemovePressed(javafx.event.ActionEvent event) {
        Media media=tblMedia.getSelectionModel().getSelectedItem();
        try {
            cart.removeMedia(media);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }
        totalCost.setText(String.valueOf(totalCost()));
    }

    @FXML
    void openStoreScreen(javafx.event.ActionEvent event) {
        StoreScreen storeScreen=new StoreScreen(store,cart);
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("Title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));
        tblMedia.setItems(this.cart.getItemsOrderedObservableList());
        totalCost.setText(String.valueOf(totalCost()));
        this.cart.getItemsOrderedObservableList().addListener((ListChangeListener<? super Media>) change -> {
            Platform.runLater(() -> {
                totalCost.setText(String.format("%.2f $", totalCost()));
            });
        } );


    }
}


