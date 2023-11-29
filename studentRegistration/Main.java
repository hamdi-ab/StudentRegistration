package studentRegistration;

import java.util.InputMismatchException;
import java.util.Scanner;

//student registration system
//Name: Hamdi Abdulfetah
//ID: 3107/14
//Section: B
//Department: SWE

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Sample Data because we are not using database
        String[] courseName = {"oop", "DSA", "SP", "OS", "COA", "FN"};
        String[] courseCode = {"SENG 32", "SENG 42", "STAT 22", "SENG 62", "SENG 72", "SENG 82"};
        int[] courseCreditHour = {3, 3, 3, 4, 3, 4};

        // decoration, to make it more professional
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  Student Registration System       ║");
        System.out.println("║  Welcome to the Student Portal!    ║");
        System.out.println("╚════════════════════════════════════╝");

        // Program starts here

        Student student = null;

        //input intake

        System.out.println("============================================");
        System.out.println("           Student Profile                  ");
        System.out.println("============================================");

        String studentType = studentType();

        System.out.print("Full Name: ");
        String studentName = getstringInput();

        String studentID = idInput();

        String studentOccupation = studentOccupation(studentType);

        int studentUID = uidInput();

        int studentYear = yearInput(studentType);

        int studentSemester = semesterInput();

        if (studentType.equalsIgnoreCase("Undergraduate")) {
            student = new UndergraduateStudent(studentName, studentID, studentUID, studentOccupation, studentYear, studentSemester);
        }
        else if (studentType.equalsIgnoreCase("Postgraduate")) {
            student = new PostgraduateStudent(studentName,  studentID, studentUID, studentOccupation, studentYear, studentSemester);
        }

        //menu
        while (true) {

            showMenu();

            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {

                case 1:
                        if(register(courseName ,courseCode,courseCreditHour))
                            student.register();
                        break;

                case 2:
                        profile(student.getStudentName(), student.getStudentID(), student.getStudentUID(), student.getStudentOccupation(),
                                student.getStudentYear(), student.getStudentSemester(), student.isRegistered(),studentType);
                        break;

                case 3:
                        System.out.println("Exiting the program.");
                        return;// returns automatically 0 so the loop will be false

                default:
                        System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    static String getstringInput() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                if (input.matches("^[a-zA-Z ]+$")) {
                    return input;
                } else {
                    System.out.println("Error: Input should contain only alphabetic characters.");
                }
            } else {
                System.out.println("Error: Input cannot be empty.");
            }
        }
    }
    static String idInput(){
            while (true) {
                System.out.print("ID: ");
                String input = scanner.nextLine();
                if (!input.trim().isEmpty()) {
                    if (input.matches("^[0-9/]+$")) {
                        return input;
                    } else {
                        System.out.println("Error: ID should contain only numbers and '/'.");
                    }
                } else {
                    System.out.println("Error: Input cannot be empty.");
                }
            }
    }
    static int uidInput(){
        while(true) {
            System.out.print("UID: ");
            int checkUID = getIntInput();
            if (String.valueOf(checkUID).length() == 6) {

                return checkUID;
            }
            else {
                System.out.println("Invalid UID. Please enter a 6-digit number.");

            }
        }
    }
    static String studentType(){
        while (true){
            System.out.println("Press 'U' to Undergraduate or 'P' to Postgraduate");
            System.out.print("Student Type: ");
            String studType = scanner.nextLine();
            if (studType.equalsIgnoreCase("U"))
                return "Undergraduate";
            else if (studType.equalsIgnoreCase("P")) {
                return "Postgraduate";
            }
            System.out.println("Invalid choice. Please select a valid option.");
        }
    }
    static String studentOccupation(String studentType){
        if(studentType.equalsIgnoreCase("Undergraduate")){
            System.out.print("Student Department: ");
            return getstringInput();
        }
        else {
            System.out.print("Research Field: ");
             return  getstringInput();
        }

    }
    static int yearInput(String studentType){
        if(studentType.equalsIgnoreCase("Undergraduate")) {
            while (true) {
                System.out.print("Student Year (1-7): ");
                int checkYear = getIntInput();
                if (checkYear >= 1 && checkYear <= 7) {

                    return checkYear;
                } else {
                    System.out.println("Invalid Year. Please enter a number between 1 and 7.");

                }
            }
        }
        else {
            while (true) {
                System.out.print("Student Year (1-3): ");
                int checkYear = getIntInput();
                if (checkYear >= 1 && checkYear <= 3) {

                    return checkYear;
                } else {
                    System.out.println("Invalid Year. Please enter a number between 1 and 7.");

                }
            }
        }

    }
    static int semesterInput(){
        while(true) {
            System.out.print("Student Semester (1 or 2): ");
            int checkSemester = getIntInput();
            if (checkSemester == 1 || checkSemester == 2) {
                return checkSemester;
            }
            else {
                System.out.println("Invalid Semester. Please enter 1 or 2.");

            }
        }
    }
    static void showMenu(){
        System.out.println("============================================");
        System.out.println("           Student Registration System");
        System.out.println("============================================");
        System.out.println("Options:");
        System.out.println("1. Register");
        System.out.println("2. Profile");
        System.out.println("3. Exit");
        System.out.println("============================================");
    }
    static boolean register(String[] courseName, String[] courseCode, int[] courseCreditHour){
        boolean registered = false;
        if (!registered) {
            System.out.println("============================================");
            System.out.println("Course Name\tCourse Code\tCourse Credit");
            for (int i = 0; i < courseName.length; i++) {
                System.out.println(courseName[i] + "\t\t\t" + courseCode[i] + "\t\t\t" + courseCreditHour[i]);
            }

            while (true) {
                scanner.nextLine(); // Consume newline
                System.out.println("Press 'R' to register or 'E' to exit");
                System.out.print("Register: ");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("R")) { //Ignores case and checks if it is equal
                    System.out.println("You have been successfully registered");
                    registered = true;;
                    return true;
                } else if (userInput.equalsIgnoreCase("E")) {
                    break;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }
        } else {
            System.out.println("You have already been registered.");
        }
        return false;
    }
    static void profile(String name, String studID, int uid, String occupation, int year, int semester, boolean registered,String studentType){
        System.out.println("============================================");
        System.out.println("Full Name: " + name);
        System.out.println("ID: " + studID);
        System.out.println("UID: " + uid);

        if(studentType.equalsIgnoreCase("Undergraduate"))
            System.out.println("Department: " + occupation);
        else
            System.out.println("Research Field: " + occupation);

        System.out.println("Year: " + year);
        System.out.println("Semester: " + semester);
        System.out.println("Registered: " + registered);
        System.out.println("============================================");
    }
    static int getIntInput() { // input validation method
        int input = -1;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
              input = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                //scanner.next(); // Consume the invalid input
            }
        }

        return input;
    }

}