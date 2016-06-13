
class DemoPotoki implements Runnable {

    Thread t;
    DemoPotoki() {
        t = new Thread(this, "���������������� ����� ");
        System.out.println("�������� ����� ������ " + t);
        t.start(); // ��������� ����� ���������� =======================================================================
    }
    //����� ����� �� ������ ����� ���������� ===========================================================================

    @Override
    public void run() {
            try {
                for (int i = 8 ; i > 0; i--) {
                System.out.println("�������� ����� " + i);
                Thread.sleep(500);

                 }
                }
            catch(InterruptedException e){
            System.out.println("�������� ����� �������");
            }
        System.out.println("�������� ����� ��������!!!");

        }
    }
 class NewPotok {
     public static void main(String  args[]) {
         new DemoPotoki(); // �������� ������ ������ ===================================================================
             try {
                 for ( int r = 10 ; r > 0 ; r --) {
                     System.out.println("������� �����: " + r );
                     Thread.sleep(1000);
                 }
             }
             catch (InterruptedException e ){
                 System.out.println("������� ����� �������.");
             }
         System.out.println("������� ����� ��������.");
     }
 }

