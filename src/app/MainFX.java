package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** entry point versi GUI (JavaFX) - fitur di luar requirement utama
 layout-nya diatur di FXML, jadi di sini hanya load + tampilin
 */
public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/JavaFXView.fxml"));
        stage.setTitle("KMS Putusan Pengadilan Narkotika");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    public static void main(String[] args) {
        // wajib static, ini yang manggil start() di atas
        launch(args);
    }
}