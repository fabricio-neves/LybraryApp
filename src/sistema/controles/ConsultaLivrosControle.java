package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import sistema.dados.LivroDados;
import sistema.modelos.Livro;
import sistema.telas.TelaConsultaLivros;

/**
 * Classe responsável por adicionar comportamentos na tela e fazer sua lógica.
 * 
 * Faz uso de um ou mais objetos tela, que deve expor os principais componentes 
 * de tela.
 * 
 * Faz uso de um ou mais objetos dados, para recuperar informações nos cliques 
 * de botão, e oara atualizar a tela, etc.
 * 
 * Todas esses objetos que são dependencias para esse controle funcionar devem 
 * ser passados no construtor do objeto.
 * 
 * Esta classe controle deve lidar com telas, dados, modelos e outros controles,
 * para fazer efetivamente a "cola" desses componentes.
 * 
 * @author Emerson C. Lima
 *
 */
public class ConsultaLivrosControle {

	private TelaConsultaLivros tela;
	
	public ConsultaLivrosControle(TelaConsultaLivros tela, LivroDados dados) throws SQLException {		
		this.tela = tela;
		tela.getTable().setModel(new LivroTableModel(new ArrayList<>()));
		tela.getBtnPesquisar().addActionListener((ActionEvent e) -> {
			try {
				List<Livro> livros;
				if (tela.getTxtPesquisa().getText().trim().isEmpty()) {
					livros = dados.todos();
				} else {
					livros = dados.pesquisa_livros(tela.getTxtPesquisa().getText());
				}
				tela.getTable().setModel(new LivroTableModel(livros));
			} catch (Exception err) {				
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel acessar o banco de dados");
			}
		});
	}
	
	public void mostra() {
		this.tela.setVisible(true);
	}
}

/**
 * Classe responsável por mapear uma lista de livros nos valores das células do
 * JTable.
 * 
 * @author Emerson C. Lima
 */
class LivroTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Livro> livros;

	public LivroTableModel(List<Livro> livros) {
		this.livros = livros;
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0: return "Id";
			case 1: return "T�tulo";
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
			case 1: return a.getTitulo();
			default: return null;
		}
	}	
}