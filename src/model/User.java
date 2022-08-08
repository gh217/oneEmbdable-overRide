package model;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {  

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
    private int userId;
    private String userName;
    @Embedded
    @AttributeOverrides({  // first name private String street;
    	// second name shoe in database
	    @AttributeOverride(name="street", column=@Column(name="Home_street")),
	    @AttributeOverride(name="city", column=@Column(name="Home_city"))
    })
    
    private Address home;
    
    @Embedded
    @AttributeOverrides({
	    @AttributeOverride(name="street", column=@Column(name="work_street")),
	    @AttributeOverride(name="city", column=@Column(name="work_city"))
    })
    
    private Address work;


	public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

	public Address getHome() {
		return home;
	}

	public void setHome(Address home) {
		this.home = home;
	}

	public Address getWork() {
		return work;
	}

	public void setWork(Address work) {
		this.work = work;
	}

	
    
}