package fa.training.entities;

public class Teacher extends Person{
    private double basicSalary, subsidy;

    public Teacher(String name, String gender, String phone, String email, double basicSalary, double subsidy) {
        super(name, gender, phone, email);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", basicSalary=" + basicSalary +
                ", subsidy=" + subsidy +
                '}';
    }

    public double calculateSalary(){
        return basicSalary + subsidy;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }
}
