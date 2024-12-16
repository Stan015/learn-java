package me.stanleyazi.AdvancedJava;

import java.net.*;
import java.util.Arrays;

public class NetworkingDemo {
  public static void main(String[] args) throws UnknownHostException {
    String url = "www.stanleyazi.me";

    InetAddress address = InetAddress.getByName(url);
    System.out.println("Address: " + Arrays.toString(address.getAddress()));

    // getHostAddress() method
    System.out.println("Host address: " + address.getHostAddress());

    // getHostName() method
    System.out.println("Host name: " + address.getHostName());

    // isAnyLocalAddress() method
    System.out.println("isAnyLocalAddress: " + address.isAnyLocalAddress());

    // isLinkLocalAddress() method
    System.out.println("isLinkLocalAddress: " + address.isLinkLocalAddress());

    // isLoopbackAddress() method
    System.out.println("isLoopbackAddress: " + address.isLoopbackAddress());

    // isSiteLocalAddress() method
    System.out.println("isSiteLocalAddress: " + address.isSiteLocalAddress());

    // hashCode() method
    System.out.println("hashCode: " + address.hashCode());
  }
}
