

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Send {
    private static DataOutputStream dos;
    private static boolean isRunning =true;
    private Socket client;

    public Send(Socket client) throws IOException {

            dos=new DataOutputStream(client.getOutputStream());
            /*dos=new DataOutputStream(client.getOutputStream());
            dos.writeUTF("ssssssssssssssssssssssssssssssss");
            dos.flush();
            dos.writeUTF("ssssssssssssssssssssssssssssssss");
            dos.flush();*/

    }
/*
    private String getMsgFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            return "";
        }
    }
*/
    public static void send(String msg){

        if(null!=msg&&!msg.equals("")){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                isRunning=false;
                CloseUtil.closeAll(dos);
            }

        }
    }
    public static String msgProSend(String fisrtInstr, List<String> msgList){
        String processedmsg=fisrtInstr;
        for(int i=0;i<msgList.size();i++){
            processedmsg+="#"+msgList.get(i);
        }
        return processedmsg;
    }

}
