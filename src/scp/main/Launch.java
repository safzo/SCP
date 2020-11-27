package scp.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Launch extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Platform.setImplicitExit(true);
		primaryStage.show();
		new LogInWindow().display(primaryStage);
	}

}
