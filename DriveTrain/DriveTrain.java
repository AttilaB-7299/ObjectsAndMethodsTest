package DriveTrain;

import Update.Update;
import Motor.DriveMotor;
import Motor.DriveMotor.DriveMotorStates;

public class DriveTrain {
    private DriveMotor BackLeft;
    private DriveMotor BackRight;
    private DriveMotor FrontRight;
    private DriveMotor FrontLeft;

    private DriveTrainStates state = DriveTrainStates.IDLE;
    private static DriveTrain instance;

    public enum DriveTrainStates {
        DRIVE,
        BROKEN,
        LOCKED,
        SHOOTING,
        IDLE
    }

    private DriveTrain() {
        FrontLeft  = new DriveMotor(2, "Kraken");
        FrontRight = new DriveMotor(3, "Kraken");
        BackLeft   = new DriveMotor(4, "Kraken");
        BackRight  = new DriveMotor(5, "Kraken");
    }

    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
            System.out.println("DriveTrain initialized.");
        }
        return instance;
    }

    public DriveTrainStates setState(DriveTrainStates desired) {
        switch (desired) {
            case DRIVE:
            case SHOOTING:
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
                break;
            case LOCKED:
                BackLeft.setState(DriveMotorStates.LOCKED);
                BackRight.setState(DriveMotorStates.LOCKED);
                FrontLeft.setState(DriveMotorStates.LOCKED);
                FrontRight.setState(DriveMotorStates.LOCKED);
                break;
            case IDLE:
                BackLeft.setState(DriveMotorStates.IDLE);
                BackRight.setState(DriveMotorStates.IDLE);
                FrontLeft.setState(DriveMotorStates.IDLE);
                FrontRight.setState(DriveMotorStates.IDLE);
                break;
        }

        if (state != desired) {
            System.out.println("DriveTrain state changed: " + state + " → " + desired);
            state = desired;
        }
        return state;
    }

    public DriveTrainStates getState() {
        return state;
    }

    public void drive(double ySpeed, double xSpeed) {
        if (instance.getState() == DriveTrainStates.DRIVE) {
            System.out.println("Already driving.");
        }

        instance.setState(DriveTrainStates.DRIVE);
        System.out.println("=== DRIVE MODE STARTED ===");
        new Update().update();

        System.out.println("=== DRIVE MODE ENDED ===");
    }
}
