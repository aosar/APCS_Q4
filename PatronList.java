import java.util.ArrayList;

public class PatronList{
  private ArrayList<Patron> patron;
  public ArrayList<patron> patronLibrary;
  static String alphabet;
  PatronList(){
    alphabet = "abcdefghijklmnopqrstuvwxyz";
    ArrayList<Patron> patron = new ArrayList<Patron>();
    patronLibrary = new ArrayList<Patron>(); //arraylist
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
   public Patron searchPatron(String username, String password){
    for(Patron p: patronLibrary)
        if(p.getUsername().compareTo(username)==0)
            return p;
    return null;
  }
    
  public boolean addPatron(Patron newPatron){
    for(int i=0; i < 27; i++){
        if(newPatron.getUsername().substring(0,1).equals(patronLibrary.get(i))) {
            patronLibrary.get(i).add(newPatron);
        }
    }
  }
  public boolean checkCredentials(String username, String password){
      return searchPatron(username, password)!= null;
  }
  public void fillPatronIndexing(){
        for(int i=0; i < 27; i++){
            String currentLetter;
            currentLetter = alphabet.substring(i,i+1);
            patron.add(currentLetter);
            patronLibrary.add(patron);
        }
    }
  
}
