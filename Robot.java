import DriveTrain.DriveTrain;

public class Robot {
    public static void main(String[] args) {
        DriveTrain drivetrain = DriveTrain.getInstance();

        drivetrain.drive(0.8, 0.3);

    }
}
