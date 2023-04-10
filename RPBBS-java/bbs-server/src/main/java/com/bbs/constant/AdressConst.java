package com.bbs.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdressConst {

    @Autowired
    private static ServerProperties serverProperties;

    public static String adress;

    static {
        try {
            adress = InetAddress.getLocalHost().getHostAddress()+":"+serverProperties.getPort();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static String httpAdress = "http://" + adress;
}
