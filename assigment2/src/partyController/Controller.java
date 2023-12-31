// Student: YARA RAJJOUB
// Program: SYSTEMUTVECKLARE ÅK 1

package partyController;

import partyModel.Address;
import partyModel.Countries;
import partyModel.Guest;
import partyModel.GuestManager;
import partyView.ButtonType;
import partyView.MainFrame;

import javax.swing.*;

public class Controller {
    MainFrame view; // the main association to the GUI from the controller-class, GUI classes are in package partyView
    GuestManager register;  //class GuestManager is in package partyModel

    //constructor called from MainProgram
    public Controller(int maxNbrOfGuests) {
        //Creates a GuestManager-object referenced by the instance variable register
        register = new GuestManager(maxNbrOfGuests);

        // Create main GUI-object referenced by the instance variable view
        view = new MainFrame(this); // give the GUI a reference to the Controller-object by using this to send a reference to the Controller-object

        //Update the GUI with information from the guest list (even if it might be empty)
        view.updateGuestList(register.getInfoStrings());

        //Set some values in the fields to the left in the GUI
        setDefaultValuesInView();
    }

    public void buttonPressed(ButtonType button){
        int index; //variable used in two switch cases below
        switch (button) {
            case Add:

                System.out.println("First name: "+view.getFirstNameText());
                System.out.println("Family name: "+view.getLastNameText());
                System.out.println("Street: "+view.getStreetText());
                System.out.println("Zip code: "+view.getZipCodeText());
                System.out.println("City: "+view.getCityText());

                Object item = view.getCountriesItem(); //get the item chosen in the drop-down list of countries, the program handles this as just an Object-object
                Countries country = (Countries) item; //make it a Countries object - we know that this is supposed to be that, this type of type conversion can be risky
                System.out.println("Country: "+country.toString());
                // Example code end here


                register.addGuest(view.getFirstNameText(),view.getLastNameText(),view.getZipCodeText(),view.getStreetText(),view.getCityText(),country);
                break;

            case Change:
                JOptionPane.showMessageDialog(null, "Pressed Change"); //remove this line later when you understand how the code works

                index = view.getListIndex(); //get the chosen index from the list of guest information from the GUI
               // System.out.println("Want to change guest at index: "+index); //Can be removed later
                if (validateIndex(index)) { //validateIndex is a private method in this class
                    Guest guestToChange = register.getGuestAt(index); //get what is hopefully the matching Guest-object to the one chosen one in the GUI
                    if (guestToChange != null){

                        guestToChange.setFirstName(view.getFirstNameText());
                        guestToChange.setFamilyName(view.getLastNameText());
                        Address address = guestToChange.getAddress();
                        address.setStreet(view.getStreetText());
                        address.setCity(view.getCityText());
                        address.setZipCode(view.getZipCodeText());

                        Object items= view.getCountriesItem();
                        Countries countries1 = (Countries) items;
                        address.setCountries(countries1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Did not find match in list to change");
                    }
                }
                break;

            case Delete:
          JOptionPane.showMessageDialog(null, "Pressed Delete"); //remove this line later when you understand how the code works
                index = view.getListIndex();
                System.out.println("When pressed delete we got index: "+index); //Can be removed later
                if (validateIndex(index)) {
                    /*
                     ADD CODE HERE that calls the method to delete an item for the GuestManager-object register
                    */
                    register.deletingAGuest(index);

                }
                break;
        }

        /* Update information i GUI after changes.
           These are not precision changes - everything is updated,
           even if it might not be needed.

           It is important to keep the list in GuestManager with information about Guests
           matched with what is shown in the GUI. Otherwise, it will not match when we want
           to change or delete a guest from the list.
         */
        int attendance = register.getNbrOfGuests();
        view.setNumGuest(Integer.toString(attendance));
        view.updateGuestList(register.getInfoStrings());
    }

    /* This method is called when something is changed,
       such as when the user chooses a guest in the list
       to the right in the GUI-window.
       It should update the fields to the left in the GUI-window
       with information from the selected guest.
     */
    private void updateView(int index) {
        System.out.println("Called updateView in controller with index:"+index); //Can be removed later
        if(validateIndex(index)) {
          //  Guest guest = new Guest(); //Remove later when line below is used
            Guest guest = register.getGuestAt(index); //ADD CODE HERE by activating this line to see what happens with a null-object and later when method getGuestAt is implemented in class GuestManager
            Address address = guest.getAddress();
            if (guest == null) {
                JOptionPane.showMessageDialog(null, "The selection did not match a guest");
                System.out.println("Given index: "+index+ " did not contain a Guest-object");
                setDefaultValuesInView();
            } else {
                /*ADD CODE HERE to set info in GUI.
                  Replace the strings below with a method call to the Guest-object
                  referenced by variable guest that returns the value of
                  the instance variable containing the first name.
                 */
                view.setFirstNameText("Fake first name");

                //ADD CODE HERE to do the equivalent for the rest of the information about a guest
                view.setLastNameText("Fake family name");
                view.setStreetText("Fake street");
                view.setZipCodeText("Fake zip code");
                view.setCityText("Fake city");
                view.setCountriesItem(Countries.Sverige);
            }
        }
    }

    /* Method used to create the drop down menu of counrtries
       in the GUI.
     */
    public Countries [] getCountriesItems() {
        return Countries.values ();
    }

    /* This method is called from the GUI when the user changes selection in the
       list to the right in the GUI. It updates the information to the left in the GUI
       to match the selected guest.
     */
    public void guestListIndexChanged(int index) {
        if(validateIndex(index)) {
            updateView(index);
        }
    }

    /* This method is used to check that we have gotten an index
       that is not a negative value from the GUI.
       If no row is chosen in the view to the right in the GUI
       we will get the value -1 and then we show an error message for the user.
     */
    private boolean validateIndex(int index) {
        boolean ok = true;
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Select an item in the list!");
            ok = false;
        }
        return ok;
    }

    /* This method is used to set some default values in the
       fields to the left in the GUI.
     */
    private void setDefaultValuesInView(){
        view.setFirstNameText("First name");
        view.setLastNameText("Family name");
        view.setStreetText("Street");
        view.setZipCodeText("zip code");
        view.setCityText("City");
        view.setCountriesItem(Countries.Unknown);
    }

}
