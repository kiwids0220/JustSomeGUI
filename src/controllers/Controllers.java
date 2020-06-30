
package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;


public class Controllers {
    HashMap<String, String> login =new HashMap<>();

    public TextField Username_textfield;
    public PasswordField Pword_textfield;
    @FXML
    Button click_Button;




    public void onClickedEvent(MouseEvent mouseEvent) {
        System.out.println("Clicked Username");
    }

    public void onDragDectec(MouseEvent mouseEvent) {
        System.out.println("username draged thru");
    }

    public void SetLogIn(HashMap<String,String> map){
        login = map;
    }


    public void reset_mouse_click(MouseEvent mouseEvent) {
        Username_textfield.clear();
        Pword_textfield.clear();


    }



    public void changeSceneButton(ActionEvent actionEvent) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../resources/TableView.fxml"));
        Scene tablevViewScene = new Scene(tableViewParent);
        //this line gets the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(tablevViewScene);
        window.show();
    }

  public void login_button_fun(ActionEvent actionEvent) throws IOException {
        String username = Username_textfield.getCharacters().toString();
        String password= Pword_textfield.getCharacters().toString();
        System.out.println(username + " " + password);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../resources/TableView.fxml"));
        Parent table123 = loader.load();
        Scene detailed = new Scene(table123);

        TableviewController controller = loader.getController();

        Stage window1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        if(controller.login(login, username, password )){
            login = controller.getback_key();


            window1.setScene(detailed);
            window1.show();
        }
      login = controller.getback_key();
    }



    public void click_add_button_fun(ActionEvent actionEvent) {

        System.out.println("11111");
        login.put(Username_textfield.getCharacters().toString(), Pword_textfield.getCharacters().toString());
    }






}