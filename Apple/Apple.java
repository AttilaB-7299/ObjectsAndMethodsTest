package Apple;
public class Apple {
  int size;
  static double damage;

  public static Apple m_apple = new Apple(10);

  damage = Apple.getInstance().getSize() * .25;
  public Apple(int size){
    this.size = size;
  }
  public double override(double newDamage){
    Apple.getInstance().setDamage(newDamage);
    return damage;
  }
  private double setDamage(double setDamage){
    damage = setDamage;
    return damage;
  }
  public static Apple getInstance(){
    if (m_apple == null){
      // m_apple = new Apple(0);
      System.out.println("APPLE IS NULL");
    }
    return m_apple;
  }
  public int getSize(){
    return m_apple.size;
  }
  public double getDamage(){
    return damage;
  }
}
