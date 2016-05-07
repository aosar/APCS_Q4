import java.util.ArrayList;

public class PatronList{
  public Arraylist patronLibrary;
  public ArrayList firstChar;
  static String alphabet;
  PatronList(){
    alphabet = "abcdefghijklmnopqrstuvwxyz";
    firstChar = new ArrayList<char>();
    patron = new ArrayList<Patron>();
    patronLibrary = new ArrayList()<firstChar>; //arraylist of firstChars
    for(char c: alphabet.toCharArray()){
      firstChar.add(c);
    }
    for(Patron p: patrons){
      name = patron.getName();
      nameChar = name.substring(0,1);
      if(nameChar.equals(c))
        patronLibrary.add(p);
    }
  }
  
  public boolean addPatron(Patron newPatron){
    
  }

}
