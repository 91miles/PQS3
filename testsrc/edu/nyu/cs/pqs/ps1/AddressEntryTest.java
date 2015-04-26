package edu.nyu.cs.pqs.ps1;
import static org.junit.Assert.*;

import org.junit.Test;

public class AddressEntryTest {

  
  @Test
  public void testGetterSetter() {
    
    EntryName name = new EntryName("", "");
    EntryPhoneNumber number = new EntryPhoneNumber("", "", "");
    Email email = new Email("");
    Address addr = new Address("", "", "", "", "");
    EntryNote note = new EntryNote("");
    AddressEntry addressEntry = new AddressEntry(name, number, email, addr, note);

    EntryName newName = new EntryName("John", "Rockwell");
    EntryPhoneNumber newNumber = new EntryPhoneNumber("347", "123", "4567");
    Email newEmail = new Email("123@abc.com");
    Address newAddr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote newNote = new EntryNote("Note. ");
    
    addressEntry.setEntryName(newName);
    addressEntry.setEntryPhoneNumber(newNumber);
    addressEntry.setEmail(newEmail);
    addressEntry.setAddress(newAddr);
    addressEntry.setEntryNote(newNote);
    assertEquals(addressEntry.getEntryName(), newName);
    assertEquals(addressEntry.getEntryPhoneNumber(), newNumber);
    assertEquals(addressEntry.getEmail(), newEmail);
    assertEquals(addressEntry.getAddress(), newAddr);
    assertEquals(addressEntry.getNote(), newNote);
  }
  
  @Test
  public void testEquals() {
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    AddressEntry addressEntry2 = new AddressEntry(name, number, email, addr, note);
    assertEquals(addressEntry1, addressEntry2);
  }
  
  @Test
  public void testNotEquals() {
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    Email newEmail = new Email("456@xyz.com");
    AddressEntry addressEntry2 = new AddressEntry(name, number, newEmail, addr, note);
    assertNotEquals(addressEntry1, addressEntry2);
    
    Object obj= new Object();
    // test not equal to an object of another type
    assertNotEquals(addressEntry1, obj);
  }
  
  @Test
  public void testEqualsSelf() {
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry = new AddressEntry(name, number, email, addr, note);
    assertEquals(addressEntry, addressEntry);
  }
  
  @Test
  public void testHashCode() {
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    Email newEmail = new Email("456@xyz.com");
    AddressEntry addressEntry2 = new AddressEntry(name, number, newEmail, addr, note);
    assertNotEquals(addressEntry1.hashCode(), addressEntry2.hashCode());
  }
  
  @Test
  public void testToString() {
    EntryName name = new EntryName("John", "Rockwell");
    EntryPhoneNumber number = new EntryPhoneNumber("347", "123", "4567");
    Email email = new Email("123@abc.com");
    Address addr = new Address
        ("70 Washington Sq S", "New York", "NY", "10012", "United States");
    EntryNote note = new EntryNote("Note. ");
    AddressEntry addressEntry1 = new AddressEntry(name, number, email, addr, note);
    AddressEntry addressEntry2 = new AddressEntry(name, number, email, addr, note);
    assertEquals(addressEntry1.toString(), addressEntry2.toString());
  }
  
}
