class NewThread implements Runnable {
    Thread t;
    private String name;

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Доч поток создан " + t);
        t.start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Доч поток " + name + " " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Доч поток завершен "+name);
    }
}
public class MyThread {
    public static void main(String[] args) {
        System.out.println("Гл поток создан ");
        NewThread t1 = new NewThread("1");
        NewThread t2 = new NewThread("2");
        NewThread t3 = new NewThread("3");

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Главный поток " + i);
                Thread.sleep(10);
            }
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Гл поток завершен");
    }
}
