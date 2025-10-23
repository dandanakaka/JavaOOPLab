class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + 
                             " with priority " + Thread.currentThread().getPriority() + 
                             " is running - Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class ThreadPriorityDemo {
    public static void main(String[] args) {
        PriorityThread thread1 = new PriorityThread("Low-Priority-Thread");
        PriorityThread thread2 = new PriorityThread("Medium-Priority-Thread");
        PriorityThread thread3 = new PriorityThread("High-Priority-Thread");
        
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println("Thread Priorities:");
        System.out.println(thread1.getName() + " priority: " + thread1.getPriority());
        System.out.println(thread2.getName() + " priority: " + thread2.getPriority());
        System.out.println(thread3.getName() + " priority: " + thread3.getPriority());
        System.out.println("\nStarting threads...\n");
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
