package CopyFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CopyingService {

    private static ArrayList<String> listOfFiles = new ArrayList<String>();

    private static void getListOfFiles() {
        File first = new File("first");
        if (first.isDirectory()) {
            String[] filenames = first.list();
            for (String file : filenames) {
                listOfFiles.add(file);
            }
        } else System.out.format("Ошибка! Папка '%s' не существует", first);
    }

    public static void copyFromList(int begin, int end, Thread thr) {
        for (int i = begin; i < end; i++) {
            File file = new File("originals/" + listOfFiles.get(i));
            File copy = new File("copied/" + listOfFiles.get(i));
            try {
                copying(file, copy);
                System.out.println("Файл " + listOfFiles.get(i) + " скопирован " + thr.getName());
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void multiThread(int numberOfCores) {
        long timerStart = System.currentTimeMillis();

        getListOfFiles();
        if (listOfFiles.size() == 0) {
            System.out.println("There are no files to copy!");
            return;
        }

        FilesCopyingThread[] fctArray = new FilesCopyingThread[numberOfCores];
        int size = listOfFiles.size() / numberOfCores;
        for (int i = 0; i < numberOfCores; i++) {
            int begin = size * i;
            int end = size * (i + 1);
            fctArray[i] = new FilesCopyingThread(begin, end);
        }

        for (int i = 0; i < fctArray.length; i++) {
            try {
                fctArray[i].getThr().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        long timerEnd = System.currentTimeMillis();
        System.out.println("All files were copied\nTime: " + (timerEnd - timerStart) + " ms.");
    }

    private static void copying(File in, File out) throws IOException {
        try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
            byte[] array = new byte[1024];
            for (int n = 0; (n = fis.read(array)) > 0; ) {
                fos.write(array, 0, n);
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
