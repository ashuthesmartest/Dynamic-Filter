package proj_assigned;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author admin
 */
public class Project {
    
    private final SimpleStringProperty project_Name ;
    private final SimpleStringProperty scenario_Name ;
    private final SimpleStringProperty project_Type ;
    private final SimpleStringProperty country ;
    
    Project(String p, String s, String p_t, String co)
    {
        this.project_Name = new SimpleStringProperty(p) ;
        this.scenario_Name = new SimpleStringProperty(s) ;
        this.project_Type = new SimpleStringProperty(p_t) ;
        this.country = new SimpleStringProperty(co) ;
    }        
    

   
    private final StringProperty string = new SimpleStringProperty();

    public String getString() 
    {
        return string.get();
    }

    public void setString(String value) 
    {
        string.set(value);
    }

    public StringProperty stringProperty() 
    {
        return string;
    }

    public String getproject_Name() 
    {
        return project_Name.get() ;
    }
    
    public void setproject_Name(String value) 
    {
        project_Name.set(value);
    }
    
    public StringProperty project_NameProperty()
    {
        return project_Name ;
    }
    
    public String getscenario_Name() 
    {
        return scenario_Name.get() ;
    }
    
    public void setscenario_Name(String value) 
    {
        scenario_Name.set(value);
    }
    
    public StringProperty scenario_NameProperty()
    {
        return scenario_Name ;
    }
    
    public String getproject_Type() 
    {
        return project_Type.get() ;
    }
    
    public void setproject_Type(String value) 
    {
        project_Type.set(value);
    }
    
    public StringProperty project_TypeProperty()
    {
        return project_Type ;
    }
    
    public String getcountry() 
    {
        return country.get() ;
    }
    
    public void setcountry(String value) 
    {
        country.set(value);
    }
    
    public StringProperty countryProperty()
    {
        return country ;
    }
}
