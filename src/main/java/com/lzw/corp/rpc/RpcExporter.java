package com.lzw.corp.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
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
                String methodName = input.readUTF();
                Class<?>[]parameterType = (Class<?>[])input.readObject();
                Object[]argument=(Object[])input.readObject();
                Class server = Class.forName(interfaceName);
                Object method = server.getMethod(methodName,parameterType);
                Object result = method.invoke(server.newInstance(), argument);
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(input!=null){
                    try{
                        input.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                if(null!=output){
                    try{
                        output.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                if(null!=client){
                    try{
                        client.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
