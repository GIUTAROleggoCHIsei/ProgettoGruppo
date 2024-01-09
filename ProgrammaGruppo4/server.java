import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(4999);
        Socket socket = socketServer.accept();

        System.out.println("client connected");

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(" is connected");
        pr.flush();

        while (true) {
            String str = bf.readLine();
            System.out.println("client : " + str);
            int num = Integer.parseInt(str);
            if (num % 2 == 0) {
                pr.println(num + " even / (2n+1) -> " + (2 * num + 1));
            } else
                pr.println(num + " shots / (2n) -> " + (2 * num));
            pr.flush();
        }

    }
}