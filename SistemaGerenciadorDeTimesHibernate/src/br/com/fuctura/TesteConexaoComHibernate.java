package br.com.fuctura;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.swing.JTextArea;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.entity.Tecnico;

public class TesteConexaoComHibernate {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = null;
		EntityManager em = null;
		
		try {
			
			fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
			em = fabrica.createEntityManager();
			Metamodel meta  = em.getMetamodel();
			Set<EntityType<?>> entidades = meta.getEntities();
			entidades.forEach( e -> System.out.println(e.toString()) );
			
			Jogador j = new Jogador();
			j.setNome("Pelé");
			j.setAltura(1.89);
			
			Tecnico t1 = new Tecnico();
			t1.setCodigo(1);
			t1.setNome("Felipao");
			
			Tecnico t2 = new Tecnico();
			t2.setCodigo(1);
			t2.setNome("Zagalo");
			
			
			EntityTransaction tx = em.getTransaction();
			
			System.out.println("-- Início da transação --");
			tx.begin();
			
			em.persist(j);
			em.persist(t1);
			em.persist(t2);
			
			tx.commit();
			System.out.println("-- Fim da transação --");
			
			if(em.contains(j)) {
				System.out.println("Está gerenciando: " + j.toString());
			}else {
				System.out.println("Não está gerenciando: " + j.toString());
			}
			
		}finally {
			em.close();
			fabrica.close();
		}
	}
	
	public static void inserir(Jogador j) {
		
	}
	
}
