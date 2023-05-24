package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerPvC serverPvC = new ServerPvC();
        //serverPvC.run();

        ServerPvP serverPvP = new ServerPvP();
        //serverPvP.run();

        Thread pvCThread = new Thread(serverPvC);
        Thread pvPThread = new Thread(serverPvP);

        pvCThread.start();
        pvPThread.start();

        // final int PORTA = 12345;
        // final int PORTA2 = 12346;
        // ServerSocket serverSocket;
        // ServerSocket serverSocketPvP;

        // try {
        // serverSocket = new ServerSocket(PORTA);
        // while (true) {
        // System.out.println("Aguardando Cliente....");
        // Socket socketClient = serverSocket.accept();
        // Worker worker = new Worker(socketClient);
        // worker.start();
        // }
        // } catch (Exception e) {
        // System.out.println("Erro: " + e.getMessage());
        // }

        // try {
        // serverSocketPvP = new ServerSocket(PORTA2);
        // while (true) {
        // System.out.println("Aguardando Cliente PvP....");
        // Socket socketClientP1 = serverSocketPvP.accept();
        // Socket socketClientP2 = serverSocketPvP.accept();
        // WorkerPvP worker = new WorkerPvP(socketClientP1, socketClientP2);
        // worker.start();
        // }
        // } catch (Exception e) {
        // System.out.println("Erro: " + e.getMessage());
        // }
    }
}