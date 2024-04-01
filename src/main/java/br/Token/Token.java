package br.Token;

import java.util.UUID;

public class Token {
    public static String gerarToken() {
        return UUID.randomUUID().toString();
    }
}
