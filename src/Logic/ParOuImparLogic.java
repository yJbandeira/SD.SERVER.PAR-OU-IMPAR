package Logic;

import java.util.Random;

import Util.Enum.EParOuImpar;
import Util.Model.ResponseModel;

public class ParOuImparLogic {

    public ResponseModel ExecutaParOuImparComACpu(int numeroEscolhido, EParOuImpar opcao) {
        int numeroGerado = GeraNumeroAleatorioDeZeroACinco();

        int soma = numeroEscolhido + numeroGerado;

        EParOuImpar resultadoJogo = EPar(soma);

        String escolhaMaquina = opcao == EParOuImpar.IMPAR ? "Par" : "Impar";

        System.out.println(soma);
        if (opcao == resultadoJogo) {
            return new ResponseModel(numeroGerado, escolhaMaquina,
                    true);
        } else {
            return new ResponseModel(numeroGerado, escolhaMaquina,
                    false);
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
        } else if (soma % 2 == 0) {
            return EParOuImpar.PAR;
        } else {
            return EParOuImpar.IMPAR;
        }
    }

}
