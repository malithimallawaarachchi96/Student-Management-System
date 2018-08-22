/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.registration.dao.CrudUtil;
import lk.ijse.registration.dao.custom.StudentDAO;
import lk.ijse.registration.entity.Student;

/**
 *
 * @author Harsha madushan
 */
public class StudentDAOImpl implements StudentDAO{

    
    public boolean add(Student student) throws Exception {
        
        return CrudUtil.executeUpdate("Insert into student values(?,?,?)", student.getStID(),student.getName(),student.getAddress());
        
    }

    
    public boolean delete(String id) throws Exception {
        
        return CrudUtil.executeUpdate("delete from student  where stID = ?", id);
        
    }

    
    public ArrayList<Student> getAll() throws Exception {
        
        ArrayList<Student> students = new ArrayList<>();
        
        ResultSet rs = CrudUtil.executeQuery("select * from student");
        
        while(rs.next()){
            Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3));
            students.add(student);
        }
        return students;
    }


    public Student find(String id) throws Exception {
        
        ResultSet rs = CrudUtil.executeQuery("select * from student where stID = ?",id);
        
        if(rs.next()){
            Student student = new Student(rs.getString(1),rs.getString(2), rs.getString(3));
            return student;
        }
        return null;
    }

 
    public boolean update(Student student) throws Exception {
        
        return CrudUtil.executeUpdate("update student set name = ?, address = ? where stid = ?", student.getName(),student.getAddress(),student.getStID());
        
    }
    
}
