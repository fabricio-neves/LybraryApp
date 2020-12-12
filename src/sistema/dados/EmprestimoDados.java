package sistema.dados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Emprestimo;

public class EmprestimoDados {
	private Connection conexao;

	public EmprestimoDados(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Emprestimo> todos() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT alunos.nome, livros.nome, data_emprestimo, data_prevista_devolucao"
				+ " FROM emprestimos, alunos, livros "
				+ "WHERE alunos.id = emprestimos.aluno AND livros.id = emprestimos.livro;");
		ResultSet rs = stmt.getResultSet();
		List<Emprestimo> alunos = new ArrayList<>();
		while (rs.next()) {
			Emprestimo a = new Emprestimo();
			a.setNomeAluno(rs.getString(1));
			a.setNomeLivro(rs.getString(2));
			a.setDataEmprestimo(rs.getDate(3));
			a.setDataPrevDevulução(rs.getDate(4));
			alunos.add(a);
			
		}
		return alunos;
	}
	
	public List<Emprestimo> consultaNome(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT alunos.nome, livros.nome, data_emprestimo, data_prevista_devolucao "
				+ "FROM emprestimos, alunos, livros "
				+ "WHERE alunos.id = emprestimos.aluno "
				+ "AND livros.id = emprestimos.livro "
				+ "AND UPPER(alunos.nome) like UPPER('%" + textoPesquisa + "%') ;");
		ResultSet rs = stmt.getResultSet();
		List<Emprestimo> alunos = new ArrayList<>();
		while (rs.next()) {
			Emprestimo a = new Emprestimo();
			a.setNomeAluno(rs.getString(1));
			a.setNomeLivro(rs.getString(2));
			a.setDataEmprestimo(rs.getDate(3));
			a.setDataPrevDevulução(rs.getDate(4));
			alunos.add(a);
		}
		return alunos;
	}
	
	public void insere(String idAluno,String idLivro,Date data_prev) throws SQLException {
		int inteira = Integer.parseInt(idAluno);
        int livro = Integer.parseInt(idLivro);
        Statement stmt = conexao.createStatement();
        stmt.execute("insert into emprestimos ( aluno, livro, data_emprestimo, data_prevista_devolucao)  values(" + inteira +", " + livro + ", current_date , current_date +30) ; ");
	}
	public void remove(String idAluno,String idLivro) throws SQLException {
		int aluno = Integer.parseInt(idAluno);
        int livro = Integer.parseInt(idLivro);
        Statement stmt = conexao.createStatement();
        stmt.execute("delete from emprestimos where emprestimos.aluno = "+aluno+" and emprestimos.livro = "+livro+"");
        
	}
}
