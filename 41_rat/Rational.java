
// Team Four {Fang, Kaitlin, Jing}
// APCS PD06
// HW41 -- Be Rational
// 2021-11-30

/*
DISCO
- By using instance variables p and q instead of storing the double value of the Rational in a single variable makes mathematical operations a lot neater and more precise.
QCC
- How can we make a function that simplifies the fraction present when using this class?
- Why would making multiply() and divide() void work better than having the functions return another Rational instance?
*/

public class Rational {

	public int p;
	public int q;

	public Rational() {
		p = 0;
		q = 1;
	}

	public Rational(int num, int den) {
		this();
		if (den != 0) {
			p = num;
			q = den;
		} else {
			System.out.println("Invalid denominator");
		}
	}

	public String toString() {
		return p + "/" + q;
	}

	public float floatValue() {
		return (float) (1.0 * p)/q;
	}

	public void multiply(Rational a) {
		p = this.p * a.p;
		q = this.q * a.q;
	}

	public void divide(Rational a) {
		p = this.p * a.q;
		q = this.q * a.p;
	}

	public static void main(String[] args) {
		Rational r = new Rational(2,3);
		Rational s = new Rational(1,2);

		// Print inital values of r and s
		System.out.println(r.toString()); // "2/3"
		System.out.println(s.toString()); // "1/2"
		System.out.println(r.floatValue()); // "0.6666667"
		System.out.println(s.floatValue()); // "0.5"

		// Multiply r with s
		r.multiply(s);
		// Print new value of r
		System.out.println(r.toString()); // "2/6"

		// Divide new r by s
		r.divide(s);
		// Print new value of r
		System.out.println(r.toString()); // "4/6"

		// Ensure s did not change
		System.out.println(s.toString()); // "1/2"


	}

}
