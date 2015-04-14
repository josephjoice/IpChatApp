/**
 * Created by joseph on 14/4/15.
 */
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by joseph on 13/4/15.
 */
public class ChatAppServer2 extends Thread {
    ServerSocket serverSocket;
    public ChatAppServer2(int port)
    {
        try
        {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
        }catch(Exception e)
        {
            System.out.println("Error in setting up server");
        }

    }
    public void run()
    {   try
    {

        while(true)
        {
            Socket server=serverSocket.accept();

            DataInputStream in=new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            server.close();

        }
    }catch (java.io.IOException e)
    {
        //  e.printStackTrace();
    }
    }
    public static void main(String args[])
    {
        try
        {
            Thread chatAppServer=new ChatAppServer2(12346);
            chatAppServer.start();
            Thread chatAppClient =new ChatAppClient(12345);
            chatAppClient.start();

        }
        catch (Exception e)
        {
            //  e.printStackTrace();
        }
    }
}
