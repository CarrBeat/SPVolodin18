package CopyFiles;

public class FilesCopyingThread implements Runnable {
    private int begin;
    private int end;
    private Thread thr;

    public FilesCopyingThread(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        CopyingService.copyFromList(begin, end, thr);
    }

    public Thread getThr() {
        return thr;
    }
}