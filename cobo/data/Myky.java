import java.util.*;
// Which country is the most generous and in what year?
public class Myky {

  private String _country;
  private int _year;
  private double _lifeLadder;
  private double _logGDP;
  private double _socialSupport;
  private double _lifeExpectancy;
  private double _freedom;
  private double _generosity;
  private double _perceptions;
  private double _positiveAff;
  private double _negativeAff;

  public Myky(String c, int y, double ll, double lGDP, double ss, double le, double f, double g, double p, double pa, double na) {
    _country = c;
    _year = y;
    _lifeLadder = ll;
    _logGDP = lGDP;
    _socialSupport = ss;
    _lifeExpectancy = le;
    _freedom = f;
    _generosity = g;
    _perceptions = p;
    _positiveAff = pa;
    _negativeAff = na;
  }

  public double generosity() {
    return _generosity;
  }

  public String toString() {
    String retStr = _country + ", " + _year;
    return retStr;
  }

  public static void main(String[] args) {
    ArrayList<Myky> csv = new ArrayList<Myky>();
    Scanner sc = new Scanner(System.in);
    Myky temp = new Myky("", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    sc.nextLine();
    while ( sc.hasNext() ) {
      String myk = sc.nextLine();
      String[] instVars = myk.split(",");
      String c;
      int y;
      double ll, lGDP, ss, le, f, g, p, pa, na;
      if (!(instVars[0].equals(""))) {
        c = instVars[0];
      }
      else{ c = ""; }
      if (!(instVars[1].equals(""))) {
        y = Integer.parseInt(instVars[1]);
      }
      else{ y = 0; }
      if (!(instVars[2].equals(""))) {
        ll = Double.parseDouble(instVars[2]);
      }
      else{ ll = 0.0; }
      if (!(instVars[3].equals(""))) {
        lGDP = Double.parseDouble(instVars[3]);
      }
      else{ lGDP = 0.0; }
      if (!(instVars[4].equals(""))) {
        ss = Double.parseDouble(instVars[4]);
      }
      else{ ss = 0.0; }
      if (!(instVars[5].equals(""))) {
        le = Double.parseDouble(instVars[5]);
      }
      else{ le = 0.0; }
      if (!(instVars[6].equals(""))) {
        f = Double.parseDouble(instVars[6]);
      }
      else{ f = 0.0; }
      if (!(instVars[7].equals(""))) {
        g = Double.parseDouble(instVars[7]);
      }
      else{ g = 0.0; }
      if (!(instVars[8].equals(""))) {
        p = Double.parseDouble(instVars[8]);
      }
      else{ p = 0.0; }
      if (!(instVars[9].equals(""))) {
        pa = Double.parseDouble(instVars[9]);
      }
      else{ pa = 0.0; }
      if (!(instVars[10].equals(""))) {
        na = Double.parseDouble(instVars[10]);
      }
      else{ na = 0.0; }
      Myky myky = new Myky(c, y, ll, lGDP, ss, le, f, g , p, pa, na);
      if (myky.generosity()>temp.generosity()) { temp = myky; }
    }
    System.out.println(temp);
  }
}
