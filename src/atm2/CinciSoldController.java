/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author stefa
 */
public class CinciSoldController {

  Baza baza;
  Messages msg;

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private Rectangle welcome;

  @FXML
  private Label lbl1;

  @FXML
  private Button btn5;

  @FXML
  private Button btn8;

  @FXML
  private Button btn6;

  @FXML
  private Button btn7;

  @FXML
  private Button btn1;

  @FXML
  private Button btn2;

  @FXML
  private Button btn3;

  @FXML
  private Button btn4;

  @FXML
  private Label lblTitlu;

  @FXML
  private Label lbl2;

  @FXML
  private Label lbl3;

  @FXML
  private Label lbl4;

  @FXML
  private Label lbl8;

  @FXML
  private Label lbl7;

  @FXML
  private Label lbl6;

  @FXML
  private Label lbl5;

  @FXML
  private Label lblSold;

  @FXML
  void act1(ActionEvent event) {
    baza.incarcPatru();
  }

  @FXML
  void act2(ActionEvent event) {

  }

  @FXML
  void act3(ActionEvent event) {

  }

  @FXML
  void act4(ActionEvent event) {
    baza.incarcUnu();
  }

  @FXML
  void act5(ActionEvent event) {

  }

  @FXML
  void act6(ActionEvent event) {

  }

  @FXML
  void act7(ActionEvent event) {

  }

  @FXML
  void act8(ActionEvent event) {

  }

  void mesaje() {
    String lang;
    lang = "ro";
    msg.set(lang, "lbl1", "Altă tranzacție");
    msg.set(lang, "lbl4", "Scoatere card");
    msg.set(lang, "lblTitlu", "Verificare sold");
    msg.set(lang, "lblSold", "Sold disponibil: \n");
    lang = "en";
    msg.set(lang, "lbl1", "Another transaction");
    msg.set(lang, "lbl4", "Card withdrawal");
    msg.set(lang, "lblTitlu", "Check your hip");
    msg.set(lang, "lblSold", "Balance available: \n");
    lang = "fr";
    msg.set(lang, "lbl1", "Une autre transaction");
    msg.set(lang, "lbl4", "Retrait de la carte");
    msg.set(lang, "lblTitlu", "Vérifiez votre hanche");
    msg.set(lang, "lblSold", "Solde disponible: \n");
    lang = "hu";
    msg.set(lang, "lbl1", "Egy másik tranzakció");
    msg.set(lang, "lbl4", "Kártya visszavonása");
    msg.set(lang, "lblTitlu", "Ellenőrizze csípőjét");
    msg.set(lang, "lblSold", "Rendelkezésre álló egyenleg");
  }

  @FXML
  void initialize() {
    msg = new Messages("sold", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lbl1.setText(msg.get("lbl1"));
    lbl4.setText(msg.get("lbl4"));
    lblTitlu.setText(msg.get("lblTitlu"));
    String soldCurent = "";
    try {
      soldCurent = msg.readFile();
    } catch (Exception ex) {
    }
    lblSold.setText(msg.get("lblSold") + soldCurent);
  }

}
