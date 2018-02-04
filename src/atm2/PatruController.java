package atm2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class PatruController {

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
    baza.incarcCinciRetrag();
  }

  @FXML
  void act2(ActionEvent event) {
    baza.incarcCinciSold();
  }

  @FXML
  void act3(ActionEvent event) {

  }

  @FXML
  void act4(ActionEvent event) {

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
    msg.set(lang, "lbl1", "Retragere numerar");
    msg.set(lang, "lbl2", "Verificare sold");
    msg.set(lang, "lbl3", "");
    msg.set(lang, "lblTitlu", "Alegeți tranzacția dorită");
    lang = "en";
    msg.set(lang, "lbl1", "Cash withdrawal");
    msg.set(lang, "lbl2", "Check your hip");
    msg.set(lang, "lbl3", "");
    msg.set(lang, "lblTitlu", "Choose the desired transaction");
    lang = "fr";
    msg.set(lang, "lbl1", "Retrait en espèces");
    msg.set(lang, "lbl2", "Vérifiez votre hanche");
    msg.set(lang, "lbl3", "");
    msg.set(lang, "lblTitlu", "Choisissez la transaction souhaitée");
    lang = "hu";
    msg.set(lang, "lbl1", "Készpénzfelvétel");
    msg.set(lang, "lbl2", "Ellenőrizze csípőjét");
    msg.set(lang, "lbl3", "");
    msg.set(lang, "lblTitlu", "Válassza ki a kívánt tranzakciót");
  }

  @FXML
  void initialize() {
    msg = new Messages("transaction", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lbl1.setText(msg.get("lbl1"));
    lbl2.setText(msg.get("lbl2"));
    lbl3.setText(msg.get("lbl3"));
    lblTitlu.setText(msg.get("lblTitlu"));
  }
}
