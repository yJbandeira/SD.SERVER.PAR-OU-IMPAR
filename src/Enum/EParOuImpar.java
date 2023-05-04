package Enum;

public enum EParOuImpar {
    PAR("par"),
    IMPAR("impar");

    private final String opcao;

    private EParOuImpar(String opcao) {
        this.opcao = opcao;
    }

    public String getOpcao() {
        return opcao;
    } 

}
