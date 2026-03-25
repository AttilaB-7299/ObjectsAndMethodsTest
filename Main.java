import Apple.Apple;
import Human.Human;
import Shield.Shield;
public class Main {
  Human human = new Human();
  public static void main(String[] args){
    Shield.block();
    System.out.println(Human.getInstance().throwApple(Apple.getInstance()));
  }
}
