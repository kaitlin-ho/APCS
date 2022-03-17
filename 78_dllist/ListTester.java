/***
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 *  overriding List interface from standard Java library
 **/

public class ListTester
{
  public static void main( String[] args ) 
  {

    //instantiate... var type List, obj type LList
    List wu = new LList();

    System.out.println(wu);
    wu.add("RZA");

    System.out.println(wu);
    wu.add("GZA");

    System.out.println(wu);
    wu.add("ODB");

    System.out.println(wu);
    wu.add("Inspectah Deck");

    System.out.println(wu);
    wu.add("Raekwon the Chef");

    System.out.println(wu);
    wu.add("U-God");

    System.out.println(wu);
    wu.add("Ghostface");

    System.out.println(wu);
    wu.add("Method Man");

    System.out.println(wu);
    
    /** Expected from add()
     []
    [RZA]
    [GZA, RZA]
    [ODB, GZA, RZA]
    [Inspectah Deck, ODB, GZA, RZA]
    [Raekwon the Chef, Inspectah Deck, ODB, GZA, RZA]
    [U-God, Raekwon the Chef, Inspectah Deck, ODB, GZA, RZA]
    [Ghostface, U-God, Raekwon the Chef, Inspectah Deck, ODB, GZA, RZA]
    [Method Man, Ghostface, U-God, Raekwon the Chef, Inspectah Deck, ODB, GZA, RZA]
     */

    for( int i=0; i<7; i++ ) {
    int n = (int)( wu.size() * Math.random() );
    System.out.println("adding a poser at index " + n + "...");
    wu.add( n, "@" );
    System.out.println("Updated list: " + wu);
    }

    /* Expected from add at index
    adding a poser at index 5...
    Updated list: [Method Man, Ghostface, U-God, Raekwon the Chef, Inspectah Deck, @, ODB, GZA, RZA]
    adding a poser at index 6...
    Updated list: [Method Man, Ghostface, U-God, Raekwon the Chef, Inspectah Deck, @, @, ODB, GZA, RZA]
    adding a poser at index 3...
    Updated list: [Method Man, Ghostface, U-God, @, Raekwon the Chef, Inspectah Deck, @, @, ODB, GZA, RZA]
    adding a poser at index 4...
    Updated list: [Method Man, Ghostface, U-God, @, @, Raekwon the Chef, Inspectah Deck, @, @, ODB, GZA, RZA]
    adding a poser at index 8...
    Updated list: [Method Man, Ghostface, U-God, @, @, Raekwon the Chef, Inspectah Deck, @, @, @, ODB, GZA, RZA]
    adding a poser at index 6...
    Updated list: [Method Man, Ghostface, U-God, @, @, Raekwon the Chef, @, Inspectah Deck, @, @, @, ODB, GZA, RZA]
    adding a poser at index 10...
    Updated list: [Method Man, Ghostface, U-God, @, @, Raekwon the Chef, @, Inspectah Deck, @, @, @, @, ODB, GZA, RZA]
*/


    while( wu.size() > 0 ) {
    int n = (int)( wu.size() * Math.random() );
    System.out.println("deleting node "+ n + "...");
    wu.remove(n);
    System.out.println("Updated list: " + wu);
    }
     /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
