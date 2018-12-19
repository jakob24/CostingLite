// Generated with g9.

package com.temp;

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

@Entity(name="supplier")
public class Supplier implements Serializable {

    /** Primary key. */
    protected static final String PK = "supplierId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="supplier_id", unique=true, nullable=false, length=10)
    private int supplierId;
    @Column(length=45)
    private String name;
    @Column(length=45)
    private String location;
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    @OneToMany(mappedBy="supplier")
    private Set<Invoice> invoice;
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;

    /** Default constructor. */
    public Supplier() {
        super();
    }

    /**
     * Access method for supplierId.
     *
     * @return the current value of supplierId
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * Setter method for supplierId.
     *
     * @param aSupplierId the new value for supplierId
     */
    public void setSupplierId(int aSupplierId) {
        supplierId = aSupplierId;
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
     * Access method for location.
     *
     * @return the current value of location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter method for location.
     *
     * @param aLocation the new value for location
     */
    public void setLocation(String aLocation) {
        location = aLocation;
    }

    /**
     * Access method for modifiedOn.
     *
     * @return the current value of modifiedOn
     */
    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    /**
     * Setter method for modifiedOn.
     *
     * @param aModifiedOn the new value for modifiedOn
     */
    public void setModifiedOn(Timestamp aModifiedOn) {
        modifiedOn = aModifiedOn;
    }

    /**
     * Access method for invoice.
     *
     * @return the current value of invoice
     */
    public Set<Invoice> getInvoice() {
        return invoice;
    }

    /**
     * Setter method for invoice.
     *
     * @param aInvoice the new value for invoice
     */
    public void setInvoice(Set<Invoice> aInvoice) {
        invoice = aInvoice;
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
     * Compares the key for this instance with another Supplier.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Supplier and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Supplier)) {
            return false;
        }
        Supplier that = (Supplier) other;
        if (this.getSupplierId() != that.getSupplierId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Supplier.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Supplier)) return false;
        return this.equalKeys(other) && ((Supplier)other).equalKeys(this);
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
        i = getSupplierId();
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
        StringBuffer sb = new StringBuffer("[Supplier |");
        sb.append(" supplierId=").append(getSupplierId());
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
        ret.put("supplierId", Integer.valueOf(getSupplierId()));
        return ret;
    }

}