/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author stefa
 */
public class Messages {

  private Map<String, String> pin = new HashMap<String, String>();
  private String lng;
  private String pg;

  public Messages(String pg, String lng) {
    this.pg = pg;
    this.lng = lng;
  }

  public void set(String lang, String item, String val) {
    pin.put(pg + lang + item, val);
    this.lng = lng;
  }

  public String get(String item) {
    return pin.get(pg + lng + item);
  }

  public void saveFile(String neValue, Boolean append ) {
    String file = "src/atm2/bani.txt";
    try {
      if (append == false) {
        Files.write(Paths.get(file), neValue.getBytes());
      } else if (append == true) {
        FileWriter fileWritter = new FileWriter(file, true);
        BufferedWriter bwr = new BufferedWriter(fileWritter);
        bwr.write(neValue);
        bwr.close();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public String readFile() {
    String content = "";
    try {
      content = new String(Files.readAllBytes(Paths.get("src/atm2/bani.txt")));
    } catch (IOException ex) {
      content = ex.getMessage();
    }
    return content;
  }
}
