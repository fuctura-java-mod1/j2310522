package fuctura.repository;

import java.sql.Connection;

import fuctura.model.Entidade;

public interface IRepository {
	void inserir(Connection c, Entidade e);
}