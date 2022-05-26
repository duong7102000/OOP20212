package Model;

public class Employee {
    private String nameEmployee;
    private int age;
    private String email;
    private double hourlyPayRate;
    private int time;

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double calculateSalary(){
        return hourlyPayRate*time;
    }
}
