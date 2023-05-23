package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        final int PORTA = 12345;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(PORTA);
            while (true) {
                System.out.println("Aguardando Cliente....");
                Socket socketClient = serverSocket.accept();
                Worker worker = new Worker(socketClient);
                worker.start();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}