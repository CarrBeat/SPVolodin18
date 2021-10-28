// код взят у Соусова Ильи
package NIOcopy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// импорт библиотек
public class FileThread extends Thread {
    String filename; // создание переменной filename
    Path path; // создание переменной Path
    FileThread(String filename, Path path){ // метод "поток выполнения". Аргументы: (имя файла, адрес файла)
        this.filename = filename;
        this.path = path;
        this.start();
    }
    @Override
    public void run(){ // метод выполнения
        long startTime =  System.currentTimeMillis(); // инициализация переменной, хранящей время выполнения копирования
        try {
            Files.copy(path, Paths.get(this.filename), StandardCopyOption.REPLACE_EXISTING);
            // сверху расположен метод, копирующий файл из одного места в другое
        } catch (IOException e) {
            System.out.println("Ошибка"); // вывод сообщения об ошибке в случае исключения
        }
        long endTime = System.currentTimeMillis(); // задание переменной с временем окончания копирования
        long constTime = endTime - startTime; // задание переменной с вычислением времени копирования
        System.out.println(constTime + " мс - время потока " + this.filename);
    }
}