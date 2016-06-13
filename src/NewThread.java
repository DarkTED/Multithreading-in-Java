/**
 * Created by User on 12.06.2016.
 */
//Создать второй поток исполнения, расширив класс Thread

class NewThread extends Thread {
    NewThread(){
        //Создание нового потока исполнения=============================================================================
        System.out.println("Дочерний поток " + this);
        Thread t;
        t = new Thread(this, "gash");
        t.start(); //Запустить поток на исполнение =======================================================================
    }
    //Точка входа во второй поток исполнения============================================================================
    public void run(){
        try {
            for (int i = 5 ; i > 0; i--) {
                System.out.println("Дочкрний поток " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершён");
    }
}

class ExtendThread {
    public static void main(String[] args) {

        new NewThread(); //Создать новый поток исполнения
        try{
            for (int i = 6 ;i >0 ; i --) {
                System.out.println("Главный поток "+ i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {

            System.out.println("Главный поток прерван");
        }

        System.out.println("Главный поток завершён");
    }
}

