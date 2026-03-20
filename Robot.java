import DriveTrain.DriveTrain;
import Motor.DriveMotor;

public class Robot {
  DriveTrain driveTrain = new DriveTrain();

  public void main (String[] args){
    Drive(2, 6);
  }
  public void Drive(double ySpeed, double xSpeed){
    driveTrain.getInstance().open();
  }





}
