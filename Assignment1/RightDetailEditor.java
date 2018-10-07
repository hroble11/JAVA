package Assignment1;

import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RightDetailEditor {

	private static Stage stage;

	public static VBox getDetailEditor(Stage primaryStage) {
		setStage(primaryStage);

		ListView<?> shapeList = new ListView<Object>();

		VBox vbox = new VBox(shapeList);

		GridPane grid = new GridPane();

		vbox.setPrefSize(275, 65);
		return vbox;

	}

	private static void setStage(Stage stage1) {
		stage = stage1;
	}

	public static Stage getStage() {
		return stage;
	}
}



