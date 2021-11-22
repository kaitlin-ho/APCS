public class Monster{
  public Monster() {}

  public boolean isAlive(){
    int hp = 0;
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

  public int attack(Protagonist targert){
    return atk;
  }

}
