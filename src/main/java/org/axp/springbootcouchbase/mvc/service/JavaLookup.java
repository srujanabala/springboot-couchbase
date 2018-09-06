package org.axp.springbootcouchbase.mvc.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JavaLookup {

    public static void main(String[] args) {

        long a=System.currentTimeMillis();

        lookup("10.22.69.100");

        System.out.println(System.currentTimeMillis() -a);
    }

    public static void lookup(String s) {

        InetAddress thisComputer;
        byte[] address;

        //get the bytes of the IP address
        try {
            thisComputer = InetAddress.getByName(s);
            address = thisComputer.getAddress();
        } catch (UnknownHostException ue) {
            System.out.println("cannot find host" + s);
            return;
        }

        if(isHostname(s)) {
            //print the IP address
        for(int i=0; i<address.length; i++) {
            int unsignedByte = address[i] < 0 ? address[i] + 256
                    : address[i];
            System.out.println(unsignedByte +".");
        }
        System.out.println("Hostname printed");
    } else { //this is an IP address
            try {
                System.out.println("by name: " + InetAddress.getByName(s));
                System.out.println("by canonical : " + InetAddress.getByName(s).getCanonicalHostName());
            } catch (UnknownHostException e) {
            System.out.println("Could not lookup the address");

            }
        }
}//end lookup

private static boolean isHostname(String s){
    char[] ca = s.toCharArray();
    //if we are a character that is neither a digit nor a period
    //then s is probably a hostname
    for (int i=0; i < ca.length; i++) {
        if(!Character.isDigit(ca[i])){
            if(ca[i] != '.') {
                return true;
            }
        }
    }

    return false;

}//end isHostName

}
