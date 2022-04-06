/*
The Greyducks :: Kaitlin Ho, Hugo Jenkins, Ariella Katz, Apple, Boary, Tom
APCS
LAB08 -- America's Next Top Data Scientist
2022-04-05
time spent: 3.0 hrs
*/

public class Cereal {

  private String _name;
  private String _type;
  private int _cals;
  private int _protein;
  private int _fat;
  private int _sodium;
  private double _fiber;
  private double _carbs;
  private int _sugar;
  private int _potass;
  private int _vitamins;
  private int _shelf;
  private double _weight;
  private double _cups;
  private double _rating;

  public Cereal(String name, String type, int cals, int protein, int fat,
  int sodium, double fiber, double carbs, int sugar, int potass, int vitamins,
  int shelf, double weight, double cups, double rating) {
    _name = name;
    _type = type;
    _cals = cals;
    _protein = protein;
    _fat = fat;
    _sodium = sodium;
    _fiber = fiber;
    _carbs = carbs;
    _sugar = sugar;
    _potass = potass;
    _vitamins = vitamins;
    _shelf = shelf;
    _weight = weight;
    _cups = cups;
    _rating = rating;
  }

  //ACCESSORS BELOW
  public String name() {
    return _name;
  }
  public String type() {
    return _type;
  }
  public int calories() {
    return _cals;
  }
  public int protein() {
    return _protein;
  }
  public int fat() {
    return _fat;
  }
  public int sodium() {
    return _sodium;
  }
  public double fiber() {
    return _fiber;
  }
  public double carbohydrates() {
    return _carbs;
  }
  public int sugar() {
    return _sugar;
  }
  public int potassium() {
    return _potass;
  }
  public int vitamins() {
    return _vitamins;
  }
  public int shelf() {
    return _shelf;
  }
  public double weight() {
    return _weight;
  }
  public double cups() {
    return _cups;
  }
  public double rating() {
    return _rating;
  }
  //ACCESSORS ABOVE

  public String toString() {
    String retStr = "";
    retStr += "Name: " + _name + "\n";
    retStr += "Type: " + _type + "\n";
    retStr += "Calories: " + _cals + "\n";
    retStr += "Protein: " + _protein + "\n";
    retStr += "Fat: " + _fat + "\n";
    retStr += "Sodium: " + _sodium + "\n";
    retStr += "Fiber: " + _fiber + "\n";
    retStr += "Carbohydrates: " + _carbs + "\n";
    retStr += "Sugar: " + _sugar + "\n";
    retStr += "Potassium: " + _potass + "\n";
    retStr += "Vitamins: " + _vitamins + "\n";
    retStr += "Shelf: " + _shelf + "\n";
    retStr += "Weight: " + _weight + "\n";
    retStr += "Cups: " + _cups + "\n";
    retStr += "Rating: " + _rating + "\n";
    return retStr;
  }

  public static void main(String[] args) {
    Cereal mykolyk = new Cereal("mykolyk", "H", 1000, 21, 10, 1000000, 0.0,
    30.0, 6, -10, 0, 2, 1.33, 0.66, 63.689274);
    System.out.println(mykolyk);

    Cereal shmexy = new Cereal("shmexy", "H", 69, 6, 6, 69696969, 6.9, 6.9, 9,
    6060, 69, 6, 9, 0.69, 69.696969);
    System.out.println(shmexy);
  }

}
