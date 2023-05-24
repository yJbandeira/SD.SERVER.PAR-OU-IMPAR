package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerPvP implements Runnable {

    @Override
    public void run() {
        final int PORTA2 = 12346;
        ServerSocket serverSocketPvP;
        try {
            serverSocketPvP = new ServerSocket(PORTA2);
            while (true) {
                System.out.println("Aguardando Cliente PvP....");
                Socket socketClientP1 = serverSocketPvP.accept();
                System.out.println("1");
                Socket socketClientP2 = serverSocketPvP.accept();
                System.out.println("2");
                WorkerPvP worker = new WorkerPvP(socketClientP1, socketClientP2);
                worker.start();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
