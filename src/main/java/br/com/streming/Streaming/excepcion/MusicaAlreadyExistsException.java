package br.com.streming.Streaming.excepcion;


public class MusicaAlreadyExistsException extends RuntimeException {
    public MusicaAlreadyExistsException(String message) {
        super(message);
    }
}


