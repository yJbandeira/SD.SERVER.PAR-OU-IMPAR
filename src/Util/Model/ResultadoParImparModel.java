package Util.Model;

import java.io.Serializable;

import Util.Enum.EParOuImpar;

public class ResultadoParImparModel implements Serializable {
    private EParOuImpar opcaoP1, opcaoP2;
    private int vencedor;
    private boolean houveTroca;

    public ResultadoParImparModel(EParOuImpar opcaoP1, EParOuImpar opcaoP2, int vencedor, boolean houveTroca) {
        this.opcaoP1 = opcaoP1;
        this.opcaoP2 = opcaoP2;
        this.vencedor = vencedor;
        this.houveTroca = houveTroca;
    }

    public EParOuImpar getOpcaoP1() {
        return opcaoP1;
    }

    public EParOuImpar getOpcaoP2() {
        return opcaoP2;
    }

    public int getVencedor() {
        return vencedor;
    }

    public boolean getHouveTroca() {
        return houveTroca;
    }
}
