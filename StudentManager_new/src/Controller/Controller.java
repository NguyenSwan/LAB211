package controller;

import Model.StudentList;
import entity.Course;
import entity.Student;
import util.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    StudentList studentList = new StudentList();
    Student student = new Student();
    Course course = new Course();
    Validation validation = new Validation();

    /*nhập thông tin cho một sinh viên mới, bao gồm tên và danh sách các khóa học của sinh viên đó
    
    Vòng lặp do-while được sử dụng để cho phép người dùng thêm nhiều khóa học cho sinh viên
    
    Trong mỗi lần lặp, phương thức inputCourse được gọi để nhập thông tin khóa học và trả về đối tượng Course
    
    */
    public  Student inputNewStudentInformation(String id) {
        System.out.print("Enter student name: ");
        String name = validation.inputName();
        int choice;
        List<Course> courseList = new ArrayList<>();
        do {
            Course course = inputCourse(courseList);
            courseList.add(course);
            System.out.print("Do you want to add more course for this student?\nPress 1 (Yes) or 0 (No): ");
            choice = validation.inputOption(0, 1);
        } while (choice == 1);  //Vòng lặp tiếp tục nếu người dùng chọn 1 
        /*Sau khi đã nhập xong tên sinh viên và các khóa học, tạo một đối tượng Student mới với id, name, và courseList.
        Trả về đối tượng Student vừa tạo.*/
        Student student = new Student(id, name, courseList);
        return student;

    }

    public Course inputCourse(List<Course> courseList) {
        System.out.print("Enter semester: ");
        String semester = validation.inputString();
        System.out.print("Enter course name: ");
        String courseName = validation.inputCourse();
        int listSize = courseList.size();  //Khởi tạo biến listSize để lưu số lượng khóa học hiện tại trong courseList
        int num;  //STT khoa hoc
        if (listSize == 0) {
            num = 1;
        } else {
            /*Nếu courseList không rỗng, lấy khóa học cuối cùng trong danh sách (lastcs), 
            và gán num bằng số thứ tự của khóa học cuối cùng cộng thêm 1*/
            Course lastcs = courseList.get(listSize - 1);
            num = lastcs.getNum() + 1;
        }
        Course course = new Course(num, semester, courseName);
        return course;
    }

    public  void createStudent(StudentList stList) {
        do {
            System.out.print("Enter student ID: ");
            String id = validation.inputId().toUpperCase();
            Student st = stList.findById(id);
            if (st == null) {
                st = inputNewStudentInformation(id);
                stList.addList(st);
            } else {
                System.out.println("This ID had already existed for student as bellow: ");
                System.out.printf("%-10s|%-25s|%-10s|%-15s|%-15s\n", "ID", "Name", "Course Num", "Semester", "Course Name");
                st.displayToUpdateOrDelete();
                System.out.print("Do you want to add more course for the following student?\nPress 1 (Yes) or 0 (Exit): ");
                int choice = validation.inputOption(0, 1);
                if (choice == 1) {
                    List<Course> courseList = st.getCourse();
                    Course course = inputCourse(courseList);
                    courseList.add(course);
                    st.setCourse(courseList);
                }
            }
        } while (stList.getStudentList().size() < 3);
        System.out.print("Do you want to continue?\nPress 1 (Yes) or 0 (No): ");
        int option = validation.inputOption(0, 1);
        if (option == 1) {
            createStudent(stList);
        }
    }

    /*Phương thức findAndSortStudent cho phép người dùng nhập tên sinh viên và tìm kiếm các sinh viên có tên giống nhau.
    Sau đó, nó sẽ sắp xếp danh sách các sinh viên tìm thấy theo thứ tự bảng chữ cái của tên.
    Kết quả tìm kiếm được hiển thị ra màn hình dưới dạng bảng có cột ID, Name, Semester, Course Name.
    Nếu không tìm thấy sinh viên nào có tên tương ứng, thông báo lỗi sẽ được hiển thị.*/
    public void findAndSortStudent(StudentList stList) {
        System.out.println("Enter name to find: ");
        String name = validation.inputName();
        List<Student> foundList = stList.findByName(name);
        /*Kiểm tra xem danh sách foundList có rỗng hay không (null). Nếu không rỗng:
        Sử dụng Collections.sort(foundList) để sắp xếp các sinh viên trong foundList. 
        Đối tượng Student được sắp xếp dựa trên cài đặt của phương thức compareTo 
        trong lớp Student, vì Student implements Comparable<Student>*/
        if (foundList != null) {
            Collections.sort(foundList);
            System.out.println("List student found: ");
            System.out.printf("%-10s|%-25s|%-15s|%-15s\n", "ID", "Name", "Semester", "Course Name");
            for (Student st : foundList) {
                st.toString();
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayReport(StudentList stList) {
        System.out.printf("%-10s|%-25s|%-20s|%s\n", "ID", "Name", "Course Name", "Total Of Course");
        for (Student st : stList.getStudentList()) {
            st.displayStudentReport();
        }
    }

    public void deleteOrUpdate(StudentList stList) {
        System.out.println("Enter ID to find student: ");
        String id = validation.inputId();
        Student st = stList.findById(id);
        if (st != null) {
            System.out.printf("%-10s|%-25s|%-10s|%-15s|%-15s\n", "ID", "Name", "Course Num", "Semester", "Course Name");
            st.displayToUpdateOrDelete();
            System.out.print("Do you want to Update of Delete student?\nPress 1 (Update) of 2 (Delete) or 0(Exit): ");
            int choice = validation.inputOption(0, 2);
            switch (choice) {
                case 1 -> {
                    update(st, stList);
                }
                case 2 -> {
                    delete(st, stList);
                }
                case 3 -> {
                    return;
                }
            }
        } else {
            System.out.println("ID not found!");
        }
    }

    public void update(Student st, StudentList stList) {
        System.out.print("Do you want to update entire student (Enter '1') or update a course (Enter '2')? ");
        int option = validation.inputOption(1, 2);
        if (option == 1) {
            stList.removeList(st);
            stList.addList(inputNewStudentInformation(st.getId()));
        } else {
            List<Course> courseList = st.getCourse();
            System.out.print("Enter course num to update: ");
            int num = validation.inputInt();
            Course course = findCourse(num, courseList);
            if (course != null) {
                courseList.remove(course);
                courseList.add(inputCourse(courseList));
            } else {
                System.out.println("Course number not found! Failed to update.");
                return;
            }
            st.setCourse(courseList);
        }
        System.out.println("Updated successfully!");
    }

    public void delete(Student st, StudentList stList) {

        System.out.print("Do you want to delete entire student (Enter '1') or delete a course (Enter '2')? ");
        int option = validation.inputOption(1, 2);
        if (option == 1) {
            stList.removeList(st);
        } else {
            List<Course> courseList = st.getCourse();
            if (courseList.size() > 1) {
                System.out.print("Enter course num to delete: ");
                int num = validation.inputInt();
                Course course = findCourse(num, courseList);
                if (course != null) {
                    courseList.remove(course);
                } else {
                    System.out.println("Course number not found! Failed to delete.");
                    return;
                }
                st.setCourse(courseList);
            } else {
                System.err.println("Existing only 1 course for this student, failed to delete course.");
                return;
            }
        }
        System.out.println("Deleted successfully!");
    }

    public  Course findCourse(int num, List<Course> courseList) {
        for (Course course : courseList) {
            if (course.getNum() == num) {
                return course;
            }
        }
        return null;
    }

}