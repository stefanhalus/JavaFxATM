package atm2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stefa
 */
public class Db {

  int categ;
  Client client = new Client();
  Connection cnx;

  public Db() {
    connect();
  }

  private void connect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      cnx = DriverManager.getConnection("jdbc:mysql://localhost/atm2?characterEncoding=utf8", "root", "");
    } catch (SQLException e) {
      Alert con = new Alert(Alert.AlertType.ERROR);
      con.setTitle("Înregistrare preparate...");
      con.setHeaderText("Status înregistrare: SQL");
      con.setContentText(e.getMessage());
      Stage stageCon = (Stage) con.getDialogPane().getScene().getWindow();
      stageCon.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      con.showAndWait();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Client getClientByPin(String pin) {
    ResultSet rs;
    try {
//      cnx.setAutoCommit(false);
      String sqlAdd = "SELECT * FROM `carduri` WHERE `pin` = ? ;";
      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
//      pSqlAdd.setString(1, pin);
      pSqlAdd.setInt(1, Integer.parseInt(pin));
      rs = pSqlAdd.executeQuery();

      /// identificăm nr de înregistrări returnate
//      rs.last();
//      int size = rs.getRow();
//      rs.beforeFirst();
      while (rs.next()) {
        client.setId(rs.getInt("id"));
        client.setNume(rs.getString("nume"));
        client.setPin(rs.getInt("pin"));
        client.setStatus(rs.getInt("status"));
        client.setSold(rs.getDouble("sold"));
      }
    } catch (SQLException e) {
      Alert err = new Alert(Alert.AlertType.ERROR);
      err.setTitle("Înregistrare preparate...");
      err.setHeaderText("Status înregistrare: SQL");
      err.setContentText(e.getMessage());
      Stage stageErr = (Stage) err.getDialogPane().getScene().getWindow();
      stageErr.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      err.showAndWait();
      client = null;
      client.setStatus(0);
    }
    return client;
  }

  public void clientiBlochezCard(int id) {
    try {
//      cnx.setAutoCommit(false);
      String sqlAdd = "UPDATE `carduri` SET `status` = 2 WHERE id = ? ;";
      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
      pSqlAdd.setInt(1, id);
      pSqlAdd.executeUpdate();
//      cnx.commit();
    } catch (SQLException e) {
      Alert err = new Alert(Alert.AlertType.ERROR);
      err.setTitle("Înregistrare preparate...");
      err.setHeaderText("Status înregistrare: SQL");
      err.setContentText(e.getMessage());
      Stage stageErr = (Stage) err.getDialogPane().getScene().getWindow();
      stageErr.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      err.showAndWait();
    }
  }

  public void clientiSoldRamas(int pin, Double sold) {
    try {
      String sqlAdd = "UPDATE `carduri` SET `sold` = ? WHERE pin = ? ;";
      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
      pSqlAdd.setDouble(1, sold);
      pSqlAdd.setInt(2, pin);
      pSqlAdd.executeUpdate();
    } catch (SQLException e) {
      Alert err = new Alert(Alert.AlertType.ERROR);
      err.setTitle("Înregistrare preparate...");
      err.setHeaderText("Status înregistrare: SQL");
      err.setContentText(e.getMessage());
      Stage stageErr = (Stage) err.getDialogPane().getScene().getWindow();
      stageErr.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      err.showAndWait();
    }
  }

  public ArrayList<JurnalRetrageri> getJurnalRetrageri(String pin) {
    ArrayList<JurnalRetrageri> listaRetrageri = new ArrayList<>();
    ResultSet rs;
    try {
      String sqlAdd = "SELECT * FROM `jurnalretrageri` WHERE `pin` = ? ORDER BY `data` DESC LIMIT 10;";
      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
      pSqlAdd.setInt(1, Integer.parseInt(pin));
      rs = pSqlAdd.executeQuery();
      while (rs.next()) {
        JurnalRetrageri jr = new JurnalRetrageri();
        jr.setId(rs.getInt("id"));
        jr.setSumaRetrasa(rs.getDouble("sumaRetrasa"));
        jr.setData(rs.getString("data"));
        listaRetrageri.add(jr);
      }
      rs.close();
    } catch (SQLException e) {
      Alert err = new Alert(Alert.AlertType.ERROR);
      err.setTitle("Înregistrare preparate...");
      err.setHeaderText("Status înregistrare: SQL");
      err.setContentText(e.getMessage());
      Stage stageErr = (Stage) err.getDialogPane().getScene().getWindow();
      stageErr.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      err.showAndWait();
      client = null;
      client.setStatus(0);
    }
    return listaRetrageri;
  }

  /*
  Înregistrare retragere în jurnal 
   */
  public void jurnalRetrageri(int pin, Double sumaRetrasa) {
    try {
//      cnx.setAutoCommit(false);
      String sqlAdd = "INSERT INTO `jurnalretrageri` (`pin`, `sumaRetrasa`) VALUES (?, ?) ;";
      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
      pSqlAdd.setInt(1, pin);
      pSqlAdd.setDouble(2, sumaRetrasa);
      pSqlAdd.executeUpdate();
//      cnx.commit();
    } catch (SQLException e) {
      Alert err = new Alert(Alert.AlertType.ERROR);
      err.setTitle("Înregistrare preparate...");
      err.setHeaderText("Status înregistrare: SQL");
      err.setContentText(e.getMessage());
      Stage stageErr = (Stage) err.getDialogPane().getScene().getWindow();
      stageErr.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      err.showAndWait();
    }
  }

  public void jurnalValidarePinIns(String pin, int status) {
    try {
//      cnx.setAutoCommit(false);
      String sqlAdd = "INSERT INTO `jurnalvalidarepin` (`pin`, `status`) VALUES (?, ?) ;";
      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
      pSqlAdd.setInt(1, Integer.parseInt(pin));
      pSqlAdd.setInt(2, status);
      pSqlAdd.executeUpdate();
//      cnx.commit();
    } catch (SQLException e) {
      Alert err = new Alert(Alert.AlertType.ERROR);
      err.setTitle("Înregistrare preparate...");
      err.setHeaderText("Status înregistrare: SQL");
      err.setContentText(e.getMessage());
      Stage stageErr = (Stage) err.getDialogPane().getScene().getWindow();
      stageErr.getIcons().add(new Image(this.getClass().getResource("img/atm.png").toString()));
      err.showAndWait();
    }
  }

//
//  public void jurnalIns() {
//    String nume = denumire.getText();
//    int gram = Integer.parseInt(gramaj.getText());
//    double pretul = Double.parseDouble(pret.getText());
//    String desc = descriere.getText();
//    String sqlAdd = "INSERT INTO `preparate` (`id`, `categorie`, `nume`, `gramaj`, `pret`, `descriere`) VALUES (NULL, ?, ?, ?, ?, ?);";
//    try {
//      cnx.setAutoCommit(false);
//      PreparedStatement pSqlAdd = cnx.prepareStatement(sqlAdd);
//      pSqlAdd.setInt(1, categ);
//      pSqlAdd.setString(2, nume);
//      pSqlAdd.setInt(3, gram);
//      pSqlAdd.setDouble(4, pretul);
//      pSqlAdd.setString(5, desc);
//      pSqlAdd.executeUpdate();
//      cnx.commit();
//    } catch (SQLException e) {
//      Alert query = new Alert(Alert.AlertType.ERROR);
//      query.setTitle("Înregistrare preparate...");
//      query.setHeaderText("Status înregistrare: SQL");
//      query.setContentText(e.toString());
//      query.showAndWait().ifPresent(rs -> {
//      });
//    }
//  }
//
//  private void incarc(int categ) {
//    tabel.getItems().clear();
//    String cda = "select * from preparate where categorie = order by nume";
//// System.out.println("cda: " + cda);
//    ResultSet rs;
//    try {
//      Statement stm;
//      stm = cnx.createStatement();
//      rs = stm.executeQuery(cda);
//      while (rs.next()) {
//        int id = rs.getInt("ID");
//        String nume = rs.getString("NUME");
//        int gramajul = rs.getInt("GRAMAJ");
//        double pretul = rs.getDouble("PRET");
//        String descrierea = rs.getString("DESCRIERE");
//// Creez un obiect din clasa Preparat
//        Preparat p;
//        p = new Preparat(id, nume, gramajul, pretul, descrierea);
//        tabel.getItems().add(p);
//      }
//      stm.close();
//    } catch (SQLException ex) {
//      Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
}
