package Logic;

import java.util.Random;

import Enum.EParOuImpar;
import Interface.IParOuImparLogic;

public class ParOuImparLogic implements IParOuImparLogic {

    public String ExecutaParOuImparComACpu (int numeroEscolhido, EParOuImpar opcao) {
        int numeroGerado = GeraNumeroAleatorioDeZeroACinco();

        int soma = numeroEscolhido + numeroGerado;

        EParOuImpar resultadoJogo = EPar(soma);
        
        System.out.println(soma);
        if (opcao == resultadoJogo){
            return "Você VENCEU!";
        } 
        else {
            return "Você PERDEU!";
        }

    }

    private int GeraNumeroAleatorioDeZeroACinco() {
        int numberoGerado;
        Random gerador = new Random();

        numberoGerado = gerador.nextInt(5);

        return numberoGerado;
    }

    private EParOuImpar EPar(int soma) {
        if (soma == 0) {
            return EParOuImpar.PAR;
        }
        else if (soma % 2 == 0) {
            return EParOuImpar.PAR;
        }
        else {
            return EParOuImpar.IMPAR;
        }
    }

}
