package Practical_16;

public class PhoneBookEntry {
    String firstName;
    String surname;
    String phoneNum;
    String email;
    String address;

    public PhoneBookEntry(String firstName, String surname, String phoneNum, String email, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "PhoneBookEntry{" +
                "First name:'" + firstName + '\'' +
                ", Surname:'" + surname + '\'' +
                ", Phone num:'" + phoneNum + '\'' +
                ", Email:'" + email + '\'' +
                ", Address:'" + address + '\'' +
                '}';
    }
}
