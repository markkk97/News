package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ProvaController {
	@FXML	
	private ListView prova = new ListView();
	private ObservableList<String> items = FXCollections.observableArrayList();
	
	
	public ProvaController() {
		prova.setItems(items);
	    items.add("First task");
	    items.add("Second task");

		
	}
	
}
