package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Person;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

import java.util.Random;
import java.util.ResourceBundle;

public class TableviewController implements Initializable {
    @FXML
    private DatePicker birthday_picker;
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> Firstname_C;
    @FXML
    private TableColumn<Person, String> Lastname_C;
    @FXML
    private TableColumn<Person, LocalDate> Birthday_C;




    public Button add_button;
    public TextField text_top;
    public TextField text_mid;
    public Button delete_button;
    public Button display_button;
    public HashMap<String,String> login_back;

    ObservableList<Person> people = FXCollections.observableArrayList();

    public void GoBackMain(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/123.fxml"));
        Parent main = loader.load();
        Scene detailed = new Scene(main);

        Controllers controller = loader.getController();
        controller.SetLogIn(login_back);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(detailed);
        window.show();


    }


    public void Add_button_clicked(MouseEvent mouseEvent) {

/*

  */
        String firstname_txt = text_top.getCharacters().toString();
        String lastname_txt = text_mid.getCharacters().toString();

        Person p1 = new Person(firstname_txt, lastname_txt, birthday_picker.getValue(), (int)(Math.random()*100));
        people.add(p1);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Firstname_C.setCellValueFactory(new PropertyValueFactory<Person, String>("FirstName"));
        Lastname_C.setCellValueFactory(new PropertyValueFactory<Person, String>("LastName"));
        Birthday_C.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("Birthday"));

        tableView.setItems(people);

        tableView.setEditable(true);
        Firstname_C.setCellFactory(TextFieldTableCell.forTableColumn());
        Lastname_C.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public void changeFristNameCellEvent(TableColumn.CellEditEvent edittedCell) {
        Person personseletcted = tableView.getSelectionModel().getSelectedItem();
        personseletcted.setFirstName(edittedCell.getNewValue().toString());
    }

    public void changeLastNameCellEvent(TableColumn.CellEditEvent edittedCell) {
        Person personseletcted = tableView.getSelectionModel().getSelectedItem();
        personseletcted.setFirstName(edittedCell.getNewValue().toString());
    }



    public boolean login(HashMap<String, String> login, String user_name, String Password) {
        login_back = login;
        if (Password.equals(login_back.get(user_name))) {
                System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }
    }



    public void delete_button_click(ActionEvent actionEvent) {
        ObservableList<Person> selected;
        ObservableList<Person> All;
        All = tableView.getItems();
        selected = tableView.getSelectionModel().getSelectedItems();
        All.removeAll(selected);


    }




    public void display_button(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/detailed.fxml"));
        Parent tableview_detailed_Parent = loader.load();

        Scene detailed = new Scene(tableview_detailed_Parent);

        DetailedController ViewController = loader.getController();
        ViewController.initData(tableView.getSelectionModel().getSelectedItem());

        Stage window1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window1.setScene(detailed);
        window1.show();
    }

    public HashMap<String, String> getback_key() {
        return login_back;
    }
}






