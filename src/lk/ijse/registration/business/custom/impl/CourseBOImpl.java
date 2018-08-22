/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.registration.business.custom.CourseBO;
import lk.ijse.registration.dao.DAOFactory;
import lk.ijse.registration.dao.custom.CourseDAO;
import lk.ijse.registration.dto.CourseDTO;
import lk.ijse.registration.entity.Course;

/**
 *
 * @author Harsha madushan
 */
public class CourseBOImpl implements CourseBO{
    
    
    
    
    private static CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.dAOTypes.Course);
    

    public boolean addCourse(CourseDTO addC)throws Exception{
        Course course = new Course(addC.getcID(),addC.getName(), addC.getDuration());
        return courseDAO.add(course);
    }
    
    public boolean deleteCourse(String id)throws Exception{
        return courseDAO.delete(id);
    }
    
    public boolean updateCourse(CourseDTO upC)throws Exception{
        Course course = new Course(upC.getcID(), upC.getName(), upC.getDuration());
        return courseDAO.update(course);
    }
    
    public ArrayList<CourseDTO> getAllCourses()throws Exception{
        ArrayList<Course> allCourses = courseDAO.getAll();
        ArrayList<CourseDTO> courses  = new ArrayList<>();
        
        for (Course c : allCourses) {
            CourseDTO coursesDTO = new CourseDTO(c.getcID(),c.getName(),c.getDuration());
            courses.add(coursesDTO);
        }
        return courses;
    }
    public CourseDTO findCourse(String id)throws Exception{
        Course c = courseDAO.find(id);
        CourseDTO cDTO = new CourseDTO(c.getcID(),c.getName(),c.getDuration());
        return cDTO;
    }
    
    public ArrayList<String> getCourseIDs()throws Exception{
      return courseDAO.getID();   
    }
    
}
