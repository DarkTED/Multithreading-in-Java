import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 * Created by User on 15.06.2016.
 */

//В этой программе используется синхронизированный блок
public class Callme {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e ) {
            System.out.println("Прервано");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller (Callme targ, String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    //инхронизированные вызовы метода call()]]
    public void run() {
      synchronized (target){ //Синхронизированный блок
          target.call(msg);

      }
    }
}

class Synch1 {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, " в синхронизированный ");
        Caller ob3 = new Caller(target, " мир!");
// Ожидание завершения потока исполнения
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();


        }catch (InterruptedException e){
            System.out.println("Прервано");

        }
    }
}