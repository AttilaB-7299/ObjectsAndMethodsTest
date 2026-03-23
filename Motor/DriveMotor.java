package Motor;

public class DriveMotor {

  private int motorID;
  private String motorType;
  private DriveMotorStates motorState;

  public DriveMotor(int motorID, String motorType) {
    this.motorID = motorID;
    this.motorType = motorType;
  }
  public DriveMotorStates setState(DriveMotorStates desiredState) {
    if (motorState != desiredState){
      motorState = desiredState;
    }
    return desiredState;
  }
  public int getID(){
    return motorID;
  }
  public String getType(){


    return motorType;
  }
  public DriveMotorStates getState(){
    return motorState;
  }

  public static enum DriveMotorStates{
    DRIVE,
    BROKEN,
    LOCKED,
    IDLE
  }
}
