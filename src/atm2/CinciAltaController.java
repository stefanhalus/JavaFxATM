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
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author stefa
 */
public class CinciAltaController {

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
  private TextField lblSold;

  @FXML
  private void act1(ActionEvent event) {
    Baza.suma = Integer.parseInt(lblSold.getText());
    baza.incarcSase();
  }

  @FXML
  private void act2(ActionEvent event) {
    lblSold.setText("");
  }

  @FXML
  private void act3(ActionEvent event) {
  }

  @FXML
  private void act4(ActionEvent event) {
    baza.incarcUnu();
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
    msg.set(lang, "lblTitlu", "Inroduceți suma dorită");
    msg.set(lang, "lbl1", "Continuare");
    msg.set(lang, "lbl2", "Corectare");
    msg.set(lang, "lbl4", "Ieșire");
    lang = "en";
    msg.set(lang, "lblTitlu", "Input the amount you want");
    msg.set(lang, "lbl1", "Continuation");
    msg.set(lang, "lbl2", "Correction");
    msg.set(lang, "lbl4", "Exit");
    lang = "fr";
    msg.set(lang, "lblTitlu", "Entrez le montant que vous voulez");
   msg.set(lang, "lbl1", "Suite");
    msg.set(lang, "lbl2", "Correction");
    msg.set(lang, "lbl4", "Sortie");
    lang = "hu";
    msg.set(lang, "lblTitlu", "Adja meg a kívánt összeget");
    msg.set(lang, "lbl1", "Folytatás");
    msg.set(lang, "lbl2", "Javítás");
    msg.set(lang, "lbl4", "Kijárat");
  }

  @FXML
  void initialize() {
    msg = new Messages("transaction", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lblTitlu.setText(msg.get("lblTitlu"));
    lblSold.setText(msg.get("lblSold"));
    lbl1.setText(msg.get("lbl1"));
    lbl2.setText(msg.get("lbl2"));
    lbl4.setText(msg.get("lbl4"));
  }
}
