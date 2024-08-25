import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Client1 {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void read() throws IOException {
  //      System.out.println(new Date());
        startConnection("192.168.1.107", 80);
        Map<String, String> result = new HashMap<>();
       // for (int i = 0; i < 7; i++) {
        while (true){
            String response = in.readLine();
           // if (response.startsWith("*A6")) continue;
            //result.put(getResponseType(response.substring(1,3)) , response.split("\"")[1]);
            System.out.println(response);
        }
        //System.out.println(result);
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    private String getResponseType(String type)
    {
        switch (type)
        {
            case "A0":
                return "time";
            case "A1":
                return "date";
            case "A2":
                    return "RH";
            case "A3":
                return "Temp";
            case "A4":
                return "Pressure/P";
            case "A5":
                return "Device Id";
            default:
                return "";
        }
    }



    public static void main(String[] args) throws IOException, InterruptedException {
       new Client1().read();
    }
}
