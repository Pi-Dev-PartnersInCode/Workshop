/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import entities.Trainer;
import entities.Workshop;
import java.net.URL;
import java.sql.Date;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.WorkshopCRUD;

/**
 * FXML Controller class
 *
 * @author Mey
 */
public class WorkshopPageController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Workshop> tableWorkshop;
    @FXML
    private TableColumn<Workshop,String> idWork_col;
    @FXML
    private TableColumn<Workshop,String> nameWork_col;
    @FXML
    private TableColumn<Workshop,String> addressWork_col;
    @FXML
    private TableColumn<Workshop,String> dateWork_col;
    @FXML
    private TableColumn<Workshop,String> durationWork_col;
    @FXML
    private TableColumn<Workshop,String> idTrainer_col;
    @FXML
    private TextField idWork;
    @FXML
    private TextField nameWork;
    @FXML
    private TextField addressWork;
    @FXML
    private TextField idTrai;
    
    @FXML
    private TextField durationWork;
    @FXML
    private DatePicker dateWork;
    
    
    

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         idWork_col.setCellValueFactory(new PropertyValueFactory<Workshop,String>("idW"));
       nameWork_col.setCellValueFactory(new PropertyValueFactory<Workshop,String>("NameW")); 
        addressWork_col.setCellValueFactory(new PropertyValueFactory<Workshop,String>("AddressW"));
        dateWork_col.setCellValueFactory(new PropertyValueFactory<Workshop,String>("DateW"));
       durationWork_col.setCellValueFactory(new PropertyValueFactory<Workshop,String>("Duration"));
       idTrainer_col.setCellValueFactory(new PropertyValueFactory<Workshop,String>("myTrainer.idTrainer"));
        
         refreshTable();
        
        
    }
    private void refreshTable()
    {
        WorkshopCRUD ww = new WorkshopCRUD();
        ObservableList<Workshop> obs ;
        obs = FXCollections.observableArrayList();
        obs.addAll(ww.afficherWorkshop());
        tableWorkshop.setItems(obs);
//      System.out.println(obs);
    }    
  @FXML
    private void addClicked(ActionEvent event) {
        
        WorkshopCRUD ww = new WorkshopCRUD();
        int idW = Integer.parseInt(idWork.getText());
        int myTrainer = Integer.parseInt(idTrai.getText());
        String NameW = nameWork.getText();
        String DateW = dateWork.getValue().toString();
        String AddressW = addressWork.getText();
        String Duration = durationWork.getText();
        Trainer t = new Trainer(myTrainer, "tmp", "tmp", "tmp");
        Workshop w = new Workshop(NameW,idW,DateW,Duration,AddressW,t);
        ww.ajouterWorkshop(w);
        refreshTable();
    }
    
 
    @FXML
    private void editClicked(ActionEvent event) {
        
         Workshop c = tableWorkshop.getSelectionModel().getSelectedItem();
        WorkshopCRUD cc = new WorkshopCRUD();
        int id = c.getIdW();
        java.sql.Date javaSqlDate = java.sql.Date.valueOf(dateWork.getValue());
        int idW = Integer.parseInt(idWork.getText());
        int myTrainer = Integer.parseInt(idTrai.getText());
        String NameW = nameWork.getText();
        String DateW = dateWork.getValue().toString();
        String AddressW = addressWork.getText();
        String Duration = durationWork.getText();
        
        Workshop ca = new Workshop(NameW,idW,DateW,Duration,AddressW,myTrainer);
        cc.modifierWorkshop(ca);

        nameWork.clear();
        addressWork.clear();
        durationWork.clear();
        dateWork.setValue(null);
        refreshTable();
    }   
    
    private void WorkshopSelected(MouseEvent event) {
         Workshop c = tableWorkshop.getSelectionModel().getSelectedItem();
        nameWork.setText(c.getNameW());
        addressWork.setText(c.getAddressW());
//        description_input.setText(c.getDescription());
//        LocalDate tempdate = java.sql.Date(c.getDateComp().getTime()).toLocalDate();
//        dateComp_input.setValue(tempdate);

    }

  


    @FXML
    private void deleteClicked(ActionEvent event) {
         Workshop c = tableWorkshop.getSelectionModel().getSelectedItem();
        WorkshopCRUD cc = new WorkshopCRUD();
        cc.supprimerWorkshop(c.getIdW());
        refreshTable();
    }

    

  
}
  
    

    