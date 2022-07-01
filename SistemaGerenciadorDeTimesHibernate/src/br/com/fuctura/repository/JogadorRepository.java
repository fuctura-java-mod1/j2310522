package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fuctura.dto.JogadorNomeAlturaDTO;
import br.com.fuctura.entity.Jogador;
import br.com.fuctura.util.JPAUtil;

public class JogadorRepository {
	
	public JogadorRepository() {}
	
	public void create(Jogador j) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		EntityTransaction tx = em.getTransaction();// inserir, excluir e atualizar
		// CREATE-INSERIR
		tx.begin(); // inicio da transacao
		em.persist(j); // vai inserir no banco de dados
		tx.commit();
		em.close();
	}

	public Jogador read(Jogador j) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();;
		//READ - CONSULTAR
		Jogador resultadoDaConsulta = em.find(Jogador.class, 1); //SEMPRE VAI EXCLUIR O MESMO
		return resultadoDaConsulta;
	}

	public void update(Jogador j) {
		EntityManager em = null;
		EntityTransaction tx = em.getTransaction();// inserir, excluir e atualizar
		// UPDATE
		tx.begin();
		em.merge(j);
		tx.commit();
	}

	public void delete(Jogador j) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		
		Jogador jogadorGerenciado = read(j);
		
		EntityTransaction tx = em.getTransaction();// inserir, excluir e atualizar
		// DELETE - Remover o registro
		tx.begin();
		em.remove(jogadorGerenciado);
		tx.commit();
	}
	
	//findBy = busque por -> padrao do Spring
	public List<Jogador> findByNome(String nomeParametro) {
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
	
		Query q = em.createNamedQuery("Andre");
		
		q.setParameter("parametro", nomeParametro);
		
		List<Jogador> resultaDaConsulta = q.getResultList();
		
		return resultaDaConsulta;
	}
	
	
	public List<Jogador> findByAltura(Double altura){
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		Query q = em.createQuery("SELECT j FROM Jogador where j.altura = :parametro");
		
		q.setParameter("parametro", altura);
		
		List<Jogador> resultadoDaConsulta = q.getResultList();
		
		return resultadoDaConsulta;
	}
	
	public List<Jogador> findByAltura(Double min, Double max){
		
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		TypedQuery<Jogador> q = em.
				createQuery(
						"SELECT j.altura FROM Jogador where j.altura >= :min and j.altura <= :max",
						Jogador.class
						);

		q.setParameter("min", min);
		q.setParameter("max", max);
		
		List<Jogador> resultadoDaConsulta = q.getResultList();

		return resultadoDaConsulta;
	}
	
	public List<Double> findByPeso(Double peso){
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		return em
				.createQuery("SELECT j.peso FROM Jogador where j.peso = :peso",Double.class)
				.setParameter("peso", peso)
				.getResultList();
	}
	
	public List<Object[]> findByNomeAndAltura(String nome, Double altura){
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		return em
				.createQuery("SELECT j.altura, j.nome FROM Jogador j where j.altura = :altura", Object[].class)
				.setParameter("altura", altura)
				.getResultList();
	}
	
	public List<JogadorNomeAlturaDTO> findByNomeAndAltura2(String nome, Double altura){
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		return em
				.createQuery("SELECT new br.com.fuctura.dto.JogadorNomeAlturaDTO(j.altura, j.nome) FROM Jogador j where j.altura = :altura", JogadorNomeAlturaDTO.class)
				.setParameter("altura", altura)
				.getResultList();
	}
	
	/*
	public List<Jogador> findByAltura(Double min, Double max){
	EntityManager em = JPAUtil.getFabrica().createEntityManager();
		return em.createQuery(
						"SELECT j FROM Jogador where j.altura >= :min and j.altura <= :max",
						Jogador.class
						)
		.setParameter("min", min)
		.setParameter("max", max)
		.getResultList();
	}
	*/
	
}