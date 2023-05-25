package Server;

public class Server {
    public static void main(String[] args) {

        ServerPvC serverPvC = new ServerPvC();

        ServerPvP serverPvP = new ServerPvP();

        Thread pvCThread = new Thread(serverPvC);
        Thread pvPThread = new Thread(serverPvP);

        pvCThread.start();
        pvPThread.start();

    }
}