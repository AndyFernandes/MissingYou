package br.ufc.missingyou.services;

public interface ServiceListener<T> {
    void onComplete(T t);
    void onError(String erro);
}
