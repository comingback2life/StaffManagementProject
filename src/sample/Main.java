package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main extends Application {
    Controller c;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label idLabel = new Label("Staff ID: ");
        Label fNameLabel = new Label("First Name: ");
        Label lNameLabel = new Label("Last Name: ");
        Label midLabel = new Label("MI: ");
        Label addressLabel = new Label("Address: ");
        Label cityLabel = new Label("City: ");
        Label stateLabel = new Label("State: ");
        Label phoneLabel = new Label("Phone: ");
        TextField id = new TextField();
        id.setDisable(true);
        if (!id.isEditable()) {
            id.setStyle("-fx-background-color: gray");
        }
        ;
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField midName = new TextField();
        midName.setMaxWidth(25);
        TextField address = new TextField();
        TextField city = new TextField();
        TextField phone = new TextField();
        ComboBox state = new ComboBox();
        state.getItems().addAll("NSW", "ACT", "VIC", "NT", "SA", "TAS", "WA", "QLD");
        Button view = new Button("View");
        Button insert = new Button("Insert");
        Button update = new Button("Update");
        Button clear = new Button("Clear");
        EventHandler<ActionEvent> viewClicked = new EventHandler<ActionEvent>() { //clicked view button ?
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!c.createTable()) {
                    noDataFound();
                } else {
                    //Table goes here
                }
            }
        };
        view.setOnAction(viewClicked);

        EventHandler<ActionEvent> insertClicked = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //action
                if(midName.getText().isEmpty()){
                    midName.setText("");
                }
               c.insertValuestoTable(lastName.getText(),firstName.getText(),midName.getText(),address.getText(),city.getText(),state.getValue().toString(),Integer.valueOf(phone.getText()));
            }
        };
        insert.setOnAction(insertClicked);
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
    public static void noDataFound(){
        Stage popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL); //- a stage that blocks input events
        popupWindow.setTitle("Data not found");
        Button okButton = new Button("Ok, I understand!");
        Label noData = new Label("No Data has been found.");
        okButton.setOnAction(e->{
            popupWindow.close();
        });
        HBox layout= new HBox(10);
        layout.getChildren().addAll(noData, okButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        popupWindow.setScene(scene1);
        popupWindow.showAndWait();

    }
}
