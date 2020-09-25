import java.lang.*;

/**
 * @author Sebrianne Ferguson
 * to practice multithreading by extending the thread class
 */
public class MultiThreadWithExtend extends Thread {
    public void run() {
        try {
            System.out.println("Thread"
                    + Thread.currentThread().getId()
                    + "state = "
                    + Thread.currentThread().getState());
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
