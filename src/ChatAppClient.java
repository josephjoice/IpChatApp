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
                Socket client = new Socket("localhost",sendPort);
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);

                sendData = in.readLine();
                out.writeUTF(sendData);
            } catch (Exception e)

            {
                e.printStackTrace();
            }
        }
    }
}
