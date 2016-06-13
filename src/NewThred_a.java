/**
 * Created by User on 12.06.2016.
 */
class NewThread_a implements Runnable {
    String name;//Имя потока исполнения
    private Thread t;
    NewThread_a(String threadname){
       name = threadname;
        t = new Thread(this,name);
        System.out.println("Новый поток : " + t);
        t.start();// Запуск потока на исполнение
     }
// Точка входа в поток исполнеия
    @Override
    public void run() {
        try{
            for (int i = 5; i > 0 ; i --){
                System.out.println(name + " : " + i);
                Thread.sleep(1000);

            }

        }catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
            System.out.println(name + " - завершён.");
    }
}
class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread_a("Один");//Запуск потока на исполнение
        new NewThread_a("Два");
        new NewThread_a("Три");


        try {
            //Ожидать завершения других потоков исполнения
            Thread.sleep(10000);

        }catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен.");

    }
}
