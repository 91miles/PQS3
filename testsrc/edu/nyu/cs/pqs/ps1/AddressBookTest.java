package edu.nyu.cs.pqs.ps1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.nyu.cs.pqs.ps1.AddressBook;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

  @Test
  public void testAddressBookEmpty(){
    AddressBook ab= new AddressBook();
    assertTrue(ab.toString()==" " || ab.toString()=="" || ab.toString()==null);
  }

  @Test
  public void testAddNewEntryAndRemoveOldEntry() {
    AddressBook ab= new AddressBook();
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry = new AddressEntry(name, number, email, addr, note);
    ab.addNewEntry(addressEntry); 
    assertTrue(ab.toString()!=" " && ab.toString()!="" && ab.toString()!=null);

    ab.removeOldEntry(addressEntry);
    assertTrue(ab.toString()==" " || ab.toString()=="" || ab.toString()==null);
  }

  @Test
  public void testSearchFound(){
    AddressBook ab= new AddressBook();
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    name = new EntryName("John", "Rockwell");
    number = new EntryPhoneNumber("347", "123", "1111");
    email = new Email("abc@1234.com");
    addr = new Address
        ("1 West 4 St", "New York", "NY", "10012", "United States");
    note = new EntryNote("Note. ");
    AddressEntry addressEntry2 = new AddressEntry(name, number, email, addr, note);
    ab.addNewEntry(addressEntry1); 
    ab.addNewEntry(addressEntry2); 
    List<AddressEntry> result = ab.search(addressEntry1);
    for (AddressEntry ae : result) {
      assertTrue(ae.equals(addressEntry1) || ae.equals(addressEntry2) );
    }
    assertEquals(ab.search(name).get(0).getEntryName(), name);
    assertEquals(ab.search(number).get(0), number);
    assertEquals(ab.search(email).get(0), email);
    assertEquals(ab.search(addr).size(), addr);
    assertEquals(ab.search(note).size(), note);
  }

  @Test
  public void testSearchNotFound(){
    AddressBook ab= new AddressBook();
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    ab.addNewEntry(addressEntry1); 
    Object obj = new Object();
    // search with a different type
    assertTrue(ab.search(obj).size()==0);

    name = new EntryName("John", "Smith");
    number = new EntryPhoneNumber("347", "123", "1111");
    email = new Email("abc@1234.com");
    addr = new Address
        ("1 West 4 St", "New York", "NY", "10012", "United States");
    note = new EntryNote("New note. ");
    AddressEntry addressEntry2 = new AddressEntry(name, number, email, addr, note); 
    assertTrue(ab.search(name).size()==0);
    assertTrue(ab.search(number).size()==0);
    assertTrue(ab.search(email).size()==0);
    assertTrue(ab.search(addr).size()==0);
    assertTrue(ab.search(note).size()==0);
    assertTrue(ab.search(addressEntry2).size()==0);
  }

  @Test
  public void testSaveToFileAndReadFromFile_Succeed() throws IOException {
    AddressBook ab= new AddressBook();
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    ab.addNewEntry(addressEntry1); 
    name = new EntryName("John", "Smith");
    number = new EntryPhoneNumber("347", "123", "1111");
    email = new Email("abc@1234.com");
    addr = new Address
        ("1 West 4 St", "New York", "NY", "10012", "United States");
    note = new EntryNote("New note. ");
    AddressEntry addressEntry2 = new AddressEntry(name, number, email, addr, note);
    ab.addNewEntry(addressEntry2);
    File file = ab.saveAddressBookToFile();
    AddressBook newAb = ab.readAddressBookFromFile(file);
    assertEquals(newAb, ab);
  }

  @Test(expected=FileNotFoundException.class)
  public void testReadFromFile_FileNotFoundException()
      throws IOException {
    AddressBook ab= new AddressBook();
    File file = new File("");
    AddressBook newAb = ab.readAddressBookFromFile(file);
  }

  @Test
  public void testToString(){
    AddressBook ab= new AddressBook();
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry = new AddressEntry(name, number, email, addr, note);
    ab.addNewEntry(addressEntry); 
    String output = " Name: John Rockwell\n"+"Phone Number: 347-123-4567\n"+
        "Email: 123@abc.com\n"+"Address: 70 Washington Sq S\n"+"New York, NY 10012\n"
        +"United States\n"+"Note:Note. \n";
    assertEquals(ab.toString(), output);
  }
}
