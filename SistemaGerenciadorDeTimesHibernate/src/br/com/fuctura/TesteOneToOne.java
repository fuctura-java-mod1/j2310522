package br.com.fuctura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.entity.Posicoes;
import br.com.fuctura.entity.Tecnico;
import br.com.fuctura.entity.Time;
import br.com.fuctura.repository.TimeRepository;
import br.com.fuctura.util.FileUtil;
import br.com.fuctura.util.JPAUtil;

public class TesteOneToOne {

	public static void main(String[] args) throws IOException {
		JPAUtil.getFabrica();
		
		Tecnico t = new Tecnico();
		t.setNome("Marteloti");
		
		//TecnicoRepository tecnicoR = new TecnicoRepository();
		//tecnicoR.create(t);
		
		Time tt = new Time();
		tt.setNome("Profissional");
		tt.setTecnico(t);
		
		Jogador j1 = new Jogador();
		j1.setNome("Messi");
		j1.setPosicao(Posicoes.ATAQUE);
		
		Jogador j2 = new Jogador();
		j2.setNome("Salah");
		j2.setPosicao(Posicoes.ATAQUE);
		
		
		byte[] imagem = FileUtil.carregarFoto("/home/ericmoraess/Desktop/Untitled Folder/cr7.jpg");
		
		Jogador j3 = new Jogador();
		j3.setNome("Magrão");
		j3.setPosicao(Posicoes.GOLEIRO);
		j3.setImagem(imagem);
		
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
		
		jogadores.add(j1);
		jogadores.add(j2);
		jogadores.add(j3);
		
		tt.setJogadores(jogadores);
		
		TimeRepository timeR = new TimeRepository();
		timeR.create(tt);
		
		List<Time> resultadoConsulta = timeR.findByNome("Profissional");
		
		Tecnico tec = resultadoConsulta.get(0).getTecnico();
		
		System.out.println("Nome do técnico: " + tec.getNome());
		
		
		List<Jogador> jogs = resultadoConsulta.get(0).getJogadores();
		
		for (Jogador jogador : jogs) {
			
			if( jogador.getImagem() != null ) {
				JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(jogador.getImagem())));
			}
		}
		
	}
	
}
