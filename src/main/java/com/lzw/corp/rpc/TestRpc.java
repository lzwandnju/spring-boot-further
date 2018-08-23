package com.lzw.corp.rpc;

import java.net.InetSocketAddress;

public class TestRpc {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    RpcExporter.exporter("localhost",8080);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
    EchoService echoService = importer.importr(EchoServiceImpl.class,new InetSocketAddress("localhost",8080));
    System
    System.out.println(echoService.echo("Are you OK?"));

}
