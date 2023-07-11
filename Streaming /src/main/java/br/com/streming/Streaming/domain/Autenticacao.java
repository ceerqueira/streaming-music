package br.com.streming.Streaming.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Autenticacao {

    private final String email;
    private final String senha;

}
