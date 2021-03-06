// Team Four {Fang, Kaitlin, Jing}
// APCS PD06
// HW49 -- Rational Standards Compliance
// 2021-12-22
// time spent: 1

/*
DISCO:
- Typecast was needed even after checking if Object was a Rational because even if the boolean returned was TRUE, java still sees the class as object and not rational. 
	We can typecast without fear because the typecast will only run if Object is an instance of class Rational

QCC:
- Why can't compareTo be modified and used instead of using the equals method?

*/

public class Rational implements Comparable{

	private int p;
	private int q;

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

	public double floatValue() {
		return (1.0 * p)/q;
	}

	public void multiply(Rational a) {
		p = this.p * a.p;
		q = this.q * a.q;
	}

	public void divide(Rational a) {
		p = this.p * a.q;
		q = this.q * a.p;
	}

	public void reduce(){
		int greatestCom = this.gcd();
		p = p / greatestCom;
		q = q / greatestCom;
	}

	// HW 42 Modifications

	public static int gcd(int a, int b){
		int gcd = 1;
		    for (int i = 1; i <= Math.min(a, b); i++) {
		        if ((a % i == 0) & (b % i == 0)) {
		            gcd = i;
		        }
		    }
		return gcd;
	}

	public int gcd() {
		return gcd(p, q);
	}

	public static int lcm(int a, int b){
		int result;
		result = a * (b / gcd(a, b));
		return result;
	}

	public void add(Rational a){
		int leastCom = lcm(this.q, a.q);
		p = (leastCom/q)*this.p + (leastCom/a.q)*a.p;
		q = leastCom;
		this.reduce();
	}

	public void subtract(Rational a){
		int leastCom = lcm(this.q, a.q);
		p = ((leastCom / this.q) * this.p) - ((leastCom / a.q) * a.p);
		q = leastCom;
		this.reduce();
	}

	// public int compareTo(Rational a){
	// 	a.reduce();
	// 	this.reduce();
	// 	this.subtract(a);
	// 	return this.p;
	// }

	// HW 49 Modifications

	public int compareTo(Object a) {
		((Rational) a).reduce();
		((Rational) this).reduce();
		((Rational) this).subtract((Rational) a);
		return ((Rational) this).p;
	}
