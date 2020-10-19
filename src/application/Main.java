package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MenuView;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        MenuView menuView = new MenuView();

        Scene scene = new Scene(menuView.getRootLayout());

        stage.setHeight(720);
        stage.setWidth(1280);
        stage.setTitle("Self Balancing Robot User Interface");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
