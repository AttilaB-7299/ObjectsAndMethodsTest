import Apple.Apple;
public class Human {
  private static Human human = new Human();
  public Human(){}
  public static Human getInstance(){
    if (human == null){
      Human human = new Human();
    }
    return human;
  }


  public double throwApple(){
    System.out.println(Apple.getDamage());
    return Apple.getDamage();
  }

}
