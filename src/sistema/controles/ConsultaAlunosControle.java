package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import sistema.dados.AlunoDados;
import sistema.modelos.Aluno;
import sistema.telas.TelaConsultaAlunos;

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
public class ConsultaAlunosControle {

	private TelaConsultaAlunos tela;
	
	public ConsultaAlunosControle(TelaConsultaAlunos tela, AlunoDados dados) throws SQLException {		
		this.tela = tela;
		tela.getTable().setModel(new AlunoTableModel(new ArrayList<>()));
				
		tela.getBtnPesquisar().addActionListener((ActionEvent e) -> {
			try {
				List<Aluno> alunos;
				if (tela.getTxtPesquisa().getText().trim().isEmpty() && !tela.getCboxDevAtrasadas().isSelected()) {
					alunos = dados.todos();
					tela.getTable().setModel(new AlunoTableModel(alunos));
				} else { 
					if(tela.getCboxNome().isSelected() && tela.getCboxEmail().isSelected() && !tela.getCboxDevAtrasadas().isSelected()) {
					alunos = dados.buscaPorNomeEmail(tela.getTxtPesquisa().getText());
					tela.getTable().setModel(new AlunoTableModel(alunos));
					} else {
						if(tela.getCboxNome().isSelected()&& !tela.getCboxDevAtrasadas().isSelected() && !tela.getCboxEmail().isSelected() ){
						alunos = dados.buscaPorNome(tela.getTxtPesquisa().getText());
						tela.getTable().setModel(new AlunoTableModel(alunos));
					} else {
						if(tela.getCboxEmail().isSelected()&& !tela.getCboxDevAtrasadas().isSelected()&& !tela.getCboxNome().isSelected()) {
							alunos = dados.buscaPorEmail(tela.getTxtPesquisa().getText());
							tela.getTable().setModel(new AlunoTableModel(alunos));
						}
						else {
							if(tela.getCboxDevAtrasadas().isSelected()&& !tela.getCboxNome().isSelected()&& !tela.getCboxEmail().isSelected()) {
								alunos = dados.buscaPorPendente();
								tela.getTable().setModel(new AlunoTableModel(alunos));
							} else {
								
								if(tela.getCboxDevAtrasadas().isSelected() && tela.getCboxNome().isSelected()&& !tela.getCboxEmail().isSelected()) {
									
									alunos = dados.buscaPorPendenteNome(tela.getTxtPesquisa().getText());
									tela.getTable().setModel(new AlunoTableModel(alunos));
								}else {
									
									if(tela.getCboxDevAtrasadas().isSelected() && tela.getCboxEmail().isSelected() && !tela.getCboxNome().isSelected()) {
										
										alunos = dados.buscaPorPendenteEmail(tela.getTxtPesquisa().getText());
										tela.getTable().setModel(new AlunoTableModel(alunos));
									}else {
										
										if(tela.getCboxDevAtrasadas().isSelected() && tela.getCboxEmail().isSelected() && tela.getCboxNome().isSelected()) {
											
											alunos = dados.buscaPorPendenteNomeEmail(tela.getTxtPesquisa().getText());
											tela.getTable().setModel(new AlunoTableModel(alunos));
										}
								
								}
								
								
								
							}
							}
							
					}
				}
					}
			}	
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
 * Classe responsável por mapear uma lista de alunos nos valores das células do
 * JTable.
 * 
 * @author Emerson C. Lima
 */
class AlunoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Aluno> alunos;

	public AlunoTableModel(List<Aluno> alunos) {
		this.alunos = alunos;
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
		return alunos.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Aluno a = alunos.get(linha);
		switch (coluna) {
			case 0: return a.getId();
			case 1: return a.getNome();
			case 2: return a.getEmail();
			default: return null;
		}
	}	
}