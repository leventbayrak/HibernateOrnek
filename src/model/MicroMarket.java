package model;
// Generated 08.May.2017 14:22:30 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * MicroMarket generated by hbm2java
 */
public class MicroMarket  implements java.io.Serializable {


     private String zipCode;
     private Double radius;
     private Double areaLength;
     private Double areaWidth;
     private Set customers = new HashSet(0);

    public MicroMarket() {
    }

	
    public MicroMarket(String zipCode) {
        this.zipCode = zipCode;
    }
    public MicroMarket(String zipCode, Double radius, Double areaLength, Double areaWidth, Set customers) {
       this.zipCode = zipCode;
       this.radius = radius;
       this.areaLength = areaLength;
       this.areaWidth = areaWidth;
       this.customers = customers;
    }
   
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public Double getRadius() {
        return this.radius;
    }
    
    public void setRadius(Double radius) {
        this.radius = radius;
    }
    public Double getAreaLength() {
        return this.areaLength;
    }
    
    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }
    public Double getAreaWidth() {
        return this.areaWidth;
    }
    
    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }
    public Set getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set customers) {
        this.customers = customers;
    }




}


