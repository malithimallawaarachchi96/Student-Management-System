/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.registration.dao.CrudUtil;
import lk.ijse.registration.dao.custom.CourseDAO;
import lk.ijse.registration.db.DBConnection;
import lk.ijse.registration.entity.Course;


/**
 *
 * @author Harsha madushan
 */
public class CourseDAOImpl implements CourseDAO{


    @Override
    public boolean add(Course course) throws Exception {
     
        return CrudUtil.executeUpdate("Insert into course values(?,?,?)", course.getcID(),course.getName(),course.getDuration());
        
    }

    @Override
    public boolean delete(String id) throws Exception {
        
        return CrudUtil.executeUpdate("delete from course  where cID = ?", id);
        
    }

    @Override
    public ArrayList<Course> getAll() throws Exception {
        
        ResultSet rs = CrudUtil.executeQuery("select * from course");
        ArrayList<Course> Courses = new ArrayList<>();
        
        while(rs.next()){
            Course course = new Course(rs.getString(1), rs.getString(2), rs.getString(3));
            Courses.add(course);
        }
        return Courses;
        
    }

    @Override
    public Course find(String id) throws Exception {
        
        ResultSet rs = CrudUtil.executeQuery("select * from course where cID = ?", id);
        
        if(rs.next()){
            Course course = new Course(rs.getString(1),rs.getString(2), rs.getString(3));
            return course;
        }
        return null;
    }

    @Override
    public boolean update(Course course) throws Exception {
        
        return CrudUtil.executeUpdate("update course set name = ?, duration = ? where cid = ?", course.getName(),course.getDuration(),course.getcID());
        
    }
    
    @Override
    public ArrayList<String> getID() throws Exception {
        ArrayList<String> array = new ArrayList<>();
        
        ResultSet rs = CrudUtil.executeQuery("select cID from course");
        while(rs.next()){
            array.add(rs.getString(1));
        }
        return array;
    }
}
