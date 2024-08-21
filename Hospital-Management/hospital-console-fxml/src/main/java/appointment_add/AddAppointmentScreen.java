package appointment_add;

import common.StageFactory;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddAppointmentScreen {
  public static void showAddAppointmentScreen() throws Exception {
    try {

      Parent actorGroup =
          FXMLLoader.load(
              new URL(
                  "file:///C:\\\\Users\\\\hemag\\\\eclipse-workspace\\\\/hospital-console/src/main/java/appointment_add/AddAppointment.fxml"));
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
