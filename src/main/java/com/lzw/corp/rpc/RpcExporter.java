package com.lzw.corp.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {


    public static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostName,int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));
        try{
            while(true){
                executor.execute(new ExportTask(serverSocket.accept()));
            }
        }finally {
            serverSocket.close();
        }
    }

    //https://blog.csdn.net/lh9898/article/details/81008668
    public static class ExportTask implements Runnable {
        private Socket client = null;
        private ExportTask(Socket socket){
            super();
            this.client=socket;
        }
        public void run(){
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try{
                input = new ObjectInputStream(client.getInputStream());
                String interfaceName = input.readUTF();

            }
        }
    }

}
