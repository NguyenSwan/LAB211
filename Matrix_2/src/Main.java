//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Matrix inputer1 = new Matrix();
        Matrix inputer2 = new Matrix();
        Matrix matrix1, matrix2, result;
        Validation validation = new Validation();
        while (true) {
            System.out.println("==========Calculator program============");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = validation.checkInputInt("Enter your choice: ", "Just be 1 -> 4", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("---------Addition---------");
                    int rows = validation.checkInputInt("Enter Row Matrix 1: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    int cols = validation.checkInputInt("Enter Column Matrix 1: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    matrix1 = inputer1.input("Enter matrix1", rows, cols);
                    rows = validation.checkInputInt("Enter Row Matrix 2: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    cols = validation.checkInputInt("Enter Column Matrix 2: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    matrix2 = inputer2.input("Enter matrix2", rows, cols);
                    System.out.println("-------------Result-------------");
                    System.out.print(matrix1.toString());
                    System.out.println("+");
                    System.out.print(matrix2.toString());
                    System.out.println("=");
                    try {
                        result = matrix1.add(matrix2);
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("---------Subtraction---------");
                    rows = validation.checkInputInt("Enter Row Matrix 1: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    cols = validation.checkInputInt("Enter Column Matrix 1: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    matrix1 = inputer1.input("Enter matrix1", rows, cols);
                    rows = validation.checkInputInt("Enter Row Matrix 2: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    cols = validation.checkInputInt("Enter Column Matrix 2: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    matrix2 = inputer2.input("Enter matrix2", rows, cols);
                    System.out.println("-------------Result-------------");
                    System.out.print(matrix1.toString());
                    System.out.println("-");
                    System.out.print(matrix2.toString());
                    System.out.println("=");
                    try {
                        result = matrix1.subtract(matrix2);
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("---------Multiplication---------");
                    rows = validation.checkInputInt("Enter Row Matrix 1: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    cols = validation.checkInputInt("Enter Column Matrix 1: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    matrix1 = inputer1.input("Enter matrix1", rows, cols);
                    rows = validation.checkInputInt("Enter Row Matrix 2: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    cols = validation.checkInputInt("Enter Column Matrix 2: ", "Just be >0 ", 1, Integer.MAX_VALUE);
                    matrix2 = inputer2.input("Enter matrix2", rows, cols);
                    System.out.println("-------------Result-------------");
                    System.out.print(matrix1.toString());
                    System.out.println("*");
                    System.out.print(matrix2.toString());
                    System.out.println("=");
                    try {
                        result = matrix1.multiply(matrix2);
                        System.out.println(result.toString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}