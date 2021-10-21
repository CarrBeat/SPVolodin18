package CopyFiles;

public class Main {
    public static void main(String[] args) {
        CopyingService.multiThread(Runtime.getRuntime().availableProcessors());
    }
}