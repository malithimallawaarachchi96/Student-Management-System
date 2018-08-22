/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.entity;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Harsha madushan
 */
public class Register {
    private Register_PK register_PK;
    private Date regDate;
    private BigDecimal fee;

    public Register() {
    }

    public Register(Register_PK register_PK, Date regDate, BigDecimal fee) {
        this.register_PK = register_PK;
        this.regDate = regDate;
        this.fee = fee;
    }
    
    public Register(String stID,String cID, Date regDate, BigDecimal fee) {
        this.register_PK = new Register_PK(stID, cID);
        this.regDate = regDate;
        this.fee = fee;
    }

    /**
     * @return the register_PK
     */
    public Register_PK getRegister_PK() {
        return register_PK;
    }

    /**
     * @param register_PK the register_PK to set
     */
    public void setRegister_PK(Register_PK register_PK) {
        this.register_PK = register_PK;
    }

    /**
     * @return the date
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * @return the fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Register{" + "register_PK=" + register_PK + ", date=" + regDate + ", fee=" + fee + '}';
    }
    
    
}
