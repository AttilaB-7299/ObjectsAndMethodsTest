package Update;

import java.io.IOException;
import java.util.Scanner;

import DriveTrain.DriveTrain;
import DriveTrain.DriveTrain.DriveTrainStates;

public class Update {
  public boolean isWorking(){
    if (DriveTrain.getInstance().getState() == DriveTrainStates.DRIVE ||
    DriveTrain.getInstance().getState() == DriveTrainStates.IDLE ||
    DriveTrain.getInstance().getState() == DriveTrainStates.SHOOTING ||
    DriveTrain.getInstance().getState() == DriveTrainStates.LOCKED) {
      return true;
    }
    else {
      return false;
    }
  }
  public void update(){
    Scanner scanner = new Scanner(System.in);

        long lastPrint = System.currentTimeMillis();
        final long PRINT_INTERVAL_MS = 1500;  // print every 1.5 seconds

        while (isWorking()) {
          // Periodic status print
          long now = System.currentTimeMillis();
          if (now - lastPrint >= PRINT_INTERVAL_MS) {
            if (isWorking()){
              System.out.println(DriveTrain.getInstance().getState().toString());
            }
              lastPrint = now;
          }

          // Check for input safely
          try {
              if (System.in.available() > 0) {
                  String input = scanner.nextLine().trim().toLowerCase();
                  switch (input){
                    case "stop":
                    case "exit":
                    case "q":
                      DriveTrain.getInstance().setState(DriveTrainStates.IDLE);
                      System.out.println("Stopping drive...");
                      return;
                    case "idle":
                      DriveTrain.getInstance().setState(DriveTrainStates.IDLE);
                      System.out.println("Idle");
                      break;
                    case "b":
                    case "locked":
                      DriveTrain.getInstance().setState(DriveTrainStates.LOCKED);
                      System.out.println("WHEELS X LOCKED");
                      break;
                    case "drive":
                      DriveTrain.getInstance().setState(DriveTrainStates.DRIVE);
                      System.out.println("Driving");

                  }
              }
          } catch (IOException e) {
              System.err.println("Error checking input availability: " + e.getMessage());
              // You can break; or continue; depending on how critical this is
              // For a simple sim, we usually just continue
          }

          // Small sleep to avoid CPU spin
          try {
              Thread.sleep(200);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              break;
          }
    }
    scanner.close();
  }
}
