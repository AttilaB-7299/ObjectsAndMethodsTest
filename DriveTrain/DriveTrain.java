package DriveTrain;

import Update.Update;
import Motor.DriveMotor;
import Motor.DriveMotor.DriveMotorStates;

public class DriveTrain {
    private DriveMotor motor;
    private DriveTrainStates state = DriveTrainStates.STATE;
    private static DriveTrain instance;

    public enum DriveTrainStates {
        STATE,
        STATE1,
        STATE2,
        STATE3,
        STATE4
    }

    private DriveTrain() {
        motor = DriveMotor();
    }
    //dont touch
    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
            System.out.println("DriveTrain initialized.");
        }
        return instance;
    }
    //---------------
    public DriveTrainStates setState(DriveTrainStates desired) {
        switch (desired) {
            case STATE:
            case STATE:
                motor.setState();
                break;
            case STATE:
                motor.setState();
                break;
            case STATE:
                motor.setState();
                break;
            case STATE:
                motor.setState();
                break;
        }

        if (state != desired) {
            state = desired;
        }
        return state;
    }
    public void drive(double ySpeed, double xSpeed) {
        new Update().update();
    }
}
