public class Driver{
  
public static void main(String[] args) {
		Rational r = new Rational(2,3);
		Rational t = new Rational(4,6);
		Rational s = new Rational(1,2);
		Object notRat = new Object();

		System.out.println(r.equals(r)); // should be true
		System.out.println(r.equals(t)); // should be true
		System.out.println(r.equals(s)); // should be false
		System.out.println(r.equals(notRat)); // should be false


	}
}
