package patient_edit;

import common.StageFactory;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PatientEditScreen {
  public static void showPatientEditScreen() throws Exception {
    try {

      Parent actorGroup =
          FXMLLoader.load(
              new URL(
                  "file:///C:\\\\Users\\\\hemag\\\\eclipse-workspace\\\\/hospital-console/src/main/java/patient_edit/EditPatient.fxml"));
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
