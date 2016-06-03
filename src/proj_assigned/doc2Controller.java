
package proj_assigned;

import java.net.URL;
import java.lang.* ;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class doc2Controller implements Initializable
{
    
    @FXML
    TextField t1 ;
    
    @FXML
    TextField t2 ;

    @FXML
    TextField t3 ;
    
    @FXML
    Button b1 ;

    @FXML
   private TableColumn pn;
    
    @FXML
   private TableColumn sn;
    
    @FXML
    private TableColumn pt ;
    
    @FXML
    private TableColumn co;
    
    @FXML
    private TableView<Project> tv=new TableView<>();
     
    private ObservableList<Project> md = FXCollections.observableArrayList(
                new Project("Project1","Scenario1","Gas","Germany") ,
                new Project("Project2","Scenario2","Liquid","Istanbul") ,
                new Project("Project1","Scenario1","Gas","China") ,
                new Project("Project1","Scenario11","Solid","Germany") ,
                new Project("Project2","Scenario2","Gas","India") ,
                new Project("Project2","Scenario11","Liquid","Germany") ,
                new Project("Project1","Scenario2","Gas","Germany") ,
                new Project("Project1","Scenario1","Gas","India") ,
                new Project("Project2","Scenario11","Solid","India") ,
                new Project("Project1","Scenario1","Gas","France"),
                new Project("Project1","Scenario1","Gas","France"));
    
    private ObservableList<Project> fd = FXCollections.observableArrayList() ;
    
    FilteredList<Project> fld = new FilteredList<>(md, p -> true) ;
    
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        updateFilteredData();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {       
        
        t1.textProperty().addListener((observable, oldValue, newValue) -> {
            updateFilteredData();
    });
        
        t2.textProperty().addListener((observable, oldValue, newValue) -> {
            updateFilteredData();
    });
        
        t3.textProperty().addListener((observable, oldValue, newValue) -> {
            updateFilteredData();
    });
        
        pn.setMinWidth(100);
        pn.setCellValueFactory(new PropertyValueFactory<Project, String>("project_Name"));
        
        sn.setMinWidth(100);
        sn.setCellValueFactory(new PropertyValueFactory<Project, String>("scenario_Name"));
        
        pt.setMinWidth(100);
        pt.setCellValueFactory(new PropertyValueFactory<Project, String>("project_Type"));
                
        co.setMinWidth(100);
        co.setCellValueFactory(new PropertyValueFactory<Project, String>("country"));
                
        tv.setEditable(true);             
        tv.setItems(fd);
        
        fd.addAll(md) ;
             
    }
    
    private void updateFilteredData() 
    {
        fd.clear();
        for(Project p : md)
        {
            if(matchesFilter(p))
            {
                fd.add(p) ;
            }    
        }    
        tv.setItems(fd);
    }

    private boolean matchesFilter(Project p) 
    {
        String scenarioName = t1.getText().toLowerCase(Locale.US) ;
        String projectType = t2.getText().toLowerCase(Locale.US) ;
        String country = t3.getText().toLowerCase(Locale.US) ;
        
        if((scenarioName.equals("")) && (projectType.equals("")) && (country.equals("")))
        {
            return true ;
        }   
        
        if((scenarioName.length() != 0) && projectType.equals("") && country.equals("") )
        {
            if(p.getscenario_Name().toLowerCase(Locale.US).indexOf(scenarioName) != -1)
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }    
        
        if((projectType.length() != 0) && scenarioName.equals("") && country.equals("") )
        {
            if(p.getproject_Type().toLowerCase(Locale.US).indexOf(projectType) != -1)
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }
        
        if((country.length() != 0) && scenarioName.equals("") && projectType.equals("") )
        {
            if(p.getcountry().toLowerCase(Locale.US).indexOf(country) != -1)
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }
        
        if((scenarioName.length() != 0) && (projectType.length() != 0) && (country.equals("")))
        {
            if((p.getscenario_Name().toLowerCase(Locale.US).indexOf(scenarioName) != -1) && (p.getproject_Type().toLowerCase(Locale.US).indexOf(projectType) != -1))
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }
        
        if((scenarioName.equals("")) && (projectType.length() != 0) && (country.length() !=0))
        {
            if((p.getproject_Type().toLowerCase(Locale.US).indexOf(projectType) != -1) && (p.getcountry().toLowerCase(Locale.US).indexOf(country) != -1))
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }        

        if((projectType.equals("")) && (scenarioName.length() != 0) && (country.length() !=0))
        {
            if((p.getscenario_Name().toLowerCase(Locale.US).indexOf(scenarioName) != -1) && (p.getcountry().toLowerCase(Locale.US).indexOf(country) != -1))
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }
        
        if((scenarioName.length() != 0) && (projectType.length() != 0) && (country.length() != 0))
        {
            if((p.getscenario_Name().toLowerCase(Locale.US).indexOf(scenarioName) != -1) && (p.getproject_Type().toLowerCase(Locale.US).indexOf(projectType) != -1) && (p.getcountry().indexOf(country) != -1))
            {
                return true ;
            }    
            else
            {
                // do nothing
            }    
        }    
        return false ;
    }
    
    
}
