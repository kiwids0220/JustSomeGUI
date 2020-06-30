package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sample.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailedController  {
   @FXML
   public Label first_name_label;
    @FXML
    public Label last_name_label;
    @FXML
    public Label birthday_label;
    @FXML
    public Label age_label;
    public Label Lucky_num;
    @FXML
    private Person selectedPerson;




    public void initData(Person person){
        first_name_label.setText(person.getFirstName());
        last_name_label.setText(person.getLastName());
        birthday_label.setText(person.getBirthday().toString());
        age_label.setText(Integer.toString(person.getAge()));
        Lucky_num.setText(Integer.toString(person.getLuckynumber1()));

    }
}
