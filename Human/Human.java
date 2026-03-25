package Human;
import Apple.Apple;
import Shield.Shield;
public class Human {
  public Human(){}
  Apple apple = new Apple(10);
  static Human human = new Human();
  public double throwApple(Apple apple){
    if (Shield.getInstance().isBlocking()){
      return 0;
    } else {
      return Apple.getInstance().getDamage();
    }
  }
  public static Human getInstance(){
    if (human == null){
      System.out.println("HUMAN IS NULL");
    }
    return human;
  }




}
