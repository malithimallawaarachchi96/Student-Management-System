/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.entity;

/**
 *
 * @author Harsha madushan
 */
public class Register_PK {
    
    private String stID;
    private String cID;

    public Register_PK() {
    }

    public Register_PK(String stID, String cID) {
        this.stID = stID;
        this.cID = cID;
    }

    /**
     * @return the stID
     */
    public String getStID() {
        return stID;
    }

    /**
     * @param stID the stID to set
     */
    public void setStID(String stID) {
        this.stID = stID;
    }

    /**
     * @return the cID
     */
    public String getcID() {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void setcID(String cID) {
        this.cID = cID;
    }
    
}
