package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private List<Course> course;

    public Student() {
    }

    public Student(String id, String name, List<Course> course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }


    @Override
    public String toString() {
        for (Course cs : course) {
            System.out.printf("%-10s|%-25s|", id, name);
            cs.toString();
            System.out.println("");
        }

        return "";
    }

    //giúp bạn sắp xếp các đối tượng Student theo thứ tự từ điển của tên sinh viên
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
    
    /* Map này sẽ chứa tên của các khóa học (key) và số lần mỗi khóa học xuất hiện (value)
    
    Kiểm tra xem tên khóa học này đã có trong Map chưa:
    - Nếu chưa có, thêm khóa học vào Map với giá trị ban đầu là 1.
    - Nếu đã có, tăng giá trị (số lần xuất hiện) của khóa học đó lên 1.
    
    Phương thức displayStudentReport() tạo một báo cáo hiển thị mã số sinh viên, tên sinh viên, 
    tên khóa học và số lần khóa học đó xuất hiện trong danh sách khóa học của sinh viên. 
    Phương thức này sử dụng HashMap để đếm số lần xuất hiện của mỗi khóa học và sau đó in ra kết quả
    */
    public String displayStudentReport() {
        Map<String, Integer> coursesName = new HashMap<>();
        for (Course cs : course) {
            String courseName = cs.getCourseName();
            if (!coursesName.containsKey(courseName)) {
                coursesName.put(courseName, 1);
            } else {
                int count = coursesName.get(courseName);
                coursesName.put(courseName, count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : coursesName.entrySet()) {
            String courseName = entry.getKey();
            int count = entry.getValue();
            System.out.printf("%-10s|%-25s|%-20s|%-10d\n", id, name, courseName, count);
        }
        return "";
    }

    public String displayToUpdateOrDelete(){
        for (Course cs : course) {
            System.out.printf("%-10s|%-25s|", id, name);
            cs.displayWithCourseNum();
            System.out.println("");
        }

        return "";
    }

}