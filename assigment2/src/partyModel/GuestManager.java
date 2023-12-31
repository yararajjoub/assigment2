// Student: YARA RAJJOUB
// Program: SYSTEMUTVECKLARE ÅK 1

package partyModel;

import java.util.Scanner;
public class GuestManager {
  /* Keep ONLY the following instance variables for the class:- number of guests currently stored in the list/array (not the total possible number of guests (use .length for this))   - one array for the list with guests where   the guests are objects of class Guest*/
  private int nbrOfGuests = 0;
  private Guest[] guestList;
  /* Create a constructor with one parameter which is the max number of elements (guests) in the list/array. Create the array with the max number of elements. Check that the max number of Guests is larger than 0. If max number of guests is not larger than 0 ask the user to give a new value until you get a value that is larger than 0. */
  public GuestManager(int maxNbrOfGuests){
      System.out.println("Called constructor for GuestManager ");
   // System.out.println("Enter value for maximum number of guests!"); //maxNbrOfGuests= input.nextInt();
    if (maxNbrOfGuests >= 1){ //om user matade in nått under 1 ska det inte funka och gå till else
        guestList = new Guest[maxNbrOfGuests];
        nbrOfGuests=0; }
    else{
        for(int i=0; maxNbrOfGuests<=0; i++) {
             guestList = new Guest[maxNbrOfGuests];
              System.out.println("Enter a value larger than 0 ");
              Scanner input = new Scanner(System.in);
                   maxNbrOfGuests = input.nextInt();
            nbrOfGuests=0; }         }       }

    /*public GuestManager(int nbrOfGuests, Guest[] guestList){
         this.nbrOfGuests= nbrOfGuests;
         this.guestList=guestList;      }*/

    /* A method that returns the number of guests stored in
         the guest list.
       */
  public int getNbrOfGuests() {
      return nbrOfGuests;
  }


  /* Create a method to add a guest to the list with all the parameters
     matching instance variables of Guest and Address.
     In the method create a new Guest-object and let classes Guest and Address
     take care of issues with values of the parameters.
     Add the new Guest-object to the array at the first empty element (here is where you
     use the instance variable for number of guests stored in the list). If there are no
     more empty elements call a private method in GuestManager to increase the size
     of the array ana then add the new Guest-object. Do not forget to update the value
     of the instance variable for number of guests in the list.
   */
    //.equals("")

    public boolean addGuest(String firstName, String familyName, String street, String city, String zipCode, Countries countries) {
        Address address = new Address(street, city, zipCode, countries);
        Guest guest = new Guest(firstName, familyName, address);

      boolean added = false;

            if(nbrOfGuests < guestList.length) { // check if reached the last element in the array if not create object in the array,, else increase place in the memory.
                guestList[nbrOfGuests]= guest;
                nbrOfGuests++;
                added= true;
            return added;}
            else{
                increaseGuestList();
                guestList[nbrOfGuests]= guest;
                nbrOfGuests++;          }
        added= true;
        return added;
        }
  /* Create method to delete a guest by giving the index in the array
     for the object (guest) to delete as a parameter to the method.
     This method should call the private method moveElementsToleft to remove
     the empty element in between other objects (may not be necessary
     if the guest removed was the last guest in the list).
     Remember to update the value of the instance variable for
     number of guests in the list.
   */
public boolean deletingAGuest(int index) {
    boolean success = true;
    //for (int i = 0; i < guestList.length; i++) {
        if ((index >= 0) && (index <= nbrOfGuests)) {
            guestList[index] = null;
            moveElementsToLeft(index);
            nbrOfGuests--;
        } else {     success = false;
        }
    return success;    }          // }

    /*den eller den andra sättet för att remova en objekt.. för att man behöver inte komma till sista objektet för att radera den?
    som det står nedan .. det är inte i slutet av ARRAYen och det betyder att man behöver inte komma till slutet av arrayen i
    for loop ... moveelementsmetoden tar hand om det. */


  private void moveElementsToLeft(int index){
        /* Add code to remove empty element places that is not att the end of the array.
        Start at the parameter index that is the empty element whose gap we want to fill.  */
     for( index = 0 ;  guestList == null; index++) { //i står för indexet
         guestList[index] = guestList[nbrOfGuests +1];  }      }

  private void increaseGuestList(){
    /* Write code that creates a new array of Guest-objects
       that is 10 elements larger that the current array instance variable .

       Copy the current array to the larger array and after that is done
       point the instance variable to the new array.

       Do not take a shot cut by using class Array from the Java-library.
     */
    //  Guest[] guestObject;
     Guest increaseGuestList []= new Guest[guestList.length+20];
     //guestList[nbrOfGuests]=increaseGuestList[20];
      for (int i= 0; i<guestList.length;i++){
          increaseGuestList[i]=guestList[i];
      }
      guestList=increaseGuestList;
      //nbrOfGuests++;
  }

  /* A method that returns the Guest-object at the given
     index n the parameter.
   */
  public Guest getGuestAt(int index){
    /* Add code to check that the parameter index
       has a value within the range of the array.
       If index is not in valid range return null.
       Yes, some checks are done in the Controller-object
       in this program but we do not want this class to depend
       on other classes for this, so sometimes we write redundant
       error handling in different ways to have more robust classes or code.
     */if(index<=guestList.length){
          return guestList[index];}
      else{
          return null;
      }
  }


  public String[] getInfoStrings() {
      //String arrayINFO[]={"firstName","familyName", "countries", "street", "city", "zipCode", "Address"};
    /* Write code that returns an array of strings where each element
       represents information about one guest in the list by calling every
       Guest-object's toString method.
       (no strings should be created for empty places at the end of the array st)
    */
      String[] infoStrings = new String[nbrOfGuests];  /*The number of elements in the array should be equal to the
      number of guests currently stored in the list.*/
for(int i=0; i< infoStrings.length; i++){    //for loop går varje element!=null för antalet gäster och sedan skriva ut på String array

    if(guestList[i] !=null){
       String newArray=guestList[i].toString();
       infoStrings[i]=newArray;
   }

} return infoStrings;
  }

}
