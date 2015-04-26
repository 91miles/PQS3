package edu.nyu.cs.pqs.ps1;

import java.io.File;
import java.io.IOException;

public class Test {

  static public void main(String[] args) throws IOException {
    AddressBook ab= new AddressBook();
    File file = new File("");
    AddressBook newAb = ab.readAddressBookFromFile(file);
  }
}
