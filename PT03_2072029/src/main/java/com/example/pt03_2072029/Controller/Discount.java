package com.example.pt03_2072029.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Discount {
    @FXML
    private TextField txtDiskon;
    private float nilaiDisc;

    public void OnDisc(ActionEvent actionEvent) {
        setNilaiDisc(Float.parseFloat(txtDiskon.getText()));
        txtDiskon.getScene().getWindow().hide();
    }

    public float getNilaiDisc() {
        return nilaiDisc;
    }

    public void setNilaiDisc(float nilaiDisc) {
        this.nilaiDisc = nilaiDisc;
    }
}