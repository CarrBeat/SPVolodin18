package ChikenEgg;

public class Emergence implements  Runnable{
    Thread thread;
    public Emergence(String name){
        thread = new Thread(this,name);
        thread.start();
    }
    public void run(){
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(750);}
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(thread.getName());
        }
    }
}