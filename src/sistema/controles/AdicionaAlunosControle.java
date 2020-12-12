package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema.dados.AlunoDados;
import sistema.modelos.Aluno;
import sistema.telas.TelaAdicionaAlunos;


public class AdicionaAlunosControle {

	private TelaAdicionaAlunos tela;
	
	public AdicionaAlunosControle(TelaAdicionaAlunos tela, AlunoDados dados) throws SQLException {		
		this.tela = tela;
		tela.getTblAluno().setModel(new AlunoTableModel(new ArrayList<>()));
		try {
			List<Aluno> alunos;
			alunos = dados.todos();
			tela.getTblAluno().setModel(new AlunoTableModel(alunos));
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "Não foi possível acessar o banco de dados");
		}
		tela.getBtnAdicionar().addActionListener((ActionEvent e) -> {
			try {
				Aluno a = new Aluno();
				a.setNome(tela.getNome().getText());
				a.setEmail(tela.getEmail().getText());
				dados.insere(a);
				List<Aluno> alunosUpdated;
				alunosUpdated = dados.todos();
				tela.getTblAluno().setModel(new AlunoTableModel(alunosUpdated));
				JOptionPane.showMessageDialog(null, "O aluno "+ "''"+a.getNome()+"''"+" foi cadastrado com sucesso");
			} catch (SQLException err) {
				Aluno a = new Aluno();
				a.setNome(tela.getNome().getText());
				a.setEmail(tela.getEmail().getText());
				
				if(err.getMessage().contains("alunos_nome_key")) {
					JOptionPane.showMessageDialog(null, "O Nome "+"'"+a.getNome()+"' "+"ja foi cadastrado");
				}
				
				if(err.getMessage().contains("alunos_email_key")) {
					JOptionPane.showMessageDialog(null, "O email "+"'"+a.getEmail()+"' "+"ja foi cadastrado");
				}
			}
		});
	}
	
	public void mostra() {
		this.tela.setVisible(true);
	}
}

