package com.api.projetoFinal.domain.enums;

public enum Categoria {
    

    HARDWARE(0), SOFTWARE(1), AMBOS(2);

    private Integer codigo;

    private Categoria(Integer codigo){
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static Categoria toEnum(Integer cod){

        if(cod == null){
            return null;
        }

        for(Categoria x : Categoria.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Categoria não existente");
    }
}
