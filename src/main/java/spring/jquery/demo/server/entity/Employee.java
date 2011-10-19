package spring.jquery.demo.server.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee implements Persistent {

    public Employee() {
    }

    public Employee(String firstName, String lastName, double baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        this.id = new Long(this.hashCode());
    }

    /**
     * Employee id.
     */
    @Id
    @GeneratedValue
/*(strategy= GenerationType.SEQUENCE)//hsqldb*/
    private Long id;

    /**
     * Employee Name.
     */
    @Column(length = 60, nullable = false)
    private String firstName;

    /**
     * Employee Surname.
     */
    @Column(length = 60, nullable = false)
    private String lastName;
    /**
     * Employee Base salary.
     */
    private double baseSalary;
    /**
     * Employee birthday date.
     */
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Double.compare(employee.baseSalary, baseSalary) != 0) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        temp = baseSalary != +0.0d ? Double.doubleToLongBits(baseSalary) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", baseSalary=" + baseSalary +
                ", birthday=" + birthday +
                '}';
    }
}
