public class Greet {
	public static void main(String[] args) {
		greet("Apple");
		greet("Pear");
		greet("Durian");
}
	public static void greet(String n){
		String s = "Why, hello, there, " + n + ". How do you do?";
		System.out.println(s);
	}
}
