
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Receive {
    private static DataInputStream dis;
    private static boolean isRunning=true;
    public Receive(){

    }
    public Receive(Socket client){
        this();
        try {
            dis=new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning=false;
            CloseUtil.closeAll(dis);
        }
    }
    public static String receive(){
        String msg="";
        try {
            msg=dis.readUTF();
        } catch (IOException e) {
            isRunning=false;
            CloseUtil.closeAll(dis);
        }

        return msg;
    }

    public static List<String> msgProReceive(String msg){
        List<String> msgList= Arrays.asList(msg.split("#"));
        return msgList;
    }


}
