package Main;


import Model.StudentList;
import controller.Controller;
import controller.Menu;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Controller controller = new Controller();
        int choice;
        while (true) {
            choice = Menu.chooseInputOption();
            switch (choice) {
                case 1 -> {
                    controller.createStudent(studentList);
                }
                case 2 -> {
                    controller.findAndSortStudent(studentList);
                }
                case 3 -> {
                    controller.deleteOrUpdate(studentList);
                }
                case 4 -> {
                    controller.displayReport(studentList);
                }
                case 5 -> System.exit(0);
            }
        }
    }
}