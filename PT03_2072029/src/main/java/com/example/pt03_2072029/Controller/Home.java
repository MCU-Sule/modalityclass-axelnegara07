package com.example.pt03_2072029.Controller;

import com.example.pt03_2072029.CoffeeShopApplication;
import com.example.pt03_2072029.Model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
    @FXML
    private ListView<Menu> listView;
    @FXML
    private ObservableList<Menu> mlist;
    private Stage stage;

    public void initialize() {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        mlist = FXCollections.observableArrayList(
                new Menu("Kopi Sianida", 7000, 80),
                new Menu("Teh Espresso", 32000, 0),
                new Menu("Lepepet", 15000, 0),
                new Menu("Blue Tea", 25000, 50),
                new Menu("Es Elixir", 15000, 0),
                new Menu("Hot Bobaciattho", 25000, 30)
        );
        listView.setItems(mlist);
    }
    public void AddHome(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CoffeeShopApplication.class.getResource("form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 280, 260);
        stage.setTitle("Form View");
        stage.setScene(scene);

        stage.showAndWait();
        Form addController = fxmlLoader.getController();
        if (addController.getNamaKembali() != null || addController.getHargaKembali() != 0.0) {
            mlist.add(new Menu(addController.getNamaKembali(), addController.getHargaKembali(), addController.getDiscountKembali() * 100));
        }
    }

    public void OnClick(MouseEvent mouseEvent) {
        if(!listView.getSelectionModel().getSelectedItems().isEmpty()) {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem menuItem = new MenuItem("Delete");
            menuItem.setOnAction((ActionEvent actionEvent) -> {
                listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
            });

            contextMenu.getItems().add(menuItem);
            listView.setContextMenu(contextMenu);
        }
    }
}