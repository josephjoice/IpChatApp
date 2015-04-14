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


    public static  void main(String args[])
    {
        String sendData;
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        while(true) {
            try {
            sendData = in.readLine();

                Socket client = new Socket("10.2.3.112",12345);
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);


                out.writeUTF(sendData);
            } catch (Exception e)

            {
              //  e.printStackTrace();
            }
        }
    }
}
