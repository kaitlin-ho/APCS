/**
   NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple
   APCS
   HW21 -- STAtisTically Speaking...
   2021-10-21
   
   DISCO: Math.round() exists. It converts a double to a long.
   We can then convert said long into an int by adding Math.toIntExact()
   
   QCC:
   How to implement a Math.round with our own code instead of importing java math?
   
 **/

public class Stats {

  public static int mean(int a, int b) {
  	return (a + b)/2;
  }

  public static double mean(double a, double b) {
  	return (a + b)/2.0;

  }

  public static int max(int a, int b) {
  	if (a > b){
  		return a;
  	} else {
  		return b;
  	}
  }

  public static double max(double a, double b) {
   	if (a > b){
  		return a;
  	} else {
  		return b;
  	}

  }

  public static int geoMean(int a, int b) {
	int hello = Math.toIntExact(Math.round(Math.sqrt(a * b)));
 	return hello;
  }

  public static double geoMean(double a, double b) {
	double product = (a * b);
  	return Math.sqrt(product);
  }

  public static int max(int a, int b, int c) {
	if (a > b && a > c){
  		return a;
  	} else if(b > c){
  		return b;
  	} else {
  		return c;
	}
  }

  public static double max(double a, double b, double c) {
	if (a > b && a > c){
  		return a;
  	} else if(b > c){
  		return b;
  	} else {
  		return c;
  	}

  }

  public static int geoMean(int a, int b, int c) {
	int hello = Math.toIntExact(Math.round(Math.cbrt(a * b * c)));
 	return hello;
  }

  public static double geoMean(double a, double b, double c) {
	double product = (a * b * c);
	return Math.cbrt(product);

  }


  //main method for testing functionality
  public static void main( String[] args ) {

  }

}//end class
