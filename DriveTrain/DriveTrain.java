package DriveTrain;
import Motor.DriveMotor;
import Motor.DriveMotor.DriveMotorStates;

import java.util.Scanner;
public class DriveTrain {
  DriveMotor BackLeft;
  DriveMotor BackRight;
  DriveMotor FrontRight;
  DriveMotor FrontLeft;
  // DriveMotor FrontLeft = new DriveMotor(2, "Kraken");
  // DriveMotor FrontRight = new DriveMotor(3, "Kraken");
  // DriveMotor BackLeft = new DriveMotor(4, "Kraken");
  // DriveMotor BackRight = new DriveMotor(5, "Kraken");
  DriveTrainStates state, desiredState;
  private DriveTrain Instance;

  // private DriveTrain() {}
  public void Drive(){
    Instance.setState(DriveTrainStates.DRIVE);
    while (state == DriveTrainStates.DRIVE) {
      System.out.println("Driving");
    }
  }
  public void open(){
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next().toLowerCase();
    switch (input){
      case "a":
        Instance.Drive();
      case "b":
        Instance.setState(DriveTrainStates.IDLE);
    }


    scanner.close();
  }
  public DriveTrain(/*DriveMotor BackLeft, DriveMotor BackRight, DriveMotor FrontRight, DriveMotor FrontLeft*/){
    FrontLeft = new DriveMotor(2, "Kraken");
    FrontRight = new DriveMotor(3, "Kraken");
    BackLeft = new DriveMotor(4, "Kraken");
    BackRight = new DriveMotor(5, "Kraken");
    // this.BackLeft = BackLeft;
    // this.BackRight = BackRight;
    // this.FrontLeft = FrontLeft;
    // this.FrontRight = FrontRight;
  }
  public DriveTrain getInstance(){
    if (Instance == null){
      System.out.println("DRIVETRAIN IS NULL SOEMTHING WENT WRONG");
      // Instance = new DriveTrain();
    }
    return Instance;
  }
  public DriveTrainStates setState(DriveTrainStates desiredState){
    switch (desiredState) {
      case DRIVE:
        BackLeft.setState(DriveMotorStates.DRIVE);
        BackRight.setState(DriveMotorStates.DRIVE);
        FrontLeft.setState(DriveMotorStates.DRIVE);
        FrontRight.setState(DriveMotorStates.DRIVE);
        break;
      case BROKEN:
        BackLeft.setState(DriveMotorStates.BROKEN);
        BackRight.setState(DriveMotorStates.BROKEN);
        FrontLeft.setState(DriveMotorStates.BROKEN);
        FrontRight.setState(DriveMotorStates.BROKEN);
      case LOCKED:
        BackLeft.setState(DriveMotorStates.LOCKED);
        BackRight.setState(DriveMotorStates.LOCKED);
        FrontLeft.setState(DriveMotorStates.LOCKED);
        FrontRight.setState(DriveMotorStates.LOCKED);
      case SHOOTING:
        BackLeft.setState(DriveMotorStates.DRIVE);
        BackRight.setState(DriveMotorStates.DRIVE);
        FrontLeft.setState(DriveMotorStates.DRIVE);
        FrontRight.setState(DriveMotorStates.DRIVE);
      case IDLE:
        BackLeft.setState(DriveMotorStates.IDLE);
        BackRight.setState(DriveMotorStates.IDLE);
        FrontLeft.setState(DriveMotorStates.IDLE);
        FrontRight.setState(DriveMotorStates.IDLE);
        break;
    }
    if (state != desiredState) {
      state = desiredState;
    }
    return state;
  }
  public DriveTrainStates getState(){
    return state;
  }
  public enum DriveTrainStates {
    DRIVE,
    BROKEN,
    LOCKED,
    SHOOTING,
    IDLE
  }

}
