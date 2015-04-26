package edu.nyu.cs.pqs.ps1;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntryNoteTest {

  @Test
  public void testGetterSetter() {
    EntryNote note = new EntryNote("Note. ");
    note.setText("New note. ");
    assertEquals(note.getText(), "New note. ");
  }
  
  @Test
  public void testEquals() {
    EntryNote note1 = new EntryNote("Note. ");
    EntryNote note2 = new EntryNote("Note. ");
    assertEquals(note1, note2);
  }
  
  @Test
  public void testNotEquals() {
    EntryNote note1 = new EntryNote("Note. ");
    EntryNote note2 = new EntryNote("Another note. ");
    assertNotEquals(note1, note2);
    
    Object obj = new Object();
    // test not equal to an object of another type
    assertNotEquals(note1, obj);
  }
  
  @Test
  public void testEqualsSelf() {
    EntryNote note = new EntryNote("Note. ");
    assertEquals(note, note);
  }
  
  @Test
  public void testHashCode() {
    EntryNote note1 = new EntryNote("Note. ");
    EntryNote note2 = new EntryNote("Note. ");
    assertTrue(note1.hashCode()==note2.hashCode());
  }
  
  @Test
  public void testToString() {
    EntryNote note = new EntryNote("Note. ");
    assertEquals(note.toString(), "Note. ");
  }
}
