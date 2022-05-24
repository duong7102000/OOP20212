package Model;

public class Manager extends Employee{
    private float commission;

    public double calculateSalary(float commission){
        return getTime()*getHourlyPayRate()+commission;
    }
}
