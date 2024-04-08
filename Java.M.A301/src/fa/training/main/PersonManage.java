package fa.training.main;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.entities.Teacher;
import fa.training.utils.Validator;


import java.util.Scanner;

public class PersonManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] persons = new Person[10];

        // Input data from the keyboard
        for (int i = 0; i < 10; i++) {
            // Person details
            System.out.println("Enter details for Person " + (i + 1));

            // Enter Name
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();

            // Enter Gender
            String gender;
            do {
                System.out.print("Gender (male/female): ");
                gender = scanner.nextLine();
                if(!Validator.isValidGender(gender)) System.out.println("Invalid gender");
            } while (!Validator.isValidGender(gender));

            // Enter Phone
            String phone;
            do {
                System.out.print("Phone (10 digit number): ");
                phone = scanner.nextLine();
                if(!Validator.isValidPhone(phone)) System.out.println("Invalid phone number. Please re enter");
            } while (!Validator.isValidPhone(phone));

            // Enter Email
            String email;
            do {
                System.out.print("Email: ");
                email = scanner.nextLine();
                if(!Validator.isValidEmail(email)) System.out.println("Invalid email. Please re enter");
            } while (!Validator.isValidEmail(email));

            // Student or Teacher
            int type;
            do {
                System.out.print("Type (0 for Student/1 for Teacher): ");
                type = scanner.nextInt();
                if(type != 0 && type != 1) System.out.println("Please enter valid value");
            } while(type != 0 && type != 1);
            scanner.nextLine();

            // Student details
            if (type == 0) {
                String studentId;
                boolean isValidStudentId = true;

                // Re-prompt until valid and unique student ID is entered
                do {
                    System.out.print("Student ID: ");
                    studentId = scanner.nextLine();

                    // Check if student ID is valid and unique
                    isValidStudentId = Validator.isStudentIdExists(persons,studentId);
                    if (isValidStudentId) {
                        System.out.println("Invalid or duplicate student ID. Please enter a different ID.");
                    }
                } while (isValidStudentId);

                // theory and practice mark check
                double theory;
                boolean isValidMark = false;
                do{
                    System.out.print("Theory mark: ");
                    theory = scanner.nextDouble();

                    // Check if mark is valid
                    isValidMark = Validator.isValidTheoryPractice(theory);
                    if (!isValidMark) {
                        System.out.println("Invalid mark, please re enter mark value between 0 and 10");
                    }
                } while (!isValidMark);

                double practice;
                isValidMark = false;
                do{
                    System.out.print("Practice mark: ");
                    practice = scanner.nextDouble();

                    // Check if mark is valid
                    isValidMark = Validator.isValidTheoryPractice(practice);
                    if (!isValidMark) {
                        System.out.println("Invalid mark, please re enter mark");
                    }
                } while (!isValidMark);
                scanner.nextLine();
                persons[i] = new Student(fullName, gender, phone, email, studentId, theory, practice);
            }
            // Teacher details
            else if (type == 1) {
                double basicSalary = -1, subsidy = -1;
                do{
                    System.out.print("Basic Salary ($): ");
                    basicSalary = scanner.nextDouble();

                    if (basicSalary < 0) {
                        System.out.println("Invalid value of money, please re enter");
                    }
                } while (basicSalary < 0);

                do{
                    System.out.print("Subsidy ($): ");
                    subsidy = scanner.nextDouble();

                    if (subsidy < 0) {
                        System.out.println("Invalid value of money, please re enter");
                    }
                } while (subsidy < 0);
                scanner.nextLine(); // consume newline
                persons[i] = new Teacher(fullName, gender, phone, email, basicSalary, subsidy);
            }
        }
        System.out.println("Finish Input");

        // Update Student
        // Check if update studentID valid
        String studentID;
        do{
            System.out.print("StudentID of student need to update: ");
            studentID = scanner.nextLine();

            // Check if mark is valid
            if (!Validator.isStudentIdExists(persons, studentID)) {
                System.out.println("That student ID is not valid please re enter");
            }
        } while (!Validator.isStudentIdExists(persons, studentID));

        // Update data
        for (Person person : persons) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getStudentID().equals(studentID)) {
                    System.out.println("Update Student: " + student);
                    // Enter Update Name
                    System.out.print("new Full Name: ");
                    String fullName = scanner.nextLine();
                    student.setName(fullName);

                    // Enter Gender
                    String gender;
                    do {
                        System.out.print("New Gender (male/female): ");
                        gender = scanner.nextLine();
                        if(!Validator.isValidGender(gender)) System.out.println("Invalid gender");
                    } while (!Validator.isValidGender(gender));
                    student.setGender(gender);

                    // Enter Phone
                    String phone;
                    do {
                        System.out.print("New Phone (10 digit number): ");
                        phone = scanner.nextLine();
                        if(!Validator.isValidPhone(phone)) System.out.println("Invalid phone number. Please re enter");
                    } while (!Validator.isValidPhone(phone));
                    student.setPhone(phone);

                    // Enter Email
                    String email;
                    do {
                        System.out.print("New Email: ");
                        email = scanner.nextLine();
                        if(!Validator.isValidEmail(email)) System.out.println("Invalid email. Please re enter");
                    } while (!Validator.isValidEmail(email));
                    student.setEmail(email);

                    double theory;
                    boolean isValidMark = false;
                    do{
                        System.out.print("New Theory mark: ");
                        theory = scanner.nextDouble();

                        // Check if mark is valid
                        isValidMark = Validator.isValidTheoryPractice(theory);
                        if (!isValidMark) {
                            System.out.println("Invalid mark, please re enter mark value between 0 and 10");
                        }
                    } while (!isValidMark);
                    student.setTheory(theory);

                    double practice;
                    isValidMark = false;
                    do{
                        System.out.print("New Practice mark: ");
                        practice = scanner.nextDouble();

                        // Check if mark is valid
                        isValidMark = Validator.isValidTheoryPractice(practice);
                        if (!isValidMark) {
                            System.out.println("Invalid mark, please re enter mark");
                        }
                    } while (!isValidMark);
                    student.setPractice(practice);

                    System.out.println("New student data: " + student);
                    break;
                }
            }
        }
        // Display teacher with total salary higher than $1000
        System.out.println("Teachers with salary higher than $1000:");
        for (Person person : persons) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.calculateSalary() > 1000) {
                    System.out.println("Name: " + teacher.getName() + ", Total Salary: $" + teacher.calculateSalary());
                }
            }
        }

        // Report student qualified the course
        System.out.println("Students qualified to pass the course (final mark >= 6):");
        for (Person person : persons) {
            if (person instanceof Student) {
                Student student = (Student) person;
                double finalMark = student.calculateFinalMark();
                if (finalMark >= 6) {
                    System.out.println("Name: " + student.getName() + ", Final Mark: " + finalMark);
                }
            }
        }

        scanner.close();
    }
}
/*
chu
male
0988056221
hc@gmail.com
0
hc01
9
6.5
Maria
female
1234567890
maria@example.com
0
m001
8.0
7.5
John Doe
male
9876543210
john.doe@example.com
1
55000
2200
Sophia
female
4561237890
sophia@example.com
0
s002
7.5
8.0
Adam Smith
male
7894561230
adam.smith@example.com
1
58000
2400
Daniel
male
3216549870
daniel@example.com
0
d003
8.5
9.0
Emily Brown
female
1239874560
emily.brown@example.com
1
400
300
Oliver
male
2345678901
oliver@example.com
0
o004
5.1
6.0
Ethan Johnson
male
8765432109
ethan.johnson@example.com
1
900
2300
Ava
female
3456789012
ava@example.com
0
a005
9.0
8.5
 */

/* Update data
hc01
Chu Duc Huy
male
0988056221
hc@gmail.com
10
10
 */