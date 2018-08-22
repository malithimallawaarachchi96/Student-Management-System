/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.registration.dao.CrudUtil;
import lk.ijse.registration.dao.DAOFactory;
import lk.ijse.registration.dao.custom.RegisterDAO;
import lk.ijse.registration.entity.Register;
import lk.ijse.registration.entity.Register_PK;

/**
 *
 * @author Harsha madushan
 */
public class RegisterDAOImpl implements RegisterDAO{

    
    RegisterDAO registerDAO = (RegisterDAO)DAOFactory.getInstance().getDAO(DAOFactory.dAOTypes.Register);
    
    @Override
    public boolean add(Register register) throws Exception {
        return CrudUtil.executeUpdate("Insert into register values(?,?,?,?)",register.getRegister_PK().getStID(),register.getRegister_PK().getcID(),register.getRegDate(),register.getFee());
        
    }

    
    public boolean delete(Register_PK key) throws Exception {
        return CrudUtil.executeUpdate("delete from register  where stID = ?,cID = ?", key.getStID(),key.getcID());
    }

    @Override
    public ArrayList<Register> getAll() throws Exception {
        
        ArrayList<Register> registers = new ArrayList<>();
        ResultSet rs = CrudUtil.executeQuery("select * from register");
        while(rs.next()){
            Register register = new Register(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBigDecimal(4));
            registers.add(register);
        }
        return registers;
    }

    
    public Register find(Register_PK key) throws Exception {
        
        ResultSet rs = CrudUtil.executeQuery("select * from register where stID = ?, cID = ? ", key.getStID(),key.getcID());
        if(rs.next()){
           Register register = new Register(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBigDecimal(4));
           return register;
        }
        return null;
    }

    @Override
    public boolean update(Register register) throws Exception {
        return CrudUtil.executeUpdate("update register set regDate = ?, fee= ? where stID = ? and cID = ? ", register.getRegDate(),register.getFee(),register.getRegister_PK().getStID(),register.getRegister_PK().getcID());
    }
    
}
