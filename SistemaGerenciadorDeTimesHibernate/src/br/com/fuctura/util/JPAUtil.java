package br.com.fuctura.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Singleton 
public class JPAUtil {

	private static EntityManagerFactory fabrica = null;

	public static EntityManagerFactory getFabrica() {
		System.out.println("Fazendo a leitura do XML");
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
		}

		return fabrica;
	}
	
	public static void closeFabrica() {
		fabrica.close();;
	}
	
}
