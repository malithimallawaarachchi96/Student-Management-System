/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.dao.custom;

import java.util.ArrayList;
import lk.ijse.registration.dao.CrudDAO;
import lk.ijse.registration.dao.SuperDAO;
import lk.ijse.registration.entity.Course;

/**
 *
 * @author Harsha madushan
 */
public interface CourseDAO extends CrudDAO<Course, String>{
    
    public ArrayList<String> getID()throws Exception;
}
