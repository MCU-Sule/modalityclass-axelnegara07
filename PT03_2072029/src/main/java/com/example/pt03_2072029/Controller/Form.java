package com.example.pt03_2072029.Controller;

import com.example.pt03_2072029.CoffeeShopApplication;
import com.example.pt03_2072029.Model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Form {
    @FXML
    private ObservableList<String> sList;
    private Stage stage;
    private String namaKembali;
    private float hargaKembali;
    private float discountKembali;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtHarga;
    @FXML
    private ComboBox comboDisc;
    @FXML
    private Button customDisc;




    public void initialize() {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        sList = FXCollections.observableArrayList(
                "0.0",
                "0.1",
                "0.2",
                "0.3",
                "0.4",
                "0.5",
                "0.6",
                "0.7",
                "0.8",
                "0.9");
        comboDisc.setItems(sList);
        comboDisc.getSelectionModel().select(0);
    }
    public void AddDiscount(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CoffeeShopApplication.class.getResource("discount-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 240, 130);
        stage.setTitle("Discount View");
        stage.setScene(scene);

        stage.showAndWait();
        Discount addController = fxmlLoader.getController();
        customDisc.setText(String.valueOf(addController.getNilaiDisc() / 100));

    }

    public String getNamaKembali() {
        return namaKembali;
    }

    public void setNamaKembali(String namaKembali) {
        this.namaKembali = namaKembali;
    }

    public float getHargaKembali() {
        return hargaKembali;
    }

    public void setHargaKembali(float hargaKembali) {
        this.hargaKembali = hargaKembali;
    }

    public float getDiscountKembali() {
        return discountKembali;
    }

    public void setDiscountKembali(float discountKembali) {
        this.discountKembali = discountKembali;
    }


    public void AddMenu(ActionEvent actionEvent) {
        setNamaKembali(txtNama.getText());
        setHargaKembali(Float.parseFloat(txtHarga.getText()));
        if (customDisc.getText().equals("Custom Discount")) {
            setDiscountKembali(Float.parseFloat((String) comboDisc.getValue()));
        } else {
            setDiscountKembali(Float.parseFloat(customDisc.getText()));
        }
        txtNama.getScene().getWindow().hide();
    }
}