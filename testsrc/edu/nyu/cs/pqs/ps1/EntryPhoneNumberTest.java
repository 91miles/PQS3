package edu.nyu.cs.pqs.ps1;
import static org.junit.Assert.*;

import org.junit.Test;

public class EntryPhoneNumberTest {

  @Test
  public void testGetterSetter() {
    EntryPhoneNumber num = new EntryPhoneNumber("347", "123", "1234");
    num.setAreaCode("111");
    num.setNumber("111");
    num.setPrefix("111");
    assertEquals(num.getAreaCode(), "111");
    assertEquals(num.getNumber(), "111");
    assertEquals(num.getPrefix(), "111");
  }

  @Test
  public void testEquals() {
    EntryPhoneNumber num1 = new EntryPhoneNumber("347", "123", "1234");
    EntryPhoneNumber num2 = new EntryPhoneNumber("347", "123", "1234");
    assertEquals(num1, num2);
  }

  @Test
  public void testNotEquals() {
    EntryPhoneNumber num1 = new EntryPhoneNumber("347", "123", "9876");
    EntryPhoneNumber num2 = new EntryPhoneNumber("347", "123", "1234");
    assertNotEquals(num1, num2);
    
    Object obj = new Object();
    // test not equal to an object of another type
    assertNotEquals(num1, obj);
  }

  @Test
  public void testEqualsSelf() {
    EntryPhoneNumber num = new EntryPhoneNumber("347", "123", "1234");
    assertEquals(num, num);
  }

  @Test
  public void testHashCode() {
    EntryPhoneNumber num1 = new EntryPhoneNumber("347", "123", "1234");
    EntryPhoneNumber num2 = new EntryPhoneNumber("347", "123", "1234");
    assertEquals(num1.hashCode(), num2.hashCode());
  }

  @Test
  public void testToString() {
    EntryPhoneNumber num = new EntryPhoneNumber("347", "123", "1234");
    assertEquals(num.toString(), "347-123-1234");
  }
}
