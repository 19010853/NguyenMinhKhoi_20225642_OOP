import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\NguyenMinhKhoi_20225642_OOP\\NguyenMinhKhoi_20225642_LAB02\\OthersProject\\src\\hust\\soict\\hedspi\\garbage\\main\\java\\test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes){
            outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
