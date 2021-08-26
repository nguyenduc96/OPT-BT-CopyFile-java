import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập link file gốc : ");
        String sourcePath = scanner.nextLine();
        System.out.println("Nhập link file muốn sao đến : ");
        String destPath = scanner.nextLine();
        try {
            copyBinaryFile(sourcePath, destPath);
            System.out.println("Copy thành công");
        }catch (IOException e){
            System.out.println("Copy không thành công");
        }

    }

    public static void copyBinaryFile(String sourcePath, String destPath) throws IOException {
        try {
            InputStream inputStream = new FileInputStream(sourcePath);
            OutputStream outputStream = new FileOutputStream(destPath);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            byte[] buffers = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffers)) > 0) {
                dataOutputStream.write(buffers, 0, length);
            }
        } catch (IOException e) {
            System.out.println("File nguồn không tồn tại hoặc đường dẫn file không đúng");
        }

    }
}
