/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.ijse.registration.business.*;
import lk.ijse.registration.business.custom.RegisterBO;
import lk.ijse.registration.dao.DAOFactory;
import lk.ijse.registration.dao.custom.RegisterDAO;
import lk.ijse.registration.dto.RegisterDTO;
import lk.ijse.registration.entity.Register;
import lk.ijse.registration.entity.Register_PK;

/**
 *
 * @author Harsha madushan
 */
public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = (RegisterDAO)DAOFactory.getInstance().getDAO(DAOFactory.dAOTypes.Register);
    

    @Override
    public boolean registerStudent(RegisterDTO register) throws Exception {
        
        Register ERegister = new Register(register.getStID(), register.getcID(), register.getRegDate(), register.getFee());
        return registerDAO.add(ERegister);
    }

    @Override
    public boolean updateregistration(RegisterDTO register) throws Exception {
        Register Eregister = new Register(register.getStID(), register.getcID(), register.getRegDate(), register.getFee());
        return registerDAO.update(Eregister);
    }

    @Override
    public boolean deleteregistration(String stID, String cID) throws Exception {
        Register_PK register_PK = new Register_PK(stID, cID);
        return registerDAO.delete(register_PK);
    }

    @Override
    public RegisterDTO findById(String stID, String cID) throws Exception {
        Register_PK register_PK = new Register_PK(stID, cID);
        Register register = registerDAO.find(register_PK);
        RegisterDTO registerDTO = new RegisterDTO(register.getRegister_PK().getStID(), register.getRegister_PK().getcID(), register.getRegDate(),register.getFee());
        return registerDTO;
    }

    @Override
    public ArrayList<RegisterDTO> getAll() throws Exception {
        ArrayList<RegisterDTO> registerDTOs = new ArrayList<>();
        ArrayList<Register> registers  = registerDAO.getAll();
        for (Register register : registers) {
            RegisterDTO registerDTO = new RegisterDTO(register.getRegister_PK().getStID(), register.getRegister_PK().getcID(), register.getRegDate(), register.getFee());
            registerDTOs.add(registerDTO);
        }
        
        return registerDTOs;
    }
    
     
    
}
