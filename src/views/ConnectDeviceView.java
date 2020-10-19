package views;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import controllers.ConnectDeviceController;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.util.Scanner;

public class ConnectDeviceView {

    private final ConnectDeviceController controller;

    private final HBox view = new HBox();
    private final Button connectButton = new Button();
    private final ChoiceBox<String> portBox = new ChoiceBox<>();
    private SerialPort userChosenPort;

    public ConnectDeviceView(ConnectDeviceController controller) {
        this.controller = controller;

        manageHBox();
        this.view.getChildren().addAll(connectButton, portBox);
    }

    public Parent asParent() {
        return view;
    }

    private void manageHBox() {
        manageButton();
        managePortBox();
    }

    private void manageButton() {
        // button styling
        this.connectButton.setText("Connect");
        this.connectButton.setMinSize(100, 30);

        // button event handler
        this.connectButton.setOnAction(e -> {
            if (this.connectButton.getText().equals("Connect")) {
                // establish chosen port
                this.controller.selectPort(this.portBox.getValue());
                this.userChosenPort = this.controller.getSelectedPort();

                // alternate button and portBox
                this.connectButton.setText("Disconnect");
                this.portBox.setDisable(true);

                // establish serial connection with chosen port
                try {
                    if (this.userChosenPort.openPort()) {
                        System.out.println("Successfully establish serial connection with " + this.userChosenPort.getSystemPortName());
                    }
                    handleSerialData();
                } catch (SerialPortInvalidPortException ex) {
                    System.out.println("Failed establishing connection with serial port of name: " + this.userChosenPort.getSystemPortName());
                }
            } else {
                this.connectButton.setText("Connect");
                portBox.setDisable(false);
            }
        });

    }

    private void managePortBox() {
        // portBox styling
        this.portBox.setMinSize(100, 30);

        // portBox items adding
        if (this.portBox.getItems().size() == 0) {
            this.portBox.getItems().add("no available devices");
        } else {
            this.portBox.getItems().addAll(this.controller.getAvailablePorts());
        }
    }

    // TODO: move handling data to Graph Controller or View
    private void handleSerialData() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(userChosenPort.getInputStream());
                int number;
                while (scanner.hasNextLine()) {
                    number = Integer.parseInt(scanner.nextLine());

                }
            }
        };
        thread.start();
    }

}
