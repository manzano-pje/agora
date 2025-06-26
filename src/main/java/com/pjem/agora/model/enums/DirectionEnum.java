package com.pjem.agora.model.enums;

public enum DirectionEnum {
    PRESIDENTE(1),
    VICEPRESIDENTE(2),
    SECRETARIO1(3),
    SECRETARIO2(4),
    FINANCEIRO1(5),
    FINANCEIRO2(6),
    CONSELHOFISCAL1(7),
    CONSELHOFISCAL2(8),
    CONSELHOFISCAL3(9);

    private final int order;

    DirectionEnum(int order) {
        this.order = order;
    }

    public int getOrder(){
        return order;
    }
}
