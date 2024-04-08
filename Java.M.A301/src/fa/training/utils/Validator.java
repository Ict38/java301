package fa.training.utils;

import fa.training.entities.Person;
import fa.training.entities.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public static boolean isValidDate(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone){
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidTheoryPractice(double mark) {
        return mark >= 0 && mark <= 10;
    }

    // Check if StudentID exists
    public static boolean isStudentIdExists(Person[] persons, String studentId) {
        for (Person person : persons) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getStudentID().equals(studentId)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Check if Valid Gender
    public static boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");
    }
}
