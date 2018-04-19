package com.dummyapp.socket;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by cl-macmini-86 on 7/25/17.
 */

public class Client extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;
    @Override
    protected Void doInBackground(final Void... voids) {

        Socket socket=null;
        try{
            socket=new Socket(dstAddress,dstPort);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(1024);
            byte[] buffer=new byte[1024];
            int bytesRead;
            InputStream inputStream=socket.getInputStream();
         while ((bytesRead=inputStream.read(buffer))!=-1){
             byteArrayOutputStream.write(buffer, 0, bytesRead);
             response += byteArrayOutputStream.toString("UTF-8");
         }

        } catch (IOException e) {
            response = "IOException: " + e.toString();
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null ;
    }

    public Client(final String dstAddress, final int dstPort, final TextView textResponse) {
        this.dstAddress = dstAddress;
        this.dstPort = dstPort;
        this.textResponse = textResponse;
    }
}
