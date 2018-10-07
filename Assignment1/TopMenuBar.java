package Assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TopMenuBar {

	private static Stage stage;

	public static final String CSS_PATH = "C:\\Users\\hiba\\eclipse-workspace\\WORK\\resources\\resources\\css\\style.css";
	public static final String INFO_PATH = "C:\\Users\\hiba\\eclipse-workspace\\WORK\\resources\\resources\\icons\\info.txt";
	public static final String HELP_PATH = "C:\\Users\\hiba\\eclipse-workspace\\WORK\\resources\\resources\\icons\\help.txt";
	public static final String CREDITS_PATH = "C:\\Users\\hiba\\eclipse-workspace\\WORK\\resources\\resources\\icons\\credits.txt";

	public static MenuBar getMenuBar(Stage primaryStage) {
		setStage(primaryStage);
		MenuBar menuBar = new MenuBar(new Menu("File", null, createMenuItem("Save", (e) -> {
		}), createMenuItem("New", (e) -> {
		}), new SeparatorMenuItem(), createMenuItem("Exit", (e) -> {
		})), new Menu("Help", null, createMenuItem("Credit", (e) -> displayCredit()), createMenuItem("Info", (e) -> {
		}), new SeparatorMenuItem(), createMenuItem("Help", (e) -> {
		})));

		return menuBar;
	}

	private static void setStage(Stage stage1) {
		stage = stage1;
	}

	public static Stage getStage() {
		return stage;
	}

	private static MenuItem createMenuItem(String name, EventHandler<ActionEvent> handler) {
		Label icon = new Label();
		icon.setId(name + "-icon");
		MenuItem item = new MenuItem(name, icon);
		item.setId(name);
		item.setOnAction(handler);
		return item;
	}

	private static void displayAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

	private static String loadFile(String path) {
		String str = "";
		try {
			str = Files.lines(Paths.get(path)).reduce(str, (a, b) -> a + System.lineSeparator() + b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private static void displayCredit() {

		displayAlert("Credit", "Resource Credits", loadFile(CREDITS_PATH));
	}

}
