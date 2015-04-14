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

                Socket[] clients= {new Socket("10.2.3.116",12345),new Socket("10.2.3.116",12345)};
                for(int i=0;i<2;i++) {
                    OutputStream outToServer = clients[i].getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    out.writeUTF(sendData);
                }
            } catch (Exception e)

            {
              //  e.printStackTrace();
            }
        }
    }
}
