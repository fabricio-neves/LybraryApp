package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import sistema.dados.EmprestimoDados;
import sistema.modelos.Emprestimo;
import sistema.telas.TelaConsultaEmprestimo;

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
public class ConsultarEmprestimoControle {

	private TelaConsultaEmprestimo tela;
	
	public  ConsultarEmprestimoControle(TelaConsultaEmprestimo tela, EmprestimoDados dados) throws SQLException {		
				this.tela = tela;
			tela.getTable().setModel(new EmprestimoTableModel(new ArrayList<>()));
			tela.getBtnPesquisar().addActionListener((ActionEvent e) -> {
				try {
					List<Emprestimo> emprestimo;
					if (tela.getTxtPesquisa().getText().trim().isEmpty()) {
						emprestimo = dados.todos();
					} 
					else {
						emprestimo = dados.consultaNome(tela.getTxtPesquisa().getText());
					}
					tela.getTable().setModel(new EmprestimoTableModel(emprestimo));
				} catch (Exception err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
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
	class EmprestimoTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;
		private List<Emprestimo> emprestimo;

		public EmprestimoTableModel(List<Emprestimo> emprestimo) {
			this.emprestimo = emprestimo;
		}
		
		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
				case 0: return "aluno";
				case 1: return "livro";
				case 2: return "emprestimo";
				case 3: return "prevista";
				default: return null;
			}
		}
		
		@Override
		public int getRowCount() {
			return emprestimo.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {
			Emprestimo a = emprestimo.get(linha);
			switch (coluna) {
				case 0: return a.getNomeAluno();
				case 1: return a.getNomeLivro();
				case 2: return a.getDataEmprestimo();
				case 3: return a.getDataPrevDevulu��o();
				default: return null;
			}
		}	
	}