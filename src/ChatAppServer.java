import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by joseph on 13/4/15.
 */
public class ChatAppServer extends Thread {
    ServerSocket serverSocket;
    public ChatAppServer(int port)
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
            Thread chatAppServer=new ChatAppServer(12345);
            chatAppServer.start();
            Thread chatAppClient =new ChatAppClient(12346);
            chatAppClient.start();

        }
        catch (Exception e)
        {
          //  e.printStackTrace();
        }
    }
}
