/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.business.custom.impl;

import lk.ijse.registration.business.*;
import java.util.ArrayList;
import lk.ijse.registration.business.custom.StudentBO;
import lk.ijse.registration.dao.DAOFactory;
import lk.ijse.registration.dao.custom.StudentDAO;
import lk.ijse.registration.dto.StudentDTO;
import lk.ijse.registration.entity.Student;

/**
 *
 * @author Harsha madushan
 */
public class StudentBOImpl implements StudentBO{
    
    
    
    
    private static StudentDAO studentDAO =(StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.dAOTypes.Student);
    
    public boolean addStudent(StudentDTO student)throws Exception{
        
        Student std = new Student(student.getStID(), student.getName(), student.getAddress());
        return studentDAO.add(std);
    }
    
    public ArrayList<StudentDTO> getAllStudents ()throws Exception{
        
        ArrayList <Student> allStudents = studentDAO.getAll();
        ArrayList <StudentDTO> students = new ArrayList<>();
        
        for (Student allStudent : allStudents) {
            StudentDTO student = new StudentDTO(allStudent.getStID(), allStudent.getName(), allStudent.getAddress());
            students.add(student);
        }
        
        return students;
        
    } 
    
    public Boolean deleteStudent(String id)throws Exception{
        return studentDAO.delete(id);
    }
    
    public Boolean updateStudent(StudentDTO student)throws Exception{
        Student st = new Student(student.getStID(), student.getName(), student.getAddress());
        return studentDAO.update(st);
    }
    
    public StudentDTO findStudent(String id)throws Exception{
        Student st = studentDAO.find(id);
        StudentDTO stuDTO = new StudentDTO(st.getStID(), st.getName(), st.getAddress());
        return stuDTO;
    }
    
}
