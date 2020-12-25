package lesson4.sample.client;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {


    @FXML
    TextArea textArea;

    @FXML
    TextField textField;
    Network network;


//    @FXML
//    public ListView<String> usersList;
//
//    @FXML
//    public void initialize() {
//        usersList.setItems(FXCollections.observableArrayList(Main.USERS_TEST_DATA));
//    }

    @FXML
    private void send() {
        String message = textField.getText();
        appendMessage("Я: " + message);
        textField.clear();

        try {
            network.send(message);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Failed to send message";
            Main.showNetworkError(e.getMessage(), errorMessage);
        }
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void appendMessage(String message) {
        textArea.appendText(message);
        textArea.appendText(System.lineSeparator());
    }


}