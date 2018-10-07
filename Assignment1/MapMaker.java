package Assignment1;

import java.io.File;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;

import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MapMaker extends Application {

	@Override
	public void init() throws Exception {
		super.init();
	}

	public static final String CSS_PATH = "C:\\Users\\hiba\\eclipse-workspace\\WORK\\resources\\resources\\css\\style.css";

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane rootPane = new BorderPane();
		ToolBar toolbar = new ToolBar(new Label("Tool:"), new Separator(), new Label("Options: {}"));
		MapArea mapArea = new MapArea();
		Pane borderPane = new Pane(mapArea);
		borderPane.setStyle("-fx-background-color: Gainsboro");
		borderPane.setPrefSize(0, 150);

		rootPane.setLeft(LeftToolBar.getToolBar(primaryStage));
		rootPane.setTop(TopMenuBar.getMenuBar(primaryStage));
		rootPane.setBottom(toolbar);
		rootPane.setRight(RightDetailEditor.getDetailEditor(primaryStage));
		rootPane.setCenter(mapArea);

		Scene scene = new Scene(rootPane, 800, 600);
		scene.getStylesheets().add(new File(CSS_PATH).toURI().toString());
		primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
			if (e.getCode() == KeyCode.ESCAPE)
				primaryStage.hide();

		});

		primaryStage.setScene(scene);
		primaryStage.setTitle("Map Maker");
		primaryStage.show();

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
