package entity;

public class Course {
    private int num;
    private String semester;
    private String courseName;

    public Course() {
    }

    public Course(int num, String semester, String courseName) {
        this.semester = semester;
        this.courseName = courseName;
        this.num = num;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        System.out.printf("%-15s|%-15s", semester, courseName);
        return "";
    }

    public String displayWithCourseNum(){
        System.out.printf("%-10s|", num);
        this.toString();
        return "";
    }

}
