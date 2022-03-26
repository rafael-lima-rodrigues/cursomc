package com.rafaelrodrigues.cursomc.domain.enums;

public enum CustomerType {
    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String description;

    private CustomerType(int cod, String description){
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerType toEnum(Integer cod){
        if (cod == null){
            return null;
        }
        for (CustomerType customerType : CustomerType.values()){
            if (cod.equals(customerType.getCod())){
                return customerType;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + cod);
    }
}
