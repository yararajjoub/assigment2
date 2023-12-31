// Student: YARA RAJJOUB
// Program: SYSTEMUTVECKLARE ÅK 1
package partyController;

import java.util.Scanner;

public class MainProgram
{
    public static void main(String[] args)
    {
        int maxNbrOfGuests = 0; // Change thi line later. Only using 10 as a default value to make compilations possible.
        /* Write code to read max number of guests from the user by using one of
         */
        System.out.println("Please enter maximum number of guests: ");
        Scanner scanner = new Scanner(System.in);
        maxNbrOfGuests= scanner.nextInt();


        Controller controller = new Controller(maxNbrOfGuests);


    }


}