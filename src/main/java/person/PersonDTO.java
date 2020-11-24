package person;

import com.sun.jdi.connect.Connector;

public class PersonDTO implements Comparable<PersonDTO> {
    private final String firstName;
    private final String lastName;
    private Integer age;

    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(PersonDTO o) {
        PersonDTO that = (PersonDTO) o;
        return this.age.compareTo(that.age);
    }

    @Override
    public String toString() {
        return String.format("Personal Details: LastName: %s, FirstName: %s, Age: %d", this.getLastName(),
                this.getFirstName(),
                this.getAge());
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
