// default package

import java.util.HashSet;
import java.util.Set;


/**
 * AbstractCountryDb entity provides the base persistence definition of the CountryDb entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCountryDb  implements java.io.Serializable {


    // Fields    

     private Integer cid;
     private String countryname;
     private Integer population;
     private Double extension;
     private String govtype;
     private Set warDbs = new HashSet(0);


    // Constructors

    /** default constructor */
    public AbstractCountryDb() {
    }

	/** minimal constructor */
    public AbstractCountryDb(Integer cid) {
        this.cid = cid;
    }
    
    /** full constructor */
    public AbstractCountryDb(Integer cid, String countryname, Integer population, Double extension, String govtype, Set warDbs) {
        this.cid = cid;
        this.countryname = countryname;
        this.population = population;
        this.extension = extension;
        this.govtype = govtype;
        this.warDbs = warDbs;
    }

   
    // Property accessors

    public Integer getCid() {
        return this.cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCountryname() {
        return this.countryname;
    }
    
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Integer getPopulation() {
        return this.population;
    }
    
    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getExtension() {
        return this.extension;
    }
    
    public void setExtension(Double extension) {
        this.extension = extension;
    }

    public String getGovtype() {
        return this.govtype;
    }
    
    public void setGovtype(String govtype) {
        this.govtype = govtype;
    }

    public Set getWarDbs() {
        return this.warDbs;
    }
    
    public void setWarDbs(Set warDbs) {
        this.warDbs = warDbs;
    }
   








}