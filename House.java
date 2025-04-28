/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  
  //Attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * Constructor
   * @param name the name of the house
   * @param address the location of the house
   * @param nFloors the number of floors in the house
   * @param hasDR whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDR) {
    super(name,address,nFloors);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDR;
  }

  /**
   * return whether the house has dining room
   * @return T/F
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * return the number of residents in the house
   * @return number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * add a student to the house
   * @param s student moving in
   */
  public void moveIn(Student s) {
    this.residents.add(s);
  }

  /**
   * remove a student from the house
   * @param s student needed to be moved out
   * @return the student who moved out
   */
  public Student moveOut(Student s) {// return the Student who moved out
    if (!residents.contains(s)) {
      throw new RuntimeException(s + "is not a resident here!");
    } this.residents.remove(s);
    return s;
  }

  /**
   * return whether the student is a resident of the house
   * @param s student who is asked about
   * @return T/F
   */
  public boolean isResident(Student s) {
    if (this.residents.contains(s)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    new House("Washburn", "4 Seelye Drive", 3,false);
  }

}
