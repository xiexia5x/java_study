package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class Ticket implements Runnable{
    ReentrantLock lock= new ReentrantLock();
    private  int TicketCount=100;
    @Override
    public void run() {

            while (true) {
               try {
                   lock.lock();
                   if (TicketCount <= 0) {
                       break;
                   } else {
                       TicketCount--;
                       Thread.sleep(100);
                       System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩" + TicketCount + "票");
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }finally {
                   lock.unlock();
               }

        }
    }
}
