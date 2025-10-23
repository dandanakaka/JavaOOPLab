class WeatherThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": Today is hot, humid and sunny");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MultithreadingDemo1 {
    public static void main(String[] args) {
        WeatherThread thread1 = new WeatherThread();
        WeatherThread thread2 = new WeatherThread();
        
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        
        thread1.start();
        thread2.start();
    }
}
