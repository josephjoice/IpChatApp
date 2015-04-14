import java.net.ServerSocket;

/**
 * Created by joseph on 13/4/15.
 */
public class ChatApp {
    ServerSocket serverSocket;
    public ChatApp()
    {
        try
        {
        serverSocket = new ServerSocket(12345);
        serverSocket.setSoTimeout(10000);
    }catch(Exception e)
        {

        }

    }
}
