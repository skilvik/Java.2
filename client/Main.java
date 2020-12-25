package lesson4.sample.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

//    public static final List<String> USERS_TEST_DATA = List.of("Oleg", "Alexey", "Peter");

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("sample.fxml"));

        Parent root = loader.load();
        primaryStage.setTitle("MyChat");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

        Network network = new Network();
        if (!network.connect()) {
            showNetworkError("", "Failed to connect");
        }

        Controller controller = loader.getController();
        controller.setNetwork(network);

        network.wait(controller);

        primaryStage.setOnCloseRequest(event -> {
//            network.sendMessage("/end");
            network.close();
        });
    }

    public static void showNetworkError(String errorDetails, String errorTitle) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Network Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorDetails);
        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
