public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private long phone;
    private String socialSecurityNumber;
    private Address homeAddress;
    private Address workAddress;

    private short age;
    private boolean isMarried;


    public Person(String firstName, String lastName, String email, long phone,
                  String socialSecurityNumber, Address homeAddress, Address workAddress,
                  short age, boolean isMarried) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.socialSecurityNumber = socialSecurityNumber;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.age = age;
        this.isMarried = isMarried;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }


    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;

    }
    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }
}