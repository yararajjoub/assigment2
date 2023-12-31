// Student: YARA RAJJOUB
// Program: SYSTEMUTVECKLARE ÅK 1

package partyModel;
public class Guest {
    /* Declare instance variables for first name and family name as String-objects and
       address as an Address-object.
     */
private String firstName;
private String familyName;
private Address address; /* Write a default constructor (no parameters) that gives default values for  instance variables and creates the Address-object using the default constructor for class Address. Use default values for first name and family name of your choice that will inform a user that this value isn't really set.
 You can handle this in this constructor or call the constructor below with null for all values and handle that there.*/
    public Guest(){
        firstName="First name ";
       familyName="Family name ";
        this.address= new Address();
    }

    public Guest(String firstName, String familyName, Address address) {
        if (firstName == null || firstName.equals("")) {
            this.firstName = "First Name";
        }
        else {
            this.firstName = firstName;
        }

        if (familyName == null || familyName.equals("")) {
            this.familyName = "Family Name";
        }
        else {
            this.familyName = familyName;
        }

        if (address == null) {
            this.address = new Address();
        }
        else {
            this.address = address;
        }
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if ((firstName != null) && (!firstName.equals(""))) {
            this.firstName = firstName;
        }
        else {
            this.firstName = "First name";
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        if ((firstName != null) && (!familyName.equals(""))) {
            this.familyName = familyName;
        }
        else {
            this.familyName = "Family name";
        }

    }


    public Address getAddress () {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public  String toString() {
        return   firstName+  ", "+ familyName + "      " + address.toString();

    }
}
 /* Write a constructor with parameters for all instance variables
       given above where the address is a reference to an Address-object
       and first name and family name are of type String.

       Check that the values for the parameters for first name and family name
       isn't empty Strings or null before assigning the values to the corresponding
       instance variables. If any value is empty or null assign a default value of your choice
       that will inform a user that this value isn't really set.

       If the parameter for the Address-object is null create an Address-object
       by using the default constructor for class Address.
     */

    /* Write a constructor with parameters for all instance variables
       given above and all instance variables for the address.
       Create the Address-object with the values given in the parameters.
       Let the Address class take care of assigning default values if any
       parameters for this object is an empty String or null.
   */

    /* Implement get- and set-methods for all instance variables,
       including variables matching the instance variables of
       the Address-object (those call getters and setters in the Address-object).

       Remember to check parameters in set-methods with the same
       rules as in the constructor above.
     */

    /* Write a toString method to return a String made of first name and
       family name and the address (by calling the toString method of the Address-object)
       formated in one line.
     */
