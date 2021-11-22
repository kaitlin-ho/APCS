public class test{

public static void main(String args[]){
	String s1 = "foo";
	String s2 = "foo";
	String s3 = new String("foo");

	System.out.println( s1 ); //foo
	System.out.println( s2 ); //foo
	System.out.println( s3 ); //foo
	System.out.println( s1 == s2 ); //true; optimization that java does for you
		//not typical behavior.
	System.out.println( s1 == s3 ); //false
	System.out.println( s1.equals(s2) ); //true
	System.out.println( s1.equals(s3) ); //true

}

}
