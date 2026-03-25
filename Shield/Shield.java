package Shield;
import Apple.Apple;
public class Shield {
  static boolean isBlocking = false;
  static Shield shield = new Shield();
  public Shield(){}

  public static void block(){
    isBlocking = true;
    Apple.getInstance().override(0);
  }
  public boolean isBlocking(){
    return isBlocking;
  }
  public static Shield getInstance(){
    if (shield == null){
      shield = new Shield();
    }
    return shield;
  }
}
