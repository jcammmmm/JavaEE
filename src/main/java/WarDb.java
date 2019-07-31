// default package



/**
 * WarDb entity. @author MyEclipse Persistence Tools
 */
public class WarDb extends AbstractWarDb implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WarDb() {
    }

	/** minimal constructor */
    public WarDb(Integer wid) {
        super(wid);        
    }
    
    /** full constructor */
    public WarDb(Integer wid, CountryDb countryDb, String warname) {
        super(wid, countryDb, warname);        
    }
   
}
