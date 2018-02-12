package atm2;

import java.io.File;
import javafx.scene.control.Alert;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "atm2.Settings")
public class SettingsControl {

  private final String fileName = "src/atm2/files/settings.xml";
  Settings opt = new Settings();

  private void optionSet(String option, String value) {
    switch (option) {
      case "theme":
        opt.setTheme(value);
        break;
    }
    opt.setXxx("aaa");
    opt.setYyy("bbb");
    opt.setZzz("ccc");
  }

  public void save(String option, String value) {
    File file;
//    optionSet(option, value);
    opt.setTheme(value);
    try {
      file = new File(fileName);
      JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(opt, file);
      // Mesaj de confirmare a salvării
//      Alert alert = new Alert(Alert.AlertType.INFORMATION);
//      alert.setTitle("Succes");
//      alert.setHeaderText("Datele au fost salvate");
//      alert.setContentText("Infromațiile trimise au fost salvate fără probleme. \nVă rugăm să reporniți aplicația pentru a avea efect modificările făcut!");
//      alert.showAndWait();
    } catch (JAXBException e) {
      e.printStackTrace();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Could not save data");
      alert.setContentText("Could not save data to file: \n\n\n" + e.getCause().toString());
      alert.showAndWait();
    }
  }

  public Settings read() {
    Settings setting;
    try {
      File file = new File(fileName);
      JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      setting = (Settings) jaxbUnmarshaller.unmarshal(file);
//      System.out.println(customer);
    } catch (JAXBException e) {
      e.printStackTrace();
      setting = null;
    }
    return setting;
  }

}
