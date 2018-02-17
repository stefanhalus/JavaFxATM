package atm2;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class TreiController {

//  Client client = new Client();
  Db db = new Db();
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
    lblPinIncorect.setText("");
  }

  @FXML
  void actOk(ActionEvent event) {
    if (pin.getText().length() == 4) {
      lblPinIncorect.setText("");
      Client client = db.getClientByPin(pin.getText());
      db.jurnalValidarePinIns(pin.getText(), client.getStatus());
      validareStatus(client);
    } else {
      lblPinIncorect.setText(msg.get("lblPinGolValidat"));
    }
  }

  /*
  Metoda permite validarea codurilor pin. 
  Presupunând că avem un card inserat, la 2 introduceri incorecte, acesta se blochează
   */
  private void validareStatus(Client client) {
    switch (client.getStatus()) {
      case 1:
        if (Integer.parseInt(pin.getText()) == client.getPin()) {
          Baza.pin = Integer.toString(client.getPin());
          baza.incarcPatru();
        }
        break;
      case 2:
        scotCardCuMesaj(msg.get("lblPinBlocat"));
//        lblPinIncorect.setText(msg.get("lblPinBlocat"));
//        PauseTransition scotCard = new PauseTransition(Duration.seconds(5));
//        scotCard.setOnFinished(event -> baza.incarcUnu());
//        scotCard.play();
        break;
      case 0:
        Baza.pin = "";
        PinErrors = PinErrors + 1;
        if (PinErrors > 0 && PinErrors < 3) {
          lblPinIncorect.setText(msg.get("lblPinIncorect") + " - " + PinErrors + " / 3");
        } else {
          db.clientiBlochezCard(client.getId());
          lblPinIncorect.setText(msg.get("lblPinBlocat"));
        }
        pin.setText("");
//        scotCardCuMesaj(msg.get("lblCardSuspendat"));
//        lblPinIncorect.setText(msg.get("lblCardSuspendat"));
//        PauseTransition scotCardInvalid = new PauseTransition(Duration.seconds(5));
//        scotCardInvalid.setOnFinished(event -> baza.incarcUnu());
//        scotCardInvalid.play();
        break;
      default:
    }
  }

  private void scotCardCuMesaj(String mesaj) {
    lblPinIncorect.setText(msg.get(mesaj));
    PauseTransition scotCard = new PauseTransition(Duration.seconds(5));
    scotCard.setOnFinished(event -> baza.incarcDoi());
    scotCard.play();
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
    msg.set(lang, "lblPinGolValidat", "Nu puteți valida un pin incorect! \nCodul PIN are 4 caractere.");
    msg.set(lang, "lblCardSuspendat", "Cardul dumneavoastră este suspendat!");
    lang = "en";
    msg.set(lang, "lbl1", "Continue");
    msg.set(lang, "lbl2", "Change");
    msg.set(lang, "lbl3", "Cancel");
    msg.set(lang, "lblTitlu", "Enter your PIN code");
    msg.set(lang, "lblPinIncorect", "incorrect pin entered");
    msg.set(lang, "lblPinBlocat", "");
    msg.set(lang, "lblPinGolValidat", "");
    msg.set(lang, "lblCardSuspendat", "");
    lang = "fr";
    msg.set(lang, "lbl1", "Continuer");
    msg.set(lang, "lbl2", "Coriger");
    msg.set(lang, "lbl3", "Ouvrir");
    msg.set(lang, "lblTitlu", "Entrez le code PIN");
    msg.set(lang, "lblPinIncorect", "Le code pin est incorrect");
    msg.set(lang, "lblPinBlocat", "");
    msg.set(lang, "lblPinGolValidat", "");
    msg.set(lang, "lblCardSuspendat", "");
    lang = "hu";
    msg.set(lang, "lbl1", "Mgerősítés");
    msg.set(lang, "lbl2", "Javítás");
    msg.set(lang, "lbl3", "Törlés");
    msg.set(lang, "lblTitlu", "Adja meg a PIN kódot");
    msg.set(lang, "lblPinIncorect", "A fenyő kód helytelen");
    msg.set(lang, "lblPinBlocat", "");
    msg.set(lang, "lblPinGolValidat", "");
    msg.set(lang, "lblCardSuspendat", "");
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
