package login_screen;

import common.StageFactory;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginScreen {
  public static void showLoginScreen() throws Exception {
    try {

      Parent actorGroup =
          FXMLLoader.load(
              new URL(
                  "file:///C:\\\\Users\\\\hemag\\\\eclipse-workspace\\\\/hospital-console/src/main/java/login_screen/LoginHospitalManagement.fxml"));
      StageFactory.stage.setTitle("Customer Login");
      Scene scene = new Scene(actorGroup, 1000, 400);
      StageFactory.stage.setScene(scene);
      StageFactory.stage.setFullScreen(true);
      StageFactory.stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} // fx:controller="login_screen.LoginScreenController"
