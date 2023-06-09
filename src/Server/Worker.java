package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Logic.ParOuImparLogic;
import Util.Model.RequestModel;
import Util.Model.ResponseModel;

public class Worker extends Thread {
    Socket client;

    public Worker(Socket client) {
        this.client = client;
    }

    public void run() {
        ParOuImparLogic _parOuImparLogic = new ParOuImparLogic();

        try {
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());

            System.out.println("Aguardando requisição...");
            RequestModel request = (RequestModel) input.readObject();
            
            ResponseModel retornoJogo = null;
            retornoJogo = _parOuImparLogic.ExecutaParOuImparComACpu(request.getNumero(), request.getParImpar());
            
            output.writeObject(retornoJogo);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
