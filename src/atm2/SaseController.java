/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;

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
public class SaseController {

  Baza baza;
  Messages msg;

  @FXML
  private Rectangle welcome;
  @FXML
  private Label lblTitlu;
  @FXML
  private Button btn1;
  @FXML
  private Button btn2;
  @FXML
  private Button btn3;
  @FXML
  private Button btn4;
  @FXML
  private Button btn5;
  @FXML
  private Button btn6;
  @FXML
  private Button btn7;
  @FXML
  private Button btn8;
  @FXML
  private Label lbl1;
  @FXML
  private Label lbl2;
  @FXML
  private Label lbl3;
  @FXML
  private Label lbl4;
  @FXML
  private Label lbl5;
  @FXML
  private Label lbl6;
  @FXML
  private Label lbl7;
  @FXML
  private Label lbl8;

  @FXML
  private void act1(ActionEvent event) {
    Baza.chitanta = true;
    baza.incarcSapte();
  }

  @FXML
  private void act2(ActionEvent event) {
    baza.incarcSapte();
  }

  @FXML
  private void act3(ActionEvent event) {
  }

  @FXML
  private void act4(ActionEvent event) {
  }

  @FXML
  private void act5(ActionEvent event) {
  }

  @FXML
  private void act6(ActionEvent event) {
  }

  @FXML
  private void act7(ActionEvent event) {
  }

  @FXML
  private void act8(ActionEvent event) {
  }

  void mesaje() {
    String lang;
    lang = "ro";
    msg.set(lang, "lblTitlu", "Doriți chitanță");
    msg.set(lang, "lbl1", "Da");
    msg.set(lang, "lbl2", "Nu");
    lang = "en";
    msg.set(lang, "lblTitlu", "Do you want a receipt");
    msg.set(lang, "lbl1", "Yes");
    msg.set(lang, "lbl2", "No");
    lang = "fr";
    msg.set(lang, "lblTitlu", "Vous voulez un reçu");
    msg.set(lang, "lbl1", "Oui");
    msg.set(lang, "lbl2", "Pas");
    lang = "hu";
    msg.set(lang, "lblTitlu", "Átutalást szeretne");
    msg.set(lang, "lbl1", "Igen");
    msg.set(lang, "lbl2", "Nem");
  }

  @FXML
  void initialize() {
    msg = new Messages("chitanta", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lblTitlu.setText(msg.get("lblTitlu"));
    lbl1.setText(msg.get("lbl1"));
    lbl2.setText(msg.get("lbl2"));

  }
}
