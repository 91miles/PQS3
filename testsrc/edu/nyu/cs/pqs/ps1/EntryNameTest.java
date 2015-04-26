package edu.nyu.cs.pqs.ps1;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntryNameTest {

  @Test
  public void testGetterSetter() {
    EntryName jon = new EntryName("Jon");
    EntryName molly = new EntryName("Molly", "Brown");
    jon.setFirstName("John"); 
    molly.setLastName("Black");
    assertEquals(jon.getFirstName(),"John");
    assertEquals(molly.getLastName(), "Black");
  }
  
  @Test
  public void testEquals() {
    EntryName jon1 = new EntryName("Jon", "Bell");
    EntryName jon2 = new EntryName("Jon", "Bell");
    assertEquals(jon1, jon2);
  }
  
  @Test
  public void testNotEquals() {
    EntryName jon1 = new EntryName("Jon", "Bell");
    EntryName jon2 = new EntryName("Jon", "Rockwell");
    assertNotEquals(jon1, jon2);
    
    Object obj = new Object();
    // test not equal to an object of another type
    assertNotEquals(jon1, obj);
  }
  
  @Test
  public void testEqualsSelf() {
    EntryName jon = new EntryName("Jon", "Bell");
    assertEquals(jon, jon);
  }
  
  @Test
  public void testHashCode() {
    EntryName jon1 = new EntryName("Jon", "Bell");
    EntryName jon2 = new EntryName("Jon", "Bell");
    assertTrue(jon1.hashCode()==jon2.hashCode());
  }
  
  @Test
  public void testToString() {
    EntryName jon = new EntryName("Jon", "Bell");
    assertEquals(jon.toString(), "Jon Bell");
  }
  
}
