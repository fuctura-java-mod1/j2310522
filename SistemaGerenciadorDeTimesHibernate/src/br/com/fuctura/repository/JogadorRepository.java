package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
	
	public List<Jogador> findByNome(String nome){
		EntityManager em = JPAUtil.getFabrica().createEntityManager();
		
		TypedQuery<Jogador> consulta = em.createQuery("from Jogador where nome like :nome", Jogador.class);
		consulta.setParameter("nome", nome);
		
		List<Jogador> resultadoConsulta = consulta.getResultList();
		
		return resultadoConsulta;
	}
	
}