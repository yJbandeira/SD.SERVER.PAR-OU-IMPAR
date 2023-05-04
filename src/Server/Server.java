package Server;

import java.net.ServerSocket;
import java.net.Socket;

import Interface.IParOuImparLogic;
import Logic.ParOuImparLogic;
import Enum.EParOuImpar;

public class Server {
    public static void main(String[] args) {

        IParOuImparLogic _parOuImparLogic = new ParOuImparLogic(); 

        try {
            String retornoJogo = _parOuImparLogic.ExecutaParOuImparComACpu(3, EParOuImpar.PAR);

            System.out.println(retornoJogo);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}