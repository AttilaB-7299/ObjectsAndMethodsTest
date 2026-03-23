package Apple;
public class Apple {
  int size = 0;
  private static Apple m_Apple = new Apple(10);
  static double damage = Apple.getInstance().getSize() * .25;

  public static Apple getInstance(){
    if (m_Apple == null){
      System.out.println("APPLE IS NULL");
    }
    return m_Apple;
  }

  public Apple(int size){
    this.size = size;
  }

  public void overrideDamage(int artificialDamage){
    damage = artificialDamage;
  }

  public static double getDamage(){
    return damage;
  }

  public int getSize(){
    return size;
  }

  public void setSize(int newSize){
    size = newSize;
  }

}
