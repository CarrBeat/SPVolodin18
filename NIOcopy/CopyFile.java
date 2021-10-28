package NIOcopy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class CopyFile {
    public static void main(String[] args) throws Exception {
        String infile = "C:\\Users\\carrb\\Desktop\\ПАРЫ\\системка\\initial\\copy1.txt";
        String outfile = "C:\\Users\\carrb\\Desktop\\ПАРЫ\\системка\\final\\copy2.txt";
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        FileChannel fcIn = fin.getChannel();
        FileChannel fcOut = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int r = fcIn.read(buffer);
            if (r == -1) {
                break;
            }
            buffer.flip();
            fcOut.write(buffer);
        }
    }
}