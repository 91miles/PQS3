package edu.nyu.cs.pqs.ps1;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmailTest {

  @Test
  public void testGetterSetter() {
    Email email = new Email("123@123.com");
    assertTrue(email.getEmail().equals("123@123.com"));
    email.setEmail("abc@abc.com");
    assertTrue(email.getEmail().equals("abc@abc.com"));
  }

  @Test
  public void testEquals() {
    Email email1 = new Email("123@123.com");
    Email email2 = new Email("123@123.com");
    assertEquals(email1, email2);
  }

  @Test
  public void testNotEquals() {
    Email email1 = new Email("123@abc.com");
    Email email2 = new Email("123@123.com");
    assertNotEquals(email1, email2);
    
    Object obj = new Object();
    // test not equal to an object of another type
    assertNotEquals(email1, obj);
  }

  @Test
  public void testEqualsSelf() {
    Email email1 = new Email("123@123.com");
    assertTrue(email1.equals(email1));
  }

  @Test
  public void testHashCode() {
    Email email1 = new Email("123@123.com");
    Email email2 = new Email("123@123.com");
    assertTrue(email1.hashCode()==email2.hashCode());
  }
  
  @Test
  public void testToString() {
    Email email1 = new Email("123@123.com");
    assertEquals(email1.toString(), "123@123.com");
  }
  
}
