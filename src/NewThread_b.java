/**
 * Created by User on 13.06.2016.
 */
// Примененить метод join(), что бы ожидать завершения потока  исполнения
class NewThread_b  implements Runnable {
    String name;
    Thread t;
    NewThread_b (String threadname){
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Новый поток " + t);
        t.start();// Запуск потока исполнения
    }

    //Точка входа в поток иполнения

    @Override
    public void run() {
       try{
          for(int i = 9; i > 0; i--){
            System.out.println( name + ":" + i);
            Thread.sleep(1000);

          }
       }     catch (InterruptedException e){
          System.out.println(name + " рперван.");
             }
    }
}
class DemoJoin{
    public static void main(String[] args) {
        NewThread_b ob1 = new NewThread_b("Один");
        NewThread_b ob2 = new NewThread_b("Два");
        NewThread_b ob3 = new NewThread_b("Три");

        System.out.println("Поток один завершён :" + ob1.t.isAlive());
        System.out.println("Поток два завершён :" + ob2.t.isAlive());
        System.out.println("Поток три завершён :" + ob3.t.isAlive());



        //Ожидать завершение потока исполнения ===================================================================
        try {
            System.out.println("Ожидание завершения потоков");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }
        catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Поток Один завершен: " + ob1.t.isAlive());
        System.out.println("Поток Один завершен: " + ob2.t.isAlive());
        System.out.println("Поток Один завершен: " + ob3.t.isAlive());
        System.out.println("Главный поток завершён.");
    }
}

