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
        } while (choice == 1);
        Student student = new Student(id, name, courseList);
        return student;

    }

    public Course inputCourse(List<Course> courseList) {
        System.out.print("Enter semester: ");
        String semester = validation.inputString();
        System.out.print("Enter course name: ");
        String courseName = validation.inputCourse();
        int listSize = courseList.size();
        int num;
        if (listSize == 0) {
            num = 1;
        } else {
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

    public void findAndSortStudent(StudentList stList) {
        System.out.println("Enter name to find: ");
        String name = validation.inputName();
        List<Student> foundList = stList.findByName(name);
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