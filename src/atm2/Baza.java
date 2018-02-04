/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author stefa
 */
public class Baza extends Application {

  Stage fereastra;
  static String pin;
  static String limba;
  static int suma;
  static Boolean chitanta;
  UnuController ctrUnu;
  DoiController ctrDoi;
  TreiController ctrTrei;
  PatruController ctrPatru;
  CinciAltaController ctrCinciAlta;
  CinciRetragController ctrCinciRetrag;
  CinciSoldController ctrCinciSold;
  SaseController ctrSase;
  SapteController ctrSapte;
  OptController ctrOpt;
  NouaController ctrNoua;

  @Override
  public void start(Stage primaryStage) {
    Baza.limba = "ro";
    Baza.pin = "2121";
    Baza.suma = 0;
    Baza.chitanta = false;
    fereastra = primaryStage;
    try {
      fereastra.setTitle("ATM");
      incarcUnu();
      fereastra.show();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void incarcUnu() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("unu.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrUnu = loader.getController();
    ctrUnu.baza = this;
  }

  public void incarcDoi() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("doi.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrDoi = loader.getController();
    ctrDoi.baza = this;
  }

  public void incarcTrei() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("trei.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrTrei = loader.getController();
    ctrTrei.baza = this;
  }

  public void incarcPatru() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("patru.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrPatru = loader.getController();
    ctrPatru.baza = this;
  }

  public void incarcCinciSold() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciSold.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciSold = loader.getController();
    ctrCinciSold.baza = this;
  }

  public void incarcCinciRetrag() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciRetrag.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciRetrag = loader.getController();
    ctrCinciRetrag.baza = this;
  }

  public void incarcCinciAlta() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciAlta.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciAlta = loader.getController();
    ctrCinciAlta.baza = this;
  }

  public void incarcSase() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("sase.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrSase = loader.getController();
    ctrSase.baza = this;
  }

  public void incarcSapte() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("sapte.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrSapte = loader.getController();
    ctrSapte.baza = this;
  }

  
  public void incarcOpt() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("opt.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrOpt = loader.getController();
    ctrOpt.baza = this;
  }

  
  public void incarcNoua() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("noua.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrNoua = loader.getController();
    ctrNoua.baza = this;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
