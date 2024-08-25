// A Java program for a ClientSide

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Hex;

public class ClientProgram {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public ClientProgram(String address, int port) {
// establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
// takes input from terminal
            input = new DataInputStream(System.in);
// sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }
        try {

          //  out.write(new CommandConverter().commandToByteArray("1", 0x01)); //set time
          //  out.write(new CommandConverter().commandToByteArray("13:30:20", 0x02)); //set time
           // out.write(new CommandConverter().commandToByteArray("24/02/11", 0x03)); //set date

        } catch (IOException i) {
            System.out.println(i);
        }
// close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        //ClientProgram client = new ClientProgram("127.0.0.1", 9094);
        ClientProgram clientProgram = new ClientProgram("192.168.1.107", 80);
    }
}