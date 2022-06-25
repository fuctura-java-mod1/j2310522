package br.com.fuctura;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

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
		}finally {
			em.close();
			fabrica.close();
		}
	}
	
}
