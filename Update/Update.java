package Update;

import java.io.IOException;
import java.util.Scanner;

import DriveTrain.DriveTrain;
import DriveTrain.DriveTrain.DriveTrainStates;

public class Update {
  public boolean isWorking(){
    if (DriveTrain.getInstance().state == DriveTrainStates.STATE ||
    DriveTrain.getInstance().state == DriveTrainStates.STATE ||
    DriveTrain.getInstance().state == DriveTrainStates.STATE ||
    DriveTrain.getInstance().state == DriveTrainStates.STATE) {
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
                    case "keyword":
                    case "keyword1":
                    case "keyword2":
                      DriveTrain.getInstance().setState(DriveTrainStates.STATE);
                      System.out.println("Message");
                      return;
                    case "keyword3":
                      DriveTrain.getInstance().setState(DriveTrainStates.STATE);
                      System.out.println("Message");
                      break;
                    case "keyword4":
                    case "keyword5":
                      DriveTrain.getInstance().setState(DriveTrainStates.STATE);
                      System.out.println("Message");
                      break;
                    case "keyword6":
                      DriveTrain.getInstance().setState(DriveTrainStates.STATE);
                      System.out.println("Message");

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
