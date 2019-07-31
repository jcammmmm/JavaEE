// default package

import java.util.Set;


/**
 * CountryDb entity. @author MyEclipse Persistence Tools
 */
public class CountryDb extends AbstractCountryDb implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public CountryDb() {
    }

	/** minimal constructor */
    public CountryDb(Integer cid) {
        super(cid);        
    }
    
    /** full constructor */
    public CountryDb(Integer cid, String countryname, Integer population, Double extension, String govtype, Set warDbs) {
        super(cid, countryname, population, extension, govtype, warDbs);        
    }
   
}
