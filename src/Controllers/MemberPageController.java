/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mey
 */
public class MemberPageController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<?> tableWorkshop;
    @FXML
    private TableColumn<?, ?> idTrai_col;
    @FXML
    private TableColumn<?, ?> nameTrai_col;
    @FXML
    private TableColumn<?, ?> cinTrai_col;
    @FXML
    private TableColumn<?, ?> specialityTrai_col;
    @FXML
    private TextField idTrai;
    @FXML
    private TextField nameTrai;
    @FXML
    private TextField SpecTrai;
    @FXML
    private TextField CinTrai;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CompetitonSelected(MouseEvent event) {
    }

    @FXML
    private void addClicked(ActionEvent event) {
    }

    @FXML
    private void editClicked(ActionEvent event) {
    }

    @FXML
    private void deleteClicked(ActionEvent event) {
    }
    
}
