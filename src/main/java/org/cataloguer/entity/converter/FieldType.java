package org.cataloguer.entity.converter;


public enum FieldType {
    STRING("str"),
    INTEGER("int"),
    LONG("long"),
    BOOLEAN("bool"),
    DOUBLE("double");

    private final String code;

    FieldType(String code) {
        this.code = code;
    }

    public static FieldType fromCode(String code) {
        if (code == null) {
            throw new NullPointerException();
        }

        return switch (code) {
            case "str" -> STRING;
            case "int" -> INTEGER;
            case "long" -> LONG;
            case "bool" -> BOOLEAN;
            case "double" -> DOUBLE;
            default -> throw new IllegalArgumentException();
        };
    }

    public String getCode() {
        return code;
    }
}
