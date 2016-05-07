import java.util.ArrayList;

public class PatronList{
  public Arraylist patronLibrary;
  public ArrayList firstChar;
  static String alphabet;
  PatronList(){
    alphabet = "abcdefghijklmnopqrstuvwxyz";
    ArrayList<String> letterSection;
    firstChar = new ArrayList<char>();
    patron = new ArrayList<Patron>();
    patronLibrary = new ArrayList()<firstChar>; //arraylist of firstChars
    /**
     *From unsorted list, add patrons to each 
     * alphabetical section
     * 
     */
    for(char c: alphabet.toCharArray()){
      //firstChar.add(c);
      letterSection =  = new ArrayList<String>(); //reset the section for the next character
      letterSection.add(c.toString());
      for(Patron p: patrons){
        name = patron.getName();
        nameChar = name.substring(0,1);
        if(nameChar.equals(c))
          letterSection.add(p);
      }
      firstChar.add(letterSection);
  }
    }
    
  public boolean addPatron(Patron newPatron){
    
  }

}
