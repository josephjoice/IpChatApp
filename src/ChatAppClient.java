import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by joseph on 14/4/15.
 */
public class ChatAppClient extends Thread {
    int sendPort;
    public ChatAppClient(int port)
    {
        sendPort=port;
    }


    public void run()
    {

        String sendData;
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        while(true) {
            try {
            sendData = in.readLine();
                for(int i=0;i<ChatAppServer.num;i++) {
                    try {
                        if(!ChatAppServer.formedConnections[i].equals(""))
                        {
                            ChatAppServer.clients[i] = new Socket(ChatAppServer.formedConnections[i], 12345);

                        }
                        OutputStream outToServer = ChatAppServer.clients[i].getOutputStream();
                        DataOutputStream out = new DataOutputStream(outToServer);
                        out.writeUTF(ChatAppServer.name + ":" + sendData);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e)

            {
               e.printStackTrace();
            }
        }
    }
}
