package br.com.fuctura.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fuctura.entity.Tecnico;
import br.com.fuctura.util.JPAUtil;

public class TecnicoRepositorio {
	
	public void create(Tecnico t) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		EntityTransaction tx = em.getTransaction();// inserir, excluir e atualizar
		// CREATE-INSERIR
		tx.begin(); // inicio da transacao
		em.persist(t); // vai inserir no banco de dados
		tx.commit();
		
		em.close();
	}
	
}
