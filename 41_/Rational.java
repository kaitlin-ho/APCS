public class Rational{

  public int q;
  public int p;

  public Rational(){
    p = 0;
    q = 1;
  }

  public Rational(int a, int b){
    this();
    p = a;
    q = b;
  }

  public float floatValue(){
    return (float)p/q;
  }

  public String toString(){
    return (p + "/" + q);
  }

  public void multiply(Rational b){
    p = p*b.p;
    q = q*b.q;
  }

  public static void main(String[] args){
    Rational a = new Rational(3,4);
    Rational b = new Rational(1,2);
    System.out.println(a.toString);
    a.multiply(b);
    System.out.println(a.toString);
  }

}
