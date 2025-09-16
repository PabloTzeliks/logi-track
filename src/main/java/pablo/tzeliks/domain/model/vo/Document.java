package pablo.tzeliks.domain.model.vo;

public interface Document {

    String getValor();
    String getValorFormatado();
    boolean validar(String valor);

}
