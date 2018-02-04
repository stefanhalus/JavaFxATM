package atm2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class CinciRetragController {

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
    Baza.suma = 100;
    baza.incarcSase();
  }

  @FXML
  void act2(ActionEvent event) {
    Baza.suma = 200;
    baza.incarcSase();
  }

  @FXML
  void act3(ActionEvent event) {
    Baza.suma = 400;
    baza.incarcSase();

  }

  @FXML
  void act4(ActionEvent event) {
    Baza.suma = 500;
    baza.incarcSase();

  }

  @FXML
  void act5(ActionEvent event) {
    Baza.suma = 10;
    baza.incarcSase();

  }

  @FXML
  void act6(ActionEvent event) {
    Baza.suma = 20;
    baza.incarcSase();

  }

  @FXML
  void act7(ActionEvent event) {
    Baza.suma = 50;
    baza.incarcSase();
  }

  @FXML
  void act8(ActionEvent event) {
    baza.incarcCinciAlta();
  }

  void mesaje() {
    String lang;
    lang = "ro";
    msg.set(lang, "lbl1", "100");
    msg.set(lang, "lbl2", "200");
    msg.set(lang, "lbl3", "400");
    msg.set(lang, "lbl4", "500");
    msg.set(lang, "lbl5", "10");
    msg.set(lang, "lbl6", "20");
    msg.set(lang, "lbl7", "50");
    msg.set(lang, "lbl8", "Altă sumă");
    msg.set(lang, "lblTitlu", "Alegeți suma dorită");
    lang = "en";
    msg.set(lang, "lbl1", "100");
    msg.set(lang, "lbl2", "200");
    msg.set(lang, "lbl3", "400");
    msg.set(lang, "lbl4", "500");
    msg.set(lang, "lbl5", "10");
    msg.set(lang, "lbl6", "20");
    msg.set(lang, "lbl7", "50");
    msg.set(lang, "lbl8", "Another amount");
    msg.set(lang, "lblTitlu", "Choose the desired amount");
    lang = "fr";
    msg.set(lang, "lbl1", "100");
    msg.set(lang, "lbl2", "200");
    msg.set(lang, "lbl3", "400");
    msg.set(lang, "lbl4", "500");
    msg.set(lang, "lbl5", "10");
    msg.set(lang, "lbl6", "20");
    msg.set(lang, "lbl7", "50");
    msg.set(lang, "lbl8", "Un autre montant");
    msg.set(lang, "lblTitlu", "Choisissez la quantité désirée");
    lang = "hu";
    msg.set(lang, "lbl1", "100");
    msg.set(lang, "lbl2", "200");
    msg.set(lang, "lbl3", "400");
    msg.set(lang, "lbl4", "500");
    msg.set(lang, "lbl5", "10");
    msg.set(lang, "lbl6", "20");
    msg.set(lang, "lbl7", "50");
    msg.set(lang, "lbl8", "Egy másik összeg");
    msg.set(lang, "lblTitlu", "Válassza ki a kívánt összeget");
  }

  @FXML
  void initialize() {
    msg = new Messages("altaSuma", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lbl1.setText(msg.get("lbl1"));
    lbl2.setText(msg.get("lbl2"));
    lbl3.setText(msg.get("lbl3"));
    lbl4.setText(msg.get("lbl4"));
    lbl5.setText(msg.get("lbl5"));
    lbl6.setText(msg.get("lbl6"));
    lbl7.setText(msg.get("lbl7"));
    lbl8.setText(msg.get("lbl8"));
    lblTitlu.setText(msg.get("lblTitlu"));

  }
}
