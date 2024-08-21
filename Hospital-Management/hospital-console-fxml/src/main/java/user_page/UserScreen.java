package user_page;

import common.StageFactory;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UserScreen {
  public static void showUserScreen() throws Exception {
    try {

      Parent actorGroup =
          FXMLLoader.load(
              new URL(
                  "file:///C:\\\\Users\\\\hemag\\\\eclipse-workspace\\\\/hospital-console/src/main/java/user_page/UserScreen.fxml"));
      StageFactory.stage.setTitle("Customer Login");
      Scene scene = new Scene(actorGroup, 1000, 400);
      StageFactory.stage.setScene(scene);
      StageFactory.stage.setFullScreen(true);
      StageFactory.stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
