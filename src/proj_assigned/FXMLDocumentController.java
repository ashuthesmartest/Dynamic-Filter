/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_assigned;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable 
{
    @FXML
    AnchorPane a1 ;
    
    @FXML
    AnchorPane a2 ;
    
    @FXML
    TreeView<String> treeview ;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        TreeItem<String> th1 = new TreeItem<>("Project Modification") ;
        
        TreeItem<String> th2 = new TreeItem<>("Search Project") ;
        
        TreeItem<String> th3 = new TreeItem<>("Projects") ;
        
        TreeItem<String> nodeItemA = new TreeItem<>("Project A") ;
        TreeItem<String> nodeItemB = new TreeItem<>("Project B") ;
        TreeItem<String> nodeItemC = new TreeItem<>("project C") ;
        th2.getChildren().add(th3) ;
        th3.getChildren().addAll(nodeItemA, nodeItemB, nodeItemC) ;
                
        treeview.setRoot(th2);
        
        EventHandler<MouseEvent> meh = (MouseEvent event) -> {
            try {
                handleMouseClicked(event) ;
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        };
        treeview.addEventHandler(MouseEvent.MOUSE_CLICKED, meh);
    }    
    
    private void handleMouseClicked(MouseEvent event) throws IOException 
    {
       String s1 =  treeview.getSelectionModel().getSelectedItem().getValue().toString() ;
       if(event.getClickCount() == 2)
       {    
            if(s1.equals("Search Project"))
            {
                // AnchorPane ap = FXMLLoader.load(getClass().getResource("doc2.fxml")) ;
                // this.a2.getChildren().setAll(ap) ;
                FXMLLoader l = new FXMLLoader(getClass().getResource("doc2.fxml")) ;
                Parent root = (Parent) l.load() ;
                Stage stage = new Stage() ;
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Graphs");
               // stage.getIcons().add(new Image("file:imageres.dll")) ;
                stage.setScene(new Scene(root));
                stage.show() ;
            }    
            else
            {
                //do nothing
            }            
       }
       else
       {
           //do nothing
       }    
    
    }
}