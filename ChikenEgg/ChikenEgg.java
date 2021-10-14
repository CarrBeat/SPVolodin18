package ChikenEgg;

public class ChikenEgg {
    public static  void main(String[] args){
        Emergence egg = (new Emergence("яйцо"));
        Emergence chicken = (new Emergence("курица"));
        try {
            egg.thread.join();}
        catch (InterruptedException e){
            e.printStackTrace();;
        }
        System.out.print("Первым появилось");
        if (chicken.thread.isAlive()) {
            System.out.print(" Курица");
        }else {
            System.out.println(" Яйцо");
            }
        }
    }