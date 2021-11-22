public class Protagonist{
  public Protagonist() {
  }

// delcare variables outside

  public Protagonist(String inName) {
    int atk = 0;
    int hp = 0;
    String name = inName;
  }

  public boolean isAlive() {
    if (hp > 0){
      return true;
    }
    else {return false;}
  }

  public void specialize() {
    atk = 5; // change later
  }

  public void normalize() {
    atk = 2 // change later
  }

  public int attack(Monster target) {
    return atk;
  }

  public String getName() {
    return name;
  }

}
