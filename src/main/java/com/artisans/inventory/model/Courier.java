// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="courier")
public class Courier implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "courierId";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="courier_id", unique=true, nullable=false, length=10)
    private int courierId;
    @Column(length=45)
    private String name;
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    @OneToMany(mappedBy="courier")
    private Set<Shipment> shipment;
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;

    /** Default constructor. */
    public Courier() {
        super();
    }

    /**
     * Access method for courierId.
     *
     * @return the current value of courierId
     */
    public int getCourierId() {
        return courierId;
    }

    /**
     * Setter method for courierId.
     *
     * @param aCourierId the new value for courierId
     */
    public void setCourierId(int aCourierId) {
        courierId = aCourierId;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }
 

    /**
	 * @return the modifiedOn
	 */
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
     * Access method for shipment.
     *
     * @return the current value of shipment
     */
    public Set<Shipment> getShipment() {
        return shipment;
    }

    /**
     * Setter method for shipment.
     *
     * @param aShipment the new value for shipment
     */
    public void setShipment(Set<Shipment> aShipment) {
        shipment = aShipment;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(User aUser) {
        user = aUser;
    }

    /**
     * Compares the key for this instance with another Courier.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Courier and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Courier)) {
            return false;
        }
        Courier that = (Courier) other;
        if (this.getCourierId() != that.getCourierId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Courier.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Courier)) return false;
        return this.equalKeys(other) && ((Courier)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getCourierId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Courier |");
        sb.append(" courierId=").append(getCourierId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("courierId", Integer.valueOf(getCourierId()));
        return ret;
    }

}
