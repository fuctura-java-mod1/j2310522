package br.com.fuctura.repository;

public interface JPARepositorio <T> {
	void create(T t);
	void read(T t, Integer id);
	void update(T t);
	void delete(T t);
}
