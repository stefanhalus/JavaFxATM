/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author stefa
 */
public class OptController {

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
  private Label lblMessage;
  @FXML
  private Label lblMessage1;
  @FXML
  private Label lblMessage2;

  @FXML
  private void act1(ActionEvent event) {
  }

  @FXML
  private void act2(ActionEvent event) {
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
    msg.set(lang, "lblMessage", "Vă rugăm să ridicați cardul!");
    msg.set(lang, "lblMessage1", "Vă rugăm să ridicați banii");
    msg.set(lang, "lblMessage2", "Vă rugăm să ridicați chitanța");
    lang = "en";
    msg.set(lang, "lblMessage", "Please pick up the card!");
    msg.set(lang, "lblMessage1", "Please raise your money");
    msg.set(lang, "lblMessage2", "Please pick up the receipt");
    lang = "fr";
    msg.set(lang, "lblMessage", "S'il vous plaît, prenez la carte!");
    msg.set(lang, "lblMessage1", "S'il vous plaît augmenter votre argent");
    msg.set(lang, "lblMessage2", "Veuillez ramasser le reçu");
    lang = "hu";
    msg.set(lang, "lblMessage", "Kérem vegye fel a kártyát!");
    msg.set(lang, "lblMessage1", "Kérlek, emeld fel a pénzedet");
    msg.set(lang, "lblMessage2", "Kérjük, vegye fel az átvételt");

  }

  @FXML
  void initialize() {

    msg = new Messages("chitanta", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lblMessage.setText(msg.get("lblMessage"));
    PauseTransition bani = new PauseTransition(Duration.seconds(5));
    bani.setOnFinished(event -> ridicatiBanii());
    bani.play();

    if (Baza.chitanta == true) {
      PauseTransition chitanta = new PauseTransition(Duration.seconds(2));
      chitanta.setOnFinished(event -> ridicatiChitanta());
      chitanta.play();
    }

    PauseTransition multumim = new PauseTransition(Duration.seconds(5));
    multumim.setOnFinished(event -> baza.incarcNoua());
    multumim.play();
  }

  @FXML
  void ridicatiBanii() {
    lblMessage1.setText(msg.get("lblMessage1"));

  }

  @FXML
  void ridicatiChitanta() {
    lblMessage2.setText(msg.get("lblMessage2"));
  }

}
