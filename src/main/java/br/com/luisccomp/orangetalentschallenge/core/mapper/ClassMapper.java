package br.com.luisccomp.orangetalentschallenge.core.mapper;

public interface ClassMapper {

    <T, U> U map(T object, Class<U> target);

}
