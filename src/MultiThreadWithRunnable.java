public class MultiThreadWithRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread"
                    + Thread.currentThread().getId()
                    + "state = "
                    + Thread.currentThread().getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
