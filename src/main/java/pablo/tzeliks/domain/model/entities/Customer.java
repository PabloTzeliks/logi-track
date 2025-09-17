package pablo.tzeliks.domain.model.entities;

import pablo.tzeliks.domain.model.vo.Cnpj;
import pablo.tzeliks.domain.model.vo.Cpf;

public class Customer {

    private long id;
    private String name;
    private Cpf cpf;
    private Cnpj cnpj;
    private String streetAddress;
    private String streetNumber;
    private String neighborhood;
    private String zipCode;
    private String addressComplement;
    private int cityId;


}
