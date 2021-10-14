package AnimalsRun;

public class AnimalThread extends Thread {
    String PersonName;
    int priorityThread;
    final int DIST = 100;
    public AnimalThread(String PersonName, int priorityThread) {
        this.PersonName = PersonName;
        this.priorityThread = priorityThread;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priorityThread);
        Thread.currentThread().setName(PersonName);
        int timeToStep = 500 / (Thread.currentThread().getPriority());
        for (int i = 1; i < DIST; i++) {
            try {
                Thread.sleep(timeToStep);
                System.out.println(getName() + " пробежал(а) " + i + " метров ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == DIST / 2) {
                if (Thread.currentThread().getPriority() == 1) {
                    Thread.currentThread().setPriority(10);
                } else {
                    Thread.currentThread().setPriority(1);
                }
                timeToStep = 500 / (Thread.currentThread().getPriority());
                System.out.println(" ");
                System.out.println("произошло опережение");
            }
            if (i == DIST - 1) {
                System.out.println("___________ Финиш ___________");
            }
        }
    }
}