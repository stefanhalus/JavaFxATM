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
public class NouaController {

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
    msg.set(lang, "lblMessage", "Vă mulțumim că ați apelat la serviciile băncii noastre!");
    lang = "en";
    msg.set(lang, "lblMessage", "Thank you for calling on our bank services!");
    lang = "fr";
    msg.set(lang, "lblMessage", "Merci d'avoir fait appel à nos services bancaires!");
    lang = "hu";
    msg.set(lang, "lblMessage", "Köszönjük, hogy felszólította bankjainkat!");
  }

  @FXML
  void initialize() {
    msg = new Messages("chitanta", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lblMessage.setText(msg.get("lblMessage"));

    PauseTransition multumim = new PauseTransition(Duration.seconds(7));
    multumim.setOnFinished(event -> baza.incarcUnu());
    multumim.play();
  }

}
