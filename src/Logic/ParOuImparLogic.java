package Logic;

import java.util.Random;

import Util.Enum.EParOuImpar;
import Util.Model.ResponseModel;
import Util.Model.ResultadoParImparModel;

public class ParOuImparLogic {

    public ResponseModel ExecutaParOuImparComACpu(int numeroEscolhido, EParOuImpar opcao) {
        int numeroGerado = GeraNumeroAleatorioDeZeroACinco();

        int soma = numeroEscolhido + numeroGerado;

        EParOuImpar resultadoJogo = EPar(soma);

        String escolhaMaquina = opcao.toString(); //== EParOuImpar.IMPAR ? "Par" : "Impar";

        if (opcao == resultadoJogo) {
            return new ResponseModel(numeroGerado, escolhaMaquina,
                    true);
        } else {
            return new ResponseModel(numeroGerado, escolhaMaquina,
                    false);
        }
    }

    public ResultadoParImparModel ExecutaParOuImparPvP(int numPlayer1, EParOuImpar opcaoPlayer1, int numPlayer2,
            EParOuImpar opcaoPlayer2) {
        int soma = numPlayer1 + numPlayer2;
        int vencedor;
        boolean houveTroca = false;

        EParOuImpar resultadoJogo = EPar(soma);

        if (opcaoPlayer1 == opcaoPlayer2) {
            opcaoPlayer2 = opcaoPlayer1 == EParOuImpar.IMPAR ? EParOuImpar.PAR : EParOuImpar.IMPAR;
            houveTroca = true;
        }

        if (opcaoPlayer1 == resultadoJogo) {
            vencedor = 1;
        } else {
            vencedor = 2;
        }

        return new ResultadoParImparModel(opcaoPlayer1, opcaoPlayer2, vencedor, houveTroca);

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
