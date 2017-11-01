import java.io.*;
import java.net.*;

public class websockets_sample {
    public static void main(String args[]) throws IOException{
        String servername = args[0];
        int port = Integer.parseInt(args[1]);
        try{
            System.out.println("connecting to server "+servername+ " on port " + port);
            Socket client = new Socket(servername,port);
            
            System.out.println("Just connected to "+ client.getRemoteSocketAddress());
            OutputStream toServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(toServer);
            
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inServer);
            
            System.out.println("Server says" + in.readUTF());
            client.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
