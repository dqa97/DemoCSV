package Views;

import Commons.FuncFileCSV;
import Models.Students;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Students> listStudents = new ArrayList<Students>();

    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu(){
        System.out.println("1. Add New Student.\n" +
                "2. Show Information Student.\n" +
                "3. Exit.");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        switch (choose){
            case "1":
                addNewStudent();
                break;
            case "2":
                showInformationStudent();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Fail! Please choose again! Enter to continue...");
                scanner.nextLine();
                displayMainMenu();
        }
    }

    private static void showInformationStudent() {
        listStudents = FuncFileCSV.getFileCVSToListStudent();
        for (Students students: listStudents){
            System.out.println("---------------------------");
            System.out.println("Name: " + students.getName());
            System.out.println("Grade: " + students.getGrade());
            System.out.println("Address: " + students.getAddress());
            System.out.println("---------------------------");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter to continue...");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewStudent() {
        listStudents = FuncFileCSV.getFileCVSToListStudent();
        Scanner scanner = new Scanner(System.in);

        Students students = new Students();
        System.out.println("Enter name ");
        students.setName(scanner.nextLine());
        System.out.println("Enter grade");
        students.setGrade(scanner.nextLine());
        System.out.println("Enter address");
        students.setAddress(scanner.nextLine());
        listStudents.add(students);
        FuncFileCSV.writeStudentToFileCSV(listStudents);
        System.out.println("Add new student complete! Enter to continue...");
        scanner.nextLine();
        displayMainMenu();
    }
}
