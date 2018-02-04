package atm2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class UnuController {

  Baza baza;
  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private Rectangle welcome;

  @FXML
  private ImageView im1;

  @FXML
  void intra(MouseEvent event) {
    baza.incarcDoi();
  }

}
