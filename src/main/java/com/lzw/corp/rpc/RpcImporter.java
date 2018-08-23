package com.lzw.corp.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RpcImporter<S> {


    public S importr(final Class<?> serverClass, final InetSocketAddress address) {
        return (S) Proxy.newProxyInstance(serverClass.getClassLoader(), new Class<?>[]{serverClass.getInterfaces()[0]},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Socket socket = null;
                    ObjectOutputStream objectOutputStream = null;
                    ObjectInputStream objectInputStream = null;
                    try{
                        socket = new Socket();
                        socket.connect(address);
                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutputStream.writeUTF(serverClass.getName());
                        objectOutputStream.writeUTF(method.getName());
                        objectOutputStream.writeObject(method.getParameterTypes());
                        objectOutputStream.writeObject(args);
                        objectInputStream = new ObjectInputStream((socket.getInputStream()));
                        return objectInputStream.readObject();
                    }finally {
                        if(null!=socket){
                            socket.close();
                        }
                        if(null!=objectOutputStream){
                            objectOutputStream.close();
                        }
                        if(null!=objectInputStream){
                            objectInputStream.close();
                        }
                    }


                }
            }
        );
    }
}
