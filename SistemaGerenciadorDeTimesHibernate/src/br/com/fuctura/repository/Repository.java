package br.com.fuctura.repository;

public interface Repository<T> {
	public void create(T t);
	public T read(T t);
	public void update(T t);
	public void delete(T t);
}
