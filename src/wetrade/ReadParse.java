
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wetrade;

import java.io.*;

/**
 *
 * @author Robin
 */
public class ReadParse {
    
    public String readTextFile(String fileName) {
  
  String returnValue = "";
  FileReader file = null;
  
  try {
    file = new FileReader(fileName);
    BufferedReader reader = new BufferedReader(file);
    String line = "";
    while ((line = reader.readLine()) != null) {
      returnValue += line + " ";
    }
  } catch (Exception e) {
      throw new RuntimeException(e);
  } finally {
    if (file != null) {
      try {
        file.close();
      } catch (IOException e) {
        System.out.println("FileNotfound"); 
      }
    }
  }
  return returnValue;
}
    
}

