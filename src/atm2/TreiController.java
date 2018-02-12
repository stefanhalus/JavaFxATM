package atm2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class TreiController {

  Baza baza;
  Messages msg;
  int PinErrors = 0;

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
  private Label lbl2;

  @FXML
  private Label lbl3;

  @FXML
  private Label lblTitlu;

  @FXML
  private TextField pin;

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
  private Label lblPinIncorect;
  
  @FXML
  void actAnulare(ActionEvent event) {
    baza.incarcUnu();
  }

  @FXML
  void actCorectare(ActionEvent event) {
    pin.setText("");
  }

  @FXML
  void actOk(ActionEvent event) {
    lblPinIncorect.setText("");
    int i = 0;
    if (pin.getText().equals(Baza.pin)) {
      baza.incarcPatru();
    } else if (i > 3) {
      baza.incarcUnu();
    } else {
      PinErrors = PinErrors + 1;
      if (PinErrors > 0 && PinErrors <= 3) {
        lblPinIncorect.setText(msg.get("lblPinIncorect") + " - " + PinErrors + " / 3");
      } else {
        lblPinIncorect.setText(msg.get("lblPinBlocat"));
        Baza.pin = "4551";
      }
      pin.setText("");
    }
  }

  @FXML
  void mesaje() {
    String lang;
    lang = "ro";
    msg.set(lang, "lbl1", "Confirmare");
    msg.set(lang, "lbl2", "Corectare");
    msg.set(lang, "lbl3", "Anulare");
    msg.set(lang, "lblTitlu", "Introduceți codul PIN");
    msg.set(lang, "lblPinIncorect", "Codul pin este incorect");
    msg.set(lang, "lblPinBlocat", "Card blocat. Contacțați banca!");
    lang = "en";
    msg.set(lang, "lbl1", "Continue");
    msg.set(lang, "lbl2", "Change");
    msg.set(lang, "lbl3", "Cancel");
    msg.set(lang, "lblTitlu", "Enter your PIN code");
    msg.set(lang, "lblPinIncorect", "incorrect pin entered");
    msg.set(lang, "lblPinBlocat", "");
    lang = "fr";
    msg.set(lang, "lbl1", "Continuer");
    msg.set(lang, "lbl2", "Coriger");
    msg.set(lang, "lbl3", "Ouvrir");
    msg.set(lang, "lblTitlu", "Entrez le code PIN");
    msg.set(lang, "lblPinIncorect", "Le code pin est incorrect");
    msg.set(lang, "lblPinBlocat", "");
    lang = "hu";
    msg.set(lang, "lbl1", "Mgerősítés");
    msg.set(lang, "lbl2", "Javítás");
    msg.set(lang, "lbl3", "Törlés");
    msg.set(lang, "lblTitlu", "Adja meg a PIN kódot");
    msg.set(lang, "lblPinIncorect", "A fenyő kód helytelen");
    msg.set(lang, "lblPinBlocat", "");
  }

  @FXML
  void initialize() {
    msg = new Messages("pin", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lbl1.setText(msg.get("lbl1"));
    lbl2.setText(msg.get("lbl2"));
    lbl3.setText(msg.get("lbl3"));
    lblTitlu.setText(msg.get("lblTitlu"));
  }
}
