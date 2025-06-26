package com.pjem.agora.model.enums;

public enum DirectionEnum {
    PRESIDENTE("Presidente",1),
    VICEPRESIDENTE("Vice Presidente",2),
    SECRETARIO1("1º Secretário",3),
    SECRETARIO2("2º Secretário",4),
    TESOUREIRO1("1º Tesoureiro",5),
    TESOUREIRO2("2º Tesoureiro",6),
    CONSELHOFISCAL1("1º Conselheiro Fiscal",7),
    CONSELHOFISCAL2("2º Conselheiro Fiscal",8),
    CONSELHOFISCAL3("3º Conselheiro Fiscal",9);

    private final String name;
    private final int order;

    DirectionEnum(String name, int order){
        this.name = name;
        this.order = order;
    }

    public String getLabel() {
        return name;
    }

    public int getOrder(){
        return order;
    }
}
