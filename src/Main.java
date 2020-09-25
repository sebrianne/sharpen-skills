public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            MultiThreadWithExtend object = new MultiThreadWithExtend();
            object.start();
        }
        for (int i = 0; i < 8; i++) {
            Thread object = new Thread(new MultiThreadWithRunnable());
            object.start();
        }

    }
}
