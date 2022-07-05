package br.com.fuctura;

import br.com.fuctura.entity.Tecnico;
import br.com.fuctura.entity.Time;
import br.com.fuctura.repository.Repository;
import br.com.fuctura.repository.TecnicoRepository;
import br.com.fuctura.repository.TimeRepository;
import br.com.fuctura.util.JPAUtil;

public class TesteOneToOne {

	public static void main(String[] args) {
		JPAUtil.getFabrica();
		
		Tecnico t = new Tecnico();
		t.setNome("Marteloti");
		
		//TecnicoRepository tecnicoR = new TecnicoRepository();
		//tecnicoR.create(t);
		
		Time tt = new Time();
		tt.setNome("Profissional");
		tt.setTecnico(t);
		
		TimeRepository timeR = new TimeRepository();
		timeR.create(tt);
		
		
		
	}
	
}
