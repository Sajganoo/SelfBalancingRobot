package views;

import controllers.ConnectDeviceController;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import models.ConnectDeviceModel;

public class MenuView {
    ConnectDeviceModel deviceModel = new ConnectDeviceModel();
    ConnectDeviceController deviceController = new ConnectDeviceController(deviceModel);
    ConnectDeviceView deviceView = new ConnectDeviceView(deviceController);

    private final BorderPane root = new BorderPane();

    public MenuView() {
        BorderPane.setAlignment(this.deviceView.asParent(), Pos.CENTER);
        this.root.getChildren().add(this.deviceView.asParent());
    }

    public Pane getRootLayout() {
        return this.root;
    }
}
