package util;

import java.util.Scanner;

public class Validation {
    private Scanner sc = new Scanner(System.in);

    public  int inputOption(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int rs;
        while (true) {
            try {
                rs = Integer.parseInt(sc.nextLine());
                if (rs < min || rs > max) {
                    throw new ArithmeticException("Not valid. Enter a valid number from " + min + " to " + max + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid integer number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return rs;
    }

    public  String inputId() {
        String id;
        while (true) {
            try {
                id = sc.nextLine().trim();
                if (!id.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Invalid ID. Please enter a valid ID.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return id;
    }

    public  String inputName() {
        String name;
        while (true) {
            try {
                name = sc.nextLine();

                if (!name.matches("[a-zA-Z .]+")) {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        name = formatName(name);
        return name;
    }

    public  String inputString() {
        String str;
        while (true) {
            try {
                str = sc.nextLine();

                if (str.length() > 25 || str.isBlank()) {
                    throw new IllegalArgumentException("Require to input string and no more than 25 words.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return str;
    }

    public  int inputInt() {
        int rs;
        while (true) {
            try {
                rs = Integer.parseInt(sc.nextLine());
                if (rs <= 0) {
                    throw new ArithmeticException("Not valid. Enter a positive number.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid integer number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return rs;
    }

    public  String inputCourse(){
        String str;
        while (true){
            str = sc.nextLine().trim();
            if (str.equalsIgnoreCase("java")
                    || str.equalsIgnoreCase(".net")
                    || str.equalsIgnoreCase("c/c++")) {
                return str;
            }
            System.err.println("Please enter one valid course as bellows: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    public  String formatName(String name) {
        String[] words = name.split(" ");
        StringBuilder formattedNameBuilder = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String restOfWord = word.substring(1).toLowerCase();
                String formattedWord = firstLetter + restOfWord;
                formattedNameBuilder.append(formattedWord).append(" ");
            }
        }

        String formattedName = formattedNameBuilder.toString().trim();
        formattedName = formattedName.replaceAll("[^a-zA-Z\\s.]", ""); // Loại bỏ tất cả các kí tự đặc biệt
        formattedName = formattedName.replaceAll("\\s+", " ");
        return formattedName;
    }
}