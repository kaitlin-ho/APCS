/*
NIWWD: Kevin Xiao + Mr. Swag, Jeffery Tang + Mathias, Kaitlin Ho + Apple
In collaboration with team UnicornHead
APCS
HW29 -- Which Way Do You Roll?
2021-11-01
time spent: 2.0 hours
*/

/*
DISCO:
0. In commafyR, when it invokes itself, it follows flow of execution. 
	Ex: commafyR(100 000 000) *Spaces added for visual clarity (pretend they aren't
		there)
	commafyR(100 000 000)
	commafyR(100 000) + "," + "000"
	commafy(100) + "," + "000" + "," + "000"
	100 + "," + "000" + "," + "000"
	100,000,000
	NOT...
	commafyR(100 000 000)
	commafyR(commafyR(100) + "," + "000") + "," + "000"
	Basically, just be careful how you keep track of what has been returned/invoked
	and what has yet to be invoked.
1. In the command line, typing...
	java Class input1 input2 input3 ...etc
   will invoke the main() method with a String array containing these inputs.
QCC:
None
*/

public class Commafier{

	public static String commafyF(int num) {
		String s = "" + num;
		int limit = (s.length() - 1)/3; //so that the limit doesn't change w/ every iteration
		for (int i = 1; i <= limit; i = i + 1) {
			s = s.substring(0, s.length() - 3*i - (i - 1)) + "," +
			s.substring(s.length() - 3*i - (i - 1));
			//subtracting (i-1) resolves the issue with adding a comma and
			// consequently incrementing the length of the string by 1.
			//3i: for the ith iteration, put a comma i groups of 3 before
			// the end of the string (with the previous commas accounted
			// for as previously described)
		}
		return s;
	}

	public static String commafyR(int num) {
		String s = "" + num;
		if (s.length() <= 3) {
			return s;
		}
		else {
			return commafyR(Integer.parseInt(s.substring(0, s.length()-3)))
			+ "," + s.substring(s.length() - 3);
		}
	}

	public static void main(String[] args) {
		for (String arg: args) {
			//Command line: java Commafier input1 input2 input3 ...
			//The main method will create an array of these inputs, where
			// their type is String. So, before we invoke commafy_ with
			// them, we convert them to ints.
			System.out.println(commafyF(Integer.parseInt(arg)));
			System.out.println(commafyR(Integer.parseInt(arg)));
		}
/*
		System.out.println(commafyF(1));
		System.out.println(commafyF(10));
		System.out.println(commafyF(101));
		System.out.println(commafyF(1000));
		System.out.println(commafyF(12345));
		System.out.println(commafyF(100000000));
                System.out.println(commafyR(1));
                System.out.println(commafyR(10));
                System.out.println(commafyR(101));
                System.out.println(commafyR(1000));
                System.out.println(commafyR(12345));
		System.out.println(commafyR(100000000));
*/
	}

}
