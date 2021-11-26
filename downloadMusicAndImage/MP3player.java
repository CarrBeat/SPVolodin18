package downloadMusicAndImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MP3player { 
    private static final String DATA_FILE = "downloadMusicAndImage\\links.txt"; // константа, содержащая путь к файлу
    @MainMethod
    public static void main(String[] args) {
        try (BufferedReader BRDataFile = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            String[] data;
            while ((line = BRDataFile.readLine()) != null) { // старт потока скачивания
                data = line.split(" ");
                new downloadThreads(data[0], data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
