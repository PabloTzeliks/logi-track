package pablo.tzeliks.domain.model.entities;

import pablo.tzeliks.domain.model.vo.Address;
import pablo.tzeliks.domain.model.vo.Cnpj;
import pablo.tzeliks.domain.model.vo.Cpf;

public class Customer {

    private long id;
    private String name;
    private Cpf cpf;
    private Cnpj cnpj;
    private Address address;

    public Customer(long id, String name, Cpf cpf, Cnpj cnpj, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
    }

    public Customer(String name, Cpf cpf, Cnpj cnpj, Address address) {
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public Cnpj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}