package extra.models;

public class Employee implements Comparable<Employee> {

    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (name == null) {
            return -1;
        } else if (o.name == null) {
            return 1;
        } else {
            return name.compareToIgnoreCase(o.name);
        }
    }
}
