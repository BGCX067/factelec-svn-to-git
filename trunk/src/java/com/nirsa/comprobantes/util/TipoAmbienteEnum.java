/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

/**
 *
 * @author Rolando
 */
public class TipoAmbienteEnum {

    public static TipoAmbienteEnum[] values() {
        return (TipoAmbienteEnum[]) $VALUES.clone();
    }

//    public static TipoAmbienteEnum valueOf(String name) {
//        return (TipoAmbienteEnum) Enum.valueOf(ec / gob / sri / comprobantes / util / TipoAmbienteEnum, name);
//    }

    private TipoAmbienteEnum(String s, int i, String code) {
//        super(s, i);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    public static final TipoAmbienteEnum PRODUCCION;
    public static final TipoAmbienteEnum PRUEBAS;
    private String code;
    private static final TipoAmbienteEnum $VALUES[];

    static {
        PRODUCCION = new TipoAmbienteEnum("PRODUCCION", 0, "2");
        PRUEBAS = new TipoAmbienteEnum("PRUEBAS", 1, "1");
        $VALUES = (new TipoAmbienteEnum[]{
                    PRODUCCION, PRUEBAS
                });
    }
}
