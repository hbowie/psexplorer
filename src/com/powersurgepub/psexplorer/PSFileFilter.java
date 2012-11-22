/*
 * PSFileFilter.java
 *
 * Created on November 1, 2006, 5:11 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.powersurgepub.psexplorer;

  import java.io.*;
  import java.util.*;

/**
 *
 * @author hbowie
 */
public class PSFileFilter 
    implements FilenameFilter {
  
  protected String findValue = "";
  
  public static final String FIND_ANY = "*";
  
  protected boolean caseSensitive = true;
  
  protected int location = 0;
  
  public static final int BEGINS_WITH = 0;
  public static final int CONTAINS = 1;
  public static final int ENDS_WITH = 2;
  public static final int EQUALS = 3;
  public static final int EXTENSION = 4;
  
  protected boolean selected = false;
  
  /** Creates a new instance of PSFileFilter */
  public PSFileFilter (String findValue, boolean caseSensitive, int location) {
    this.findValue = findValue;
    this.caseSensitive = caseSensitive;
    this.location = location;
  }
  
  public boolean accept (File dir, String name) {
    selected = true;
    switch (location) {
      case BEGINS_WITH:
        startsWith (name);
        break;
      case CONTAINS:
        contains (name);
        break;
      case ENDS_WITH:
        endsWith (name);
        break;
      case EQUALS:
        nameEquals (name);
        break;
      case EXTENSION:
        extEquals (name);
        break;
    } // end switch
    return selected;
  }
  
  /** 
    Determine whether the file name (without path information)
    contains the passed String, with or without case
    sensitivity.
   
    @param name File name.

   */  
  public void contains (String name) {
    String a;
    String b;
    if (caseSensitive) {
      a = name.toString();
      b = findValue;
    } else {
      a = name.toString().toLowerCase();
      b = findValue.toLowerCase();
    }
    int i = a.indexOf(b);
    if (i < 0) {
      setSelected (false);
    }
  } // end method
  
  /** 
    Determine whether the file name (without path information
    and without file extension) ends with the passed String, 
    with or without case sensitivity.
   
    @param name File name.
   */  
  public void endsWith (String name) {
    String a;
    String b;
    int dot = lastDotPosition(name);
    if (caseSensitive) {
      a = name.substring(0,dot);
      b = findValue;
    } else {
      a = name.substring(0,dot).toLowerCase();
      b = findValue.toLowerCase();
    }
    if (! a.endsWith(b)) {
      setSelected (false);
    }
  } // end method

   /** 
    Determine whether the file name has the passed String
    as a file extension, without case sensitivity.
   
    @param name File name.
   */  
  public void extEquals (String name) {
    String a;
    String b;
    int dot = name.toString().lastIndexOf ('.');
    if (dot < 0) {
      a = "";
    } else {
      a = name.substring(dot + 1).toLowerCase();
    }
    b = findValue.toLowerCase();
    if (! a.equals(b)) {
      setSelected (false);
    }
  } // end method 

  /** 
    Determine whether the file name (without path information
    and without file extension) equals the passed String, 
    with or without case sensitivity.
   
    @param name File name.
   */  
  public void nameEquals (String name) {
    String a;
    String b;
    int dot = lastDotPosition(name);
    if (caseSensitive) {
      a = name.substring(0,dot);
      b = findValue;
    } else {
      a = name.substring(0,dot).toLowerCase();
      b = findValue.toLowerCase();
    }
    if (a.equals(b)) {
      // do not deselect
    } else
    if (b.equals (FIND_ANY)) {
      // do not deselect
    } else {
      setSelected (false);
    }
  } // end method
  
   /** 
    Determine whether the file name (without path information)
    starts with the passed String, with or without case
    sensitivity.
   
    @param name File name.
   */  
  public void startsWith (String name) {
    String a;
    String b;
    if (caseSensitive) {
      a = name.toString();
      b = findValue;
    } else {
      a = name.toString().toLowerCase();
      b = findValue.toLowerCase();
    }
    if (! a.startsWith (b)) {
      setSelected (false);
    }
  } // end method
  
  /** 
    Return the position of the last dot (period) in the new file name.
   
    @return Position of last period in the new file name, or length of
            file name if no period in file name.
   */
  public int lastDotPosition (String name) {
    int dot = name.toString().lastIndexOf ('.');
    if (dot < 0) {
      dot = name.length();
    }  
    return dot;
  }
  
  /** 
    Sets the selected flag to the passed value.
   
    @param selected Has this file been selected for further processing?
   */  
  public void setSelected (boolean selected) {
    this.selected = selected;
  }
  
}
