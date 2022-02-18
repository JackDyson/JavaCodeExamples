package Practical_16;

public class User {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookEntry person1 = new PhoneBookEntry(
                "Jack",
                "Dyson",
                "12345678",
                "jack.c.dyson@gmail.com",
                "52 Lane Road, GH31HB");
        PhoneBookEntry person2 = new PhoneBookEntry(
                "Dave",
                "Johnson",
                "87654321",
                "U2065888@unimail.hud.ac.uk",
                "32  Road Lane, GH31HB");
        PhoneBookEntry person3 = new PhoneBookEntry(
                "Ethan",
                "Montano",
                "67543218",
                "ethan@yahoo.com",
                "99 lane avenue, PO43RS"
        );
        PhoneBookEntry person4 = new PhoneBookEntry(
                "Jack",
                "Dyson",
                "12345677",
                "jack@yahoo.com",
                "44 Lane Road, GH31HB"
        );
        phoneBook.insert("Jack Dyson", person1);
        phoneBook.insert("Dave Johnson", person2);
        phoneBook.insert("Ethan Montano", person3);
        phoneBook.printAll();//original
        System.out.println();
        phoneBook.printEntry("Jack Dyson");//1 entry
        phoneBook.update("Jack Dyson",person4);//changes the entry
        phoneBook.printEntry("Jack Dyson");//new entry
        System.out.println();
        phoneBook.delete("Jack Dyson");//removes entry
        phoneBook.printAll();//new phone book
    }
}