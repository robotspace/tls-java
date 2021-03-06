import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSSLTest {

    static String keystorePath = "client-keystore.ks";
    static String trustKeystorePath = "client-truststore.ks";
    static String keystorePassword = "client";

    public static void main(String args[]) throws Exception {
        System.setProperty("javax.net.debug", "ssl,handshake");


        System.setProperty("javax.net.ssl.keyStore", keystorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", "123456");
        //System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
        System.setProperty("javax.net.ssl.trustStore", trustKeystorePath);
        //System.setProperty("javax.net.ssl.trustStorePassword", keystorePassword);
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");

        SocketFactory factory = SSLSocketFactory.getDefault();
        Socket sslsocket = factory.createSocket("127.0.0.1", 11111);
        System.out.println("Client Connected");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sslsocket.getOutputStream(), "UTF-8"));

        out.write("hello from client" + "\n");
        out.flush();
        System.out.println("Msg Sent");
    }
}  
