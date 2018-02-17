/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author stefa
 */
public class CinciJurnalController {

  Baza baza;
  Db db = new Db();
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
  private TableView<JurnalRetrageri> tvJurnal;

  @FXML
  private ListView<JurnalRetrageri> lvJurnal;

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
    msg.set(lang, "lblTitlu", "Jurnal retrageri");
    msg.set(lang, "lbl1", "Alegeți operațiune");
    msg.set(lang, "lbl4", "Scoatere card");
    lang = "en";
    msg.set(lang, "lblTitlu", "");
    msg.set(lang, "lbl1", "");
    msg.set(lang, "lbl4", "");
    lang = "fr";
    msg.set(lang, "lblTitlu", "");
    msg.set(lang, "lbl1", "");
    msg.set(lang, "lbl4", "");
    lang = "hu";
    msg.set(lang, "lblTitlu", "");
    msg.set(lang, "lbl1", "");
    msg.set(lang, "lbl4", "");

  }

  @FXML
  void initialize() {
// Preluăm lista operațiunilor din jurnal și îl punem în observable list
    List<JurnalRetrageri> list = db.getJurnalRetrageri(Baza.pin);
    ObservableList<JurnalRetrageri> retrageri = FXCollections.observableArrayList(list);
// configurăm coloanele tabelului și populăm cu date
    TableColumn<JurnalRetrageri, String> colId = new TableColumn<>("ID");
    colId.setCellValueFactory(new PropertyValueFactory("id"));
    TableColumn<JurnalRetrageri, String> colSuma = new TableColumn<>("Suma");
    colSuma.setCellValueFactory(new PropertyValueFactory("sumaRetrasa"));
    TableColumn<JurnalRetrageri, String> colData = new TableColumn<>("Data");
    colData.setCellValueFactory(new PropertyValueFactory("data"));
    tvJurnal.getColumns().setAll(colSuma, colData);
    tvJurnal.setItems(retrageri); 
    
    
    //instanțiere mesaje multilingve
    msg = new Messages("jurnal", Baza.limba);
    mesaje();
// Încărcăm etichetele în funcție de limbă
    lbl1.setText(msg.get("lbl1"));
    lbl4.setText(msg.get("lbl4"));
    lblTitlu.setText(msg.get("lblTitlu"));

  }

}
