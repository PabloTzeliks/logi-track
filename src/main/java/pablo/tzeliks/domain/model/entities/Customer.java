package pablo.tzeliks.domain.model.entities;

import pablo.tzeliks.domain.model.vo.Cnpj;
import pablo.tzeliks.domain.model.vo.Cpf;

public class Customer {

    private long id;
    private String nome;
    private Cpf cpf;
    private Cnpj cnpj;
    private String logradouro;
    private String numero;
    private String bairro;
    private String codigoCep;
    private String complemento;
    private int idCidade;

}
