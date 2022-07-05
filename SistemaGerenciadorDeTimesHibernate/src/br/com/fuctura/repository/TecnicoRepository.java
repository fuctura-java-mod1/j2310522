package br.com.fuctura.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fuctura.entity.Tecnico;
import br.com.fuctura.util.JPAUtil;

public class TecnicoRepository implements Repository<Tecnico> {
	
	public void create(Tecnico t) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		EntityTransaction tx = em.getTransaction();// inserir, excluir e atualizar
		// CREATE-INSERIR
		tx.begin(); // inicio da transacao
		em.persist(t); // vai inserir no banco de dados
		tx.commit();
		
		em.close();
	}

	@Override
	public Tecnico read(Tecnico t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tecnico t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tecnico t) {
		// TODO Auto-generated method stub
		
	}
	
}
