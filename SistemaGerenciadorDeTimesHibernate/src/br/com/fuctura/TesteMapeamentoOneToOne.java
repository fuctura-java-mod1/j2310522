package br.com.fuctura;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.entity.Time;
import br.com.fuctura.repository.JogadorRepository;
import br.com.fuctura.repository.TimeRepository;
import br.com.fuctura.util.FileUtil;
import br.com.fuctura.util.JPAUtil;

public class TesteMapeamentoOneToOne {

	public static void main(String[] args) throws IOException {
		JPAUtil.getFabrica();

		JogadorRepository jogadorRepo = new JogadorRepository();
		TimeRepository timeRepo = new TimeRepository();

		byte[] bytesImage = FileUtil.carregarFoto("/home/ericmoraess/Desktop/Untitled Folder/cr7.jpg");
		
		
		Jogador j = new Jogador(1.90, 90.0, "Cafú");

		// jogadorRepo.create(j);

		List<Jogador> jogadores = new ArrayList<Jogador>();

		jogadores.add(j);

		Time selecao = new Time("Seleção Brasileira");

//		selecao.setJogadores(jogadores);

		timeRepo.create(selecao);

		List<Time> selecoes = timeRepo.findByNome("Seleção Brasileira");
		
//		selecao.getJogadores().forEach(xk -> System.out.println("Jogador: " + xk));
		
		boolean isExibirFoto = false;
		if(isExibirFoto) {
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon()));
		}
		
		
	}
}
