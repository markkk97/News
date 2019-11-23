/**
 * 
 */
package application;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.function.Predicate;

import com.sun.corba.se.pept.transport.EventHandler;

import application.news.Article;
import application.news.Categories;
import application.news.User;
import application.utils.JsonArticle;
import application.utils.exceptions.ErrorMalFormedArticle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import serverConection.ConnectionManager;

/**
 * @author ÁngelLucas
 *
 */
public class NewsReaderController {

	private NewsReaderModel newsReaderModel = new NewsReaderModel();
	private User usr;
	
	@FXML
	private ListView <Article> listArticle;
	
	
	private FilteredList<Article> filteredData;
	
	//try
	@FXML
	private ListView<String> prova;
	
	@FXML
	private Label articleTitle;
	
	@FXML
	private Label articleSubTitle;
	
	@FXML
	private Label articleBody;
	
	
	
	private ObservableList<Article> items = FXCollections.observableArrayList();
	//end try
	
	//TODO add attributes and methods as needed

	public NewsReaderController() {
		//Uncomment next sentence to use data from server instead dummy data
		//newsReaderModel.setDummyDate(false);
		//Get text Label

		
		// try
		
		
	}
	
	@FXML
    void initialize() {
        assert prova != null : "fx:id=\"prova\" was not injected: check your FXML file 'home.fxml'.";
        assert listArticle != null : "fx:id=\"listArticle\" was not injected: check your FXML file 'home.fxml'.";
        
       // System.out.println("user " + ConnectionManager.getIdUser());
        //getData();
        
 
        
    }
	

	private void getData() {
		
	
		if(listArticle == null) {
			System.out.println("listarticle is null");
			return;
		}
		//TODO retrieve data and update UI
		//The method newsReaderModel.retrieveData() can be used to retrieve data
		
		newsReaderModel.setDummyData(false);
		newsReaderModel.retrieveData();
		//filteredData = new FilteredList<>(newsReaderModel.getArticles(), s-> true);
		listArticle.setItems(newsReaderModel.getArticles());
		
		

		
		
		
		
	
	/*	
		listArticle.setCellFactory(param -> new ListCell<Article>() {
	            private ImageView imageView = new ImageView();
	            @Override
	            protected void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);

	                if (empty || item == null) {
	                    imageView.setImage(null);
	                    setGraphic(null);
	                    setText(null);
	                    
	                } else {
	                    imageView.setImage(newsReaderModel.getArticles());

	                    setText(constructLabel(SHORT_PREFIX, item, SUFFIX));
	                    setGraphic(imageView);
	                }
	            } 
	        });*/
		
		
		
	}
	
	@FXML public void handleMouseClick(MouseEvent arg0) {
	    System.out.println("Clicked on " + listArticle.getSelectionModel().getSelectedItem().getTitle());
	    //String title =  listArticle.getSelectionModel().getSelectedItem().getTitle();
	    
	    articleTitle.setText(listArticle.getSelectionModel().getSelectedItem().getTitle());
	    articleSubTitle.setText(listArticle.getSelectionModel().getSelectedItem().getSubtitle());
	}

	/**
	 * @return the usr
	 */
	User getUsr() {
		return usr;
	}

	void setConnectionManager (ConnectionManager connection){
		this.newsReaderModel.setDummyData(false); //System is connected so dummy data are not needed
		this.newsReaderModel.setConnectionManager(connection);
		this.getData();
	}
	
	/**
	 * @param usr the usr to set FOR WHAT IS THIS METHOD USED?
	 */
	void setUsr(User usr) {
		
		this.usr = usr;
		//Reload articles
		this.getData();
		//TODO Update UI
	}

	// Auxiliary methods
	private interface  InitUIData <T>{
		void initUIData (T loader);
	}
}
