import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        // pr.println("is connected");
        // pr.flush();
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server : " + str);
        while (true) {

            System.out.println("insert a number");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            pr.println(num);
            pr.flush();
            in = new InputStreamReader(socket.getInputStream());
            bf = new BufferedReader(in);
            str = bf.readLine();
            System.out.println("server : " + str);
        }

    }
}
