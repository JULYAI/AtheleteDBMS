import javax.swing.*;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Client {
    String host="127.0.0.1";
    int port=9800;
    private DataInputStream dis;
    private OutputStream dos;
    Boolean isRunning=true;

    public Client() {
        /*Socket socket= null;
        try {
            socket = new Socket(host,port);
            dos=new DataOutputStream(socket.getOutputStream());
            dis=new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            isRunning=false;
            CloseUtil.closeAll(dos,dis);
        }*/


    }

    /*public String formatMsg(String str){
        String formatedMsg ="";
        int length=str.length();
        formatedMsg="[length="+length+"]"+str;
        return formatedMsg;
    }
    public static void sendMsg(String formatedMsg) throws IOException {
        byte [] sendBytes=formatedMsg.getBytes("UTF-8");
        outputStream.write(sendBytes);
        outputStream.flush();
    }*/
    public static void main(String[]arg) throws IOException {
        /*Socket client=new Socket("localhost",9000);
        Send send=new Send(client);
        Receive receive=new Receive((client));*/

        JFrame frame = new JFrame("LoginFrame");
        frame.setContentPane(new LoginFrame(frame).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,350);
        frame.setVisible(true);

        /*try {
            String host="127.0.0.1";
            int port=9000;
            Socket socket=new Socket(host,port);
            OutputStream outputStream=socket.getOutputStream();
            String message = "你好 ";
            //首先需要计算得知消息的长度
            byte[] sendBytes = message.getBytes("UTF-8");
            //然后将消息的长度优先发送出去
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            //然后将消息再次发送出去
            outputStream.write(sendBytes);
            outputStream.flush();
            //==========此处重复发送一次
            message = "第二条消息";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.flush();
            message = "the third message!";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);

            *//*Client client=new Client();
            String msg="0#你好啊！#";
            client.sendMsg(client.formatMsg(msg));
            String msg1="0#你好！#";
            client.sendMsg(client.formatMsg(msg1));
            String msg2="0#你好！*1#";
            client.sendMsg(client.formatMsg(msg2));*//*
            Scanner reader =new Scanner(System.in);
            reader.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

}
