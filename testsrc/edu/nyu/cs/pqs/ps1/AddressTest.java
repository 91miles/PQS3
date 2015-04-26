package edu.nyu.cs.pqs.ps1;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddressTest {

  @Test
  public void testGetterSetter() {
    Address addr = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    addr.setCountry("China, PR");
    addr.setState("Shanghai");
    addr.setString("Shanghai"); // should be setCity() 
    addr.setStreet("3663 North Zhongshan Rd");
    addr.setZip("200062");
    assertEquals(addr.getCountry(), "China, PR");
    assertEquals(addr.getState(), "Shanghai");
    assertEquals(addr.getCity(), "Shanghai");
    assertEquals(addr.getStreet(), "3663 North Zhongshan Rd");
    assertEquals(addr.getZip(), "200062");
  }

  @Test
  public void testEquals() {
    Address addr1 = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    Address addr2 = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    assertEquals(addr1, addr2);
  }

  @Test
  public void testNotEquals() {
    Address addr1 = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    Address addr2 = new Address("20 Washington Sq S", "New York", "NY", "10012", "United States");
    assertNotEquals(addr1, addr2);

    Object obj = new Object();
    // test not equal to an object of another type
    assertNotEquals(addr1, obj);
  }

  @Test
  public void testEqualsSelf() {
    Address addr = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    assertEquals(addr, addr);
  }

  @Test
  public void testHashCode() {
    Address addr1 = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    Address addr2 = new Address("70 Washington Sq S", "New York", "NY", "10012", "United States");
    assertEquals(addr1.hashCode(), addr2.hashCode());
  }

  @Test
  public void testToString() {
    String street = "70 Washington Sq S";
    String city="New York";
    String state="NY";
    String zip="10012";
    String  country="United States";
    Address addr = new Address(street, city, state, zip, country);

    assertEquals(addr.toString(), street + "\n" +
        city + ", " + state + " " + zip + "\n" +
        country);
  }

}
