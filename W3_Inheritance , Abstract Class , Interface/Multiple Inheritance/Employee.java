class Employee extends Sortable{
    private final String name;
    private double salary;
    private final int hireday;
    private final int hiremonth;
    private final int hireyear;

    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s; hireday = day;
        hiremonth = month; hireyear = year;
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireyear;
    }

    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b;
        if (salary < eb.getSalary()) return -1;
        if (salary > eb.getSalary()) return 1;
        return 0;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name;
    }
}