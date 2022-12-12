package extra.models;

public class PaidEmployee extends Employee{

    protected int salary;

    public PaidEmployee(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PaidEmployee{" +
                "salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int result = 0;
        if(o instanceof PaidEmployee){
            result = Integer.compare(salary, ((PaidEmployee) o).salary);
        } else {
            result = Integer.compare(salary, 0);
        }
        return result * -1;
    }
}
