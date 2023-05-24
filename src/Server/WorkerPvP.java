package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Logic.ParOuImparLogic;
import Util.Enum.EParOuImpar;
import Util.Model.RequestModel;
import Util.Model.ResponseModel;
import Util.Model.ResponsePvPModel;
import Util.Model.ResultadoParImparModel;

public class WorkerPvP extends Thread {
    Socket client1;
    Socket client2;

    public WorkerPvP(Socket client, Socket client2) {
        this.client1 = client1;
        this.client2 = client2;
    }

    public void run() {
        ParOuImparLogic _parOuImparLogic = new ParOuImparLogic();

        try {
            ObjectInputStream input1 = new ObjectInputStream(client1.getInputStream());
            ObjectOutputStream output1 = new ObjectOutputStream(client1.getOutputStream());

            ObjectInputStream input2 = new ObjectInputStream(client2.getInputStream());
            ObjectOutputStream output2 = new ObjectOutputStream(client2.getOutputStream());

            System.out.println("Aguardando requisição 1...");
            RequestModel request = (RequestModel) input1.readObject();

            System.out.println("Aguardando requisição 2...");
            RequestModel request2 = (RequestModel) input2.readObject();

            double result;

            ResultadoParImparModel retornoJogo;
            retornoJogo = _parOuImparLogic.ExecutaParOuImparPvP(request.getNumero(), request.getParImpar(),
                    request2.getNumero(), request2.getParImpar());

            ResponsePvPModel response1;
            ResponsePvPModel response2;

            if (retornoJogo.getVencedor() == 1) {
                response1 = new ResponsePvPModel(request2.getNumero(), retornoJogo.getOpcaoP2().toString(),
                        "Você VENCEU!", true);
            } else {
                response1 = new ResponsePvPModel(request2.getNumero(), retornoJogo.getOpcaoP2().toString(),
                        "Você PERDEU!", false);
            }

            String troca = retornoJogo.getHouveTroca()
                    ? "Seu adversário escolheu primeiro, e a escolha foi igual a sua, portanto, vc ficou com a outra opção"
                    : "";

            if (retornoJogo.getVencedor() == 2) {

                response2 = new ResponsePvPModel(request2.getNumero(), retornoJogo.getOpcaoP2().toString(),
                        new String("Você VENCEU!, " + troca), true);
            } else {
                response2 = new ResponsePvPModel(request2.getNumero(), retornoJogo.getOpcaoP2().toString(),
                        new String("Você PERDEU!, " + troca), false);
            }

            output1.writeObject(response1);
            output2.writeObject(response2);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
