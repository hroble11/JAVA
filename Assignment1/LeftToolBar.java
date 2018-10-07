package Assignment1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class LeftToolBar {

	private static Stage stage;

	public static ToolBar getToolBar(Stage primaryStage) {
		setStage(primaryStage);
		ToolBar tools = new ToolBar();

		Button button = new Button("");
		button.setId("Select");

		Button button1 = new Button("");
		button1.setId("Move");
		
		MenuButton menuButton = new MenuButton("", null, createMenuItem("Line", (e) -> {
			ToolState.getState().setTool(Tools.ROOM);
			ToolState.getState().setOption(2);
		}), createMenuItem("Triangle", (e) -> {
			ToolState.getState().setTool(Tools.ROOM);
			ToolState.getState().setOption(3);
		}), createMenuItem("Rectangle", (e) -> {
			ToolState.getState().setTool(Tools.ROOM);
			ToolState.getState().setOption(4);
		}), createMenuItem("Pentagon", (e) -> {
			ToolState.getState().setTool(Tools.ROOM);
			ToolState.getState().setOption(5);
		}), createMenuItem("Hexagon", (e) -> {
			ToolState.getState().setTool(Tools.ROOM);
			ToolState.getState().setOption(6);
		}));

		menuButton.setId("Room");

		Button button3 = new Button("");
		button3.setId("Erase"); // (e) -> toolState.State().Tool(Tools.Erase));

		Button button4 = new Button("");
		button4.setId("Path");
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {

			}
		});
		Button button5 = new Button("");
		button5.setId("Door");
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {

			}
		});

		tools.getItems().add(button);
		tools.getItems().add(button1);
		tools.getItems().add(menuButton);
		tools.getItems().add(button3);
		tools.getItems().add(button4);
		tools.getItems().add(button5);
		tools.getItems().add(new Separator());
		tools.setPrefSize(60, 50);
		tools.setOrientation(Orientation.VERTICAL);

		return tools;

	}

	private static MenuItem createMenuItem(String name, EventHandler<ActionEvent> handler) {
		Label icon = new Label();
		icon.setId(name + "-icon");
		MenuItem item = new MenuItem(name, icon);
		item.setId(name);
		item.setOnAction(handler);
		return item;
	}

	private static void setStage(Stage stage1) {
		stage = stage1;
	}

	public static Stage getStage() {
		return stage;
	}

}