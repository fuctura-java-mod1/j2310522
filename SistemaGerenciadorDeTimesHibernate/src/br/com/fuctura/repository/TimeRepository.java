package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.fuctura.entity.Time;
import br.com.fuctura.util.JPAUtil;

public class TimeRepository implements Repository<Time> {

	public void create(Time t) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		EntityTransaction tx = em.getTransaction();// inserir, excluir e atualizar
		// CREATE-INSERIR
		tx.begin(); // inicio da transacao
		em.persist(t); // vai inserir no banco de dados
		tx.commit();
		em.close();
	}

	@Override
	public Time read(Time t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Time t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Time t) {
		// TODO Auto-generated method stub
		
	}

	// findBy = busque por -> padrao do Spring
		public List<Time> findByNome(String nome) {
			EntityManager em = JPAUtil.getFabrica().createEntityManager();

			Query q = em.createQuery("SELECT t FROM Time t where t.nome like :nome", Time.class);

			q.setParameter("nome", nome);

			List<Time> resultaDaConsulta = q.getResultList();

			return resultaDaConsulta;
		}
	
}
