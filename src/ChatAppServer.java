import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by joseph on 13/4/15.
 */
public class ChatAppServer extends Thread {
    ServerSocket serverSocket;
    static String name;
    static int num;
    static String[] formedConnections;
    static Socket[] clients;
    public ChatAppServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
        } catch (Exception e) {
            System.out.println("Error in setting up server");
        }

    }

    public void run() {

        while (true) {
            try {
                Socket server = serverSocket.accept();

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                server.close();
                Thread.sleep(1);


            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        try {
            System.out.print("Enter Your Name : ");
            name=in.readLine();
            System.out.print("Number of People you want to send your message : ");
            num=Integer.parseInt(in.readLine());
            clients=new Socket[num];
            formedConnections=new String[num];

            for(int i=0;i<num;i++)
            {
                System.out.print("Enter computer name "+i+": ");
                String serverName=in.readLine();
                formedConnections[i]=serverName;

                try {
                    clients[i] = new Socket(serverName, 12345);
                    formedConnections[i]="";
                }
                catch(Exception e)
                {

                }

            }
            Thread chatAppServer = new ChatAppServer(12345);
            chatAppServer.start();

            Thread chatAppClient = new ChatAppClient(12345);
            chatAppClient.start();



        } catch (Exception e) {
            //  e.printStackTrace();
        }
    }
}
