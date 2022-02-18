package Practical_16;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook{
    Map<String, PhoneBookEntry> phoneBookMap = new HashMap();

    public void insert(String fullName, PhoneBookEntry pB){
    //entry for new full name
        if(!phoneBookMap.containsKey(fullName)){
            phoneBookMap.put(fullName,pB);
        }
        
    }
    public void update(String fullName, PhoneBookEntry newEntry){
    //change an entry for an existing full name
        if(phoneBookMap.containsKey(fullName)){
            phoneBookMap.replace(fullName,newEntry);
        }
    }
    public void delete(String fullName){
    //delete an entry for an existing full name
        if(phoneBookMap.containsKey(fullName)){
            phoneBookMap.remove(fullName);
        }

    }
    public void printEntry(String fullName){
    //print details of existing entry if present in the phone book by searching the phone book for a given full name
        if(phoneBookMap.containsKey(fullName)){
            System.out.println(phoneBookMap.get(fullName).toString());
        }
    }
    public void printAll(){
    //prints all entries in the phone book
        for(PhoneBookEntry pB: phoneBookMap.values()){
            System.out.println(pB.toString());
        }
    }
}
