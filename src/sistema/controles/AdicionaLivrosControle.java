package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema.dados.LivroDados;
import sistema.modelos.Livro;
import sistema.telas.TelaAdicionaLivros;


public class AdicionaLivrosControle {

	private TelaAdicionaLivros tela;
	
	public AdicionaLivrosControle(TelaAdicionaLivros tela, LivroDados dados) throws SQLException {		
		this.tela = tela;
		tela.getTable().setModel(new LivroTableModel(new ArrayList<>()));
		try {
			List<Livro> livros;
			livros = dados.todos();
			tela.getTable().setModel(new LivroTableModel(livros));
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "N„o foi possÌvel acessar o banco de dados");
		}
		tela.getBtnAdicionar().addActionListener((ActionEvent e) -> {
			try {
				Livro a = new Livro();
				a.setTitulo(tela.getTxtPesquisa().getText());
				dados.insere(a);
				List<Livro> livrosUpdated;
				livrosUpdated = dados.todos();
				tela.getTable().setModel(new LivroTableModel(livrosUpdated));
				JOptionPane.showMessageDialog(null,"O livro " +"''"+ a.getTitulo()+"''"+" foi adicionado com sucesso");
			} catch (Exception err) {
				Livro a = new Livro();
				a.setTitulo(tela.getTxtPesquisa().getText());
				
				JOptionPane.showMessageDialog(null, "O livro " +"''"+ a.getTitulo()+"''"+" ja foi cadastrado");
			}
		});
	}
	
	public void mostra() {
		this.tela.setVisible(true);
	}
}

/**
 * Classe respons√°vel por mapear uma lista de livros nos valores das c√©lulas do
 * JTable.
 * 
 * @author Emerson C. Lima
 */

/* 
	class LivroTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Livro> livros;

	public LivroTableModel(List<Livro> livros) {
		this.livros = livros;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Id";
			case 1: return "Nome";
			case 2: return "Email";
			default: return null;
		}
	}
	
	@Override
	public int getRowCount() {
		return livros.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Livro a = livros.get(linha);
		switch (coluna) {
			case 0: return a.getId();
			case 1: return a.getNome();
			default: return null;
		}
	}	
}
*/