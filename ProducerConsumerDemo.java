class Stock {
    private int items = 0;
    private final int MAX_CAPACITY = 10;
    
    public synchronized void produce(int quantity) {
        while (items + quantity > MAX_CAPACITY) {
            System.out.println("Stock is full. Producer is waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        items += quantity;
        System.out.println("Producer produced: " + quantity + " items. Total stock: " + items);
        notifyAll();
    }
    
    public synchronized void consume(int quantity) {
        while (items < quantity) {
            System.out.println("Not enough items in stock. Consumer is waiting...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        items -= quantity;
        System.out.println("Consumer consumed: " + quantity + " items. Remaining stock: " + items);
        notifyAll();
    }
}

class Producer extends Thread {
    private Stock stock;
    
    public Producer(Stock stock) {
        this.stock = stock;
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            stock.produce(2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {
    private Stock stock;
    
    public Consumer(Stock stock) {
        this.stock = stock;
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            stock.consume(3);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class ProducerConsumerDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();
        
        Producer producer = new Producer(stock);
        Consumer consumer = new Consumer(stock);
        
        producer.setName("Producer-Thread");
        consumer.setName("Consumer-Thread");
        
        producer.start();
        consumer.start();
    }
}
