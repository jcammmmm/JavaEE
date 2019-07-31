// default package

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for CountryDb entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CountryDb
  * @author MyEclipse Persistence Tools 
 */
public class CountryDbDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CountryDbDAO.class);
		//property constants
	public static final String COUNTRYNAME = "countryname";
	public static final String POPULATION = "population";
	public static final String EXTENSION = "extension";
	public static final String GOVTYPE = "govtype";



    
    public void save(CountryDb transientInstance) {
        log.debug("saving CountryDb instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CountryDb persistentInstance) {
        log.debug("deleting CountryDb instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CountryDb findById( java.lang.Integer id) {
        log.debug("getting CountryDb instance with id: " + id);
        try {
            CountryDb instance = (CountryDb) getSession()
                    .get("CountryDb", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CountryDb instance) {
        log.debug("finding CountryDb instance by example");
        try {
            List results = getSession()
                    .createCriteria("CountryDb")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding CountryDb instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CountryDb as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCountryname(Object countryname
	) {
		return findByProperty(COUNTRYNAME, countryname
		);
	}
	
	public List findByPopulation(Object population
	) {
		return findByProperty(POPULATION, population
		);
	}
	
	public List findByExtension(Object extension
	) {
		return findByProperty(EXTENSION, extension
		);
	}
	
	public List findByGovtype(Object govtype
	) {
		return findByProperty(GOVTYPE, govtype
		);
	}
	

	public List findAll() {
		log.debug("finding all CountryDb instances");
		try {
			String queryString = "from CountryDb";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CountryDb merge(CountryDb detachedInstance) {
        log.debug("merging CountryDb instance");
        try {
            CountryDb result = (CountryDb) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CountryDb instance) {
        log.debug("attaching dirty CountryDb instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CountryDb instance) {
        log.debug("attaching clean CountryDb instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}