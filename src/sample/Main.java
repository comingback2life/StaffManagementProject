package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label idLabel= new Label("Staff ID: ");
        Label fNameLabel = new Label("First Name: ");
        Label lNameLabel = new Label("Last Name: ");
        Label midLabel = new Label("MI: ");
        Label addressLabel = new Label("Address: ");
        Label cityLabel = new Label("City: ");
        Label stateLabel = new Label("State: ");
        Label phoneLabel = new Label ("Phone: ");
        TextField id = new TextField();
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField midName = new TextField();
        midName.setMaxWidth(25);
        TextField address= new TextField();
        TextField city = new TextField();
        TextField phone = new TextField();
        ComboBox state = new ComboBox();
        Button view = new Button ("View");
        Button insert = new Button ("Insert");
        Button update = new Button("Update");
        Button clear = new Button("Clear");
        //"NSW","ACT","VIC","NT","SA","TAS","WA","QLD"
        primaryStage.setTitle("Staff Management System");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); //setting the allignment
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(5,5,5,5));
        Scene scene = new Scene(gridPane,600,240);
        gridPane.add(idLabel,0,1); //id Label
        gridPane.add(id,1,1); //id TextBox
        gridPane.add(lNameLabel,0,2);
        gridPane.add(lastName,1,2);
        gridPane.add(fNameLabel,2,2);
        gridPane.add(firstName,3,2);
        gridPane.add(midLabel,4,2);
        gridPane.add(midName,5,2);
        gridPane.add(addressLabel,0,3);
        gridPane.add(address,1,3);
        gridPane.add(cityLabel,0,4);
        gridPane.add(city,1,4);
        gridPane.add(stateLabel,2,4);
        gridPane.add(state,3,4);
        gridPane.add(phoneLabel,0,5);
        gridPane.add(phone,1,5);
        StackPane ap = new StackPane();
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.setSpacing(2);
        hBox.getChildren().addAll(view,insert,update,clear);
        ap.getChildren().addAll(hBox);
        gridPane.add(hBox,1,6);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); //restricting the user to re-size the window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
