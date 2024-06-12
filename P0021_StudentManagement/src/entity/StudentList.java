package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentList {
    private List<Student> sList = new ArrayList<>();

    public List<Student> getStudentList() {
        return sList;
    }

    public void setStudentList(List<Student> studentList) {
        this.sList = studentList;
    }
    public void addList(Student st){
        sList.add(st);
    }

    public void removeList(Student st){
        sList.remove(st);
    }

    public Student findById(String id){
        for(Student st : sList){
            if(st.getId().equalsIgnoreCase(id)){
                return st;
            }
        }
        return null;
    }

    public List<Student> findByName (String name){
        List<Student> foundList = new ArrayList<>();
        for (Student st : sList){
            if(st.getName().toLowerCase().contains(name.toLowerCase())){
                foundList.add(st);
            }
        }
        return foundList;
    }
}
