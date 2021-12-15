package obfuscator.files;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import jdk.nashorn.internal.objects.annotations.Constructor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class downloadThreads extends Thread{
        private final String link;
        private final String path;
        private static int threadCounter;
    @Constructor(forClass = "downloadThreads")
        downloadThreads(String link, String path) {
            this.link = link;
            this.path = path;
            this.start();
        }

        @Override
        public void run() {
            try { // создание пустого файла .mp3 для последующей перезаписи и воспроизведения
            File f = new File("downloadMusicAndImage\\The_Ugly_Kings_-_Technodrone.mp3");
            if (f.createNewFile())
                System.out.println("Файл создан!");
        }
        catch (Exception e) {
            System.err.println(e);
        }
            try (FileInputStream inputStream = new FileInputStream("downloadMusicAndImage\\The_Ugly_Kings_-_Technodrone.mp3")) {
                // ссылка на файл для вопсроизведения
                System.out.println("Загружка началась: " + path);
                URL url = new URL(link);
                ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
                FileOutputStream stream = new FileOutputStream(path);
                stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
                stream.close();
                byteChannel.close();
                System.out.println("Загрузка завершена: " + path);
                threadCounter++;
                if (threadCounter == 2) {
                    System.out.println("Музыка включилась");
                    Player player = new Player(inputStream);
                    player.play(); // непосредственно включение музыки
                }
            } catch (IOException | JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }


import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface MainMethod { // аннотация обозначения метода
}







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