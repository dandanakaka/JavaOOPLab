
class AIRunnable implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("AI");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class MultithreadingDemo2 {
    public static void main(String[] args) {
        HIRunnable hiRunnable = new HIRunnable();
        AIRunnable aiRunnable = new AIRunnable();
        
        Thread thread1 = new Thread(hiRunnable);
        Thread thread2 = new Thread(aiRunnable);
        
        thread1.start();
        thread2.start();
    }
}
