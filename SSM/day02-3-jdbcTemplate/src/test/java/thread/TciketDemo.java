package thread;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class TciketDemo {
    public static void main(String[] args) {
      Ticket ticket=  new Ticket();

        Thread thread1=new Thread(ticket);
        Thread thread2=new Thread(ticket);
        Thread thread3=new Thread(ticket);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
