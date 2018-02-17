package atm2;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Baza extends Application {

  // Definim variabile esențiale pentru aplicație
  Stage fereastra;
  static String pin;
  static String limba;
  static int suma;
  static Boolean chitanta;
  static String tema;

  // Definim controlerele paginilor
  UnuController ctrUnu;
  DoiController ctrDoi;
  TreiController ctrTrei;
  PatruController ctrPatru;
  CinciAltaController ctrCinciAlta;
  CinciRetragController ctrCinciRetrag;
  CinciSoldController ctrCinciSold;
  CinciJurnalController ctrCinciJurnal;
  SaseController ctrSase;
  SapteController ctrSapte;
  OptController ctrOpt;
  NouaController ctrNoua;

  @Override
  public void start(Stage primaryStage) {
    Locale.setDefault(new Locale("ro", "RO"));
    DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
    unusualSymbols.setDecimalSeparator(',');
    // Încărcare accesibilitate
    Settings setting;
    try {
      File file = new File("src/atm2/files/settings.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      setting = (Settings) jaxbUnmarshaller.unmarshal(file);
      Baza.tema = setting.getTheme();
    } catch (JAXBException e) {
      e.printStackTrace();
      Baza.tema = "original";
    }

    // Instanțiem valori inițiale
    Baza.limba = "ro";
    Baza.pin = "1554";
    Baza.suma = 0;
    Baza.chitanta = false;
    fereastra = primaryStage;

    try {
      fereastra.getIcons().add(new Image(Baza.class.getResourceAsStream("img/atm.png")));
      fereastra.setTitle("ATM");
      incarcUnu();
      fereastra.show();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // afișează ecranul de intrare
  public void incarcUnu() {
    // Resetăm aspectul al cel original
    SettingsControl settings = new SettingsControl();
    settings.save("theme", "original");
    Baza.tema = "original";

    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("unu.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrUnu = loader.getController();
    ctrUnu.baza = this;
  }

  // afișează pagina de selectare a limbii
  public void incarcDoi() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("doi.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrDoi = loader.getController();
    ctrDoi.baza = this;
  }

  // afișează pagina de introducere a codului pin
  public void incarcTrei() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("trei.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrTrei = loader.getController();
    ctrTrei.baza = this;
  }

  // afișează pagina de alegere a operațiunii dorite
  public void incarcPatru() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("patru.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrPatru = loader.getController();
    ctrPatru.baza = this;
  }

  // afișează pagina de verificare a soldului rămas
  public void incarcCinciSold() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciSold.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciSold = loader.getController();
    ctrCinciSold.baza = this;
  }

  // afișează pagina de jurnal retrageri (ultimele 10 intrări)
  public void incarcCinciJurnalRetrageri() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciJurnal.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciJurnal = loader.getController();
    ctrCinciJurnal.baza = this;
  }

  // afișează ecrandul cu opțiunile de alegere a sumelor retrase
  public void incarcCinciRetrag() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciRetrag.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciRetrag = loader.getController();
    ctrCinciRetrag.baza = this;
  }

  // ecran de introducere a unei nume nemenționate în ecranul anterior
  public void incarcCinciAlta() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("cinciAlta.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrCinciAlta = loader.getController();
    ctrCinciAlta.baza = this;
  }

  // ecran de de solicitare a tipăririi chitanței
  public void incarcSase() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("sase.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrSase = loader.getController();
    ctrSase.baza = this;
  }

  // ecran de procesare a tranzacțiilor
  public void incarcSapte() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("sapte.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrSapte = loader.getController();
    ctrSapte.baza = this;
  }

  // ecran de eliberare etapizată a resurselor
  public void incarcOpt() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("opt.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
      fereastra.setScene(scene);
      fereastra.sizeToScene();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    ctrOpt = loader.getController();
    ctrOpt.baza = this;
  }

  // ecran de final, mulțumiri
  public void incarcNoua() {
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("noua.fxml"));
    AnchorPane container;
    try {
      container = (AnchorPane) loader.load();
      Scene scene = new Scene(container);
      // încarcă fișier de stil
      if (tema.equals("dark")) {
        scene.getStylesheets().add(getClass().getResource("css/dark.css").toExternalForm());
      } else {
        scene.getStylesheets().add(getClass().getResource("css/original.css").toExternalForm());
      }
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
