package files.writing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Form {
    private String firstNameQ;
    private String firstName;
    private String surnameQ;
    private String surname;
    private String ageQ;
    private int age;
    private String genderQ;
    private Gender gender;
    private String salaryQ;
    private double salary;
    private String livesInAFlatQ;
    private boolean livesInAFlat;
    private String isAStudentQ;
    private boolean isAStudent;

    public void askQs() {
        this.firstNameQ = "Name: \n";
        this.surnameQ = "Surname: \n";
        this.ageQ = "Age: \n";
        this.genderQ = "Gender (enter M or W): \n";
        this.salaryQ = "Salary: \n";
        this.livesInAFlatQ = "Living in a flat (enter YES or NO)): \n";
        this.isAStudentQ = "Student (enter YES or NO): \n";

        String fileName = "output_form.txt";

        File file = new File(fileName);

        System.out.println(firstNameQ);
        Scanner scanner = new Scanner(System.in);
        this.firstName = scanner.nextLine();
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(firstNameQ);
            writer.write(firstName + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(surnameQ);
        Scanner scanner1 = new Scanner(System.in);
        this.surname = scanner1.nextLine();
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(surnameQ);
            writer.write(surname + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ageQ);
        Scanner scanner2 = new Scanner(System.in);
        this.age = scanner2.nextInt();
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(ageQ);
            writer.write(age + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(genderQ);
        Scanner scanner3 = new Scanner(System.in);
        String genderStr = scanner3.nextLine();
        if (genderStr.equalsIgnoreCase("M")) {
            this.gender = Gender.MALE;
        } else {
            this.gender = Gender.FEMALE;
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(genderQ);
            writer.write(gender + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(salaryQ);
        Scanner scanner4 = new Scanner(System.in);
        this.salary = scanner4.nextDouble();
        try(FileWriter writer = new FileWriter(file, true)) {
            writer.write(salaryQ);
            writer.write(salary + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(livesInAFlatQ);
        Scanner scanner5 = new Scanner(System.in);
        String liveInAFlatStr = scanner5.nextLine();
        if (liveInAFlatStr.equalsIgnoreCase("YES")) {
            this.livesInAFlat = true;
        } else {
            this.livesInAFlat = false;
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(livesInAFlatQ);
            writer.write(liveInAFlatStr.toUpperCase(Locale.ROOT) + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(isAStudentQ);
        Scanner scanner6 = new Scanner(System.in);
        String isAStudentStr = scanner6.nextLine();
        if (isAStudentStr.equalsIgnoreCase("YES")) {
            this.isAStudent = true;
        } else {
            this.isAStudent = false;
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(isAStudentQ);
            writer.write(isAStudentStr.toUpperCase(Locale.ROOT) + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
