// Student: YARA RAJJOUB
// Program: SYSTEMUTVECKLARE ÅK 1

package partyModel;

public class Address {
    /* Declare instance variables for street, city, zip code as String-objects
       and country by using the enum Countries
     */
    private String street;
    private String city;
    private String zipCode;
    private Countries countries;

    /* Write a default constructor that gives default values for instance variables.
       Set default values for instance variables by calling the other constructor
       below using the this reserved word and:
       - Alternative 1: with arguments that are default values
         of your choice that will inform a user that this value isn't really set.
       - Alternative 2: Use null for all values and call the constructor below and handle that there.
     */
    public Address() { //اسندنا قيمه لها ونطبعهم عن طريق التو سترينغ
        this.street = "street";
        this.city = "city";
        this.zipCode = "zip code";
        countries = Countries.Unknown;
    }

    /* Write a constructor with parameters for all instance variables
       given above. Set instance variables to values from parameters.

       Check that the values for the parameters street, zipCode and city
       isn't empty Strings or null before assigning the values to the
       corresponding instance variables.
       If any value is empty or null assign a default value of your choice
       that will inform a user that this value isn't really set.
       If the parameter country is null set this to Countries.Unknown
       String street, String city, String zipCode, Countries co
     */
    public Address(String street, String city, String zipCode, Countries countries) {  //default constructor
        if (street == null || street.equals("")) {
            this.street = "street";
        } else {
            this.street = street;
        }
        if (city == null || city.equals("")) {
            this.city = "city";
        } else {
            this.city = city;
        }

        if (zipCode == null || zipCode.equals("")) {
            this.zipCode = "Zip code";
        } else {
            this.zipCode = zipCode;
        }

        if (countries == null) {
            this.countries = Countries.Unknown;
        } else {
            this.countries = countries;
        }

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if ((street != null && !street.isEmpty()))
            this.street = street;
        else {
            this.street = "street";
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if ((city != null && !city.isEmpty()))
            this.city = city;
        else {
            this.city = "city";
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if ((zipCode != null && !zipCode.isEmpty()))
            this.zipCode = zipCode;
        else {
            this.zipCode = "Zip code";
        }
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {

        this.countries = countries;


    }// to string så att den skriva ut datan angående gästens adress.

    public String toString() {
        String textOut = String.format("%s, %s, %s, %s", street, city, zipCode, countries.toString());
        return textOut;
    }
}
  /* Implement get- and set-methods for all instance variables.
     Remember to check parameters in set-methods with the same
     rules as in the constructor above.
   */

  /* Write a toString method to return a String-object made of the address details,
     formatted as one line.
   */


