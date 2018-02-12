package atm2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class DoiController {

  Baza baza;
  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private Rectangle welcome;

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
  void act1(ActionEvent event) {
    Baza.limba = "ro";
    baza.incarcTrei();
  }

  @FXML
  void act2(ActionEvent event) {
    Baza.limba = "en";
    baza.incarcTrei();
  }

  @FXML
  void act3(ActionEvent event) {
    Baza.limba = "fr";
    baza.incarcTrei();
  }

  @FXML
  void act4(ActionEvent event) {

  }

  @FXML
  void act5(ActionEvent event) {
    Baza.limba = "hu";
    baza.incarcTrei();
  }

  @FXML
  void act6(ActionEvent event) {

  }

  @FXML
  void act7(ActionEvent event) {

  }

  @FXML
  void act8(ActionEvent event) {
    SettingsControl settings = new SettingsControl();
    settings.save("theme", "dark");
    Baza.tema = "dark";
    baza.incarcDoi();
  }

  @FXML
  void initialize() {

  }
}
