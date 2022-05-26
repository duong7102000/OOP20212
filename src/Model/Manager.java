package Model;

public class Manager extends Employee{
    private float commission;

    public double calculateSalary(){
        return super.calculateSalary() +commission;
    }
}
