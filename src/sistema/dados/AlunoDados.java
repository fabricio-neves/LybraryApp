package sistema.dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Aluno;

public class AlunoDados {

	private Connection conexao;

	public AlunoDados(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Aluno> todos() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	
	public List<Aluno> buscaPorNome(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("Select * from alunos where UPPER(nome) like UPPER('%" + textoPesquisa + "%') ");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}

	public List<Aluno> buscaPorEmail(String email) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("Select * from alunos where LOWER(email) like LOWER('%" + email + "%')");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}

	public List<Aluno> buscaPorNomeEmail(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("Select * from alunos where LOWER(nome) like LOWER('%" + textoPesquisa + "%') OR LOWER(email) like LOWER ('%" + textoPesquisa + "%')");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	
	
	public void insere(Aluno a) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("INSERT INTO \"public\".\"alunos\" (\"nome\", \"email\") VALUES ('" + a.getNome() +  "','" + a.getEmail() +  "');");
	}

	public List<Aluno> buscaPorPendente() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos inner join emprestimos on emprestimos.aluno=alunos.id  where data_prevista_devolucao < current_date");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	
	public List<Aluno> buscaPorPendenteNome(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos inner join emprestimos on emprestimos.aluno=alunos.id  where data_prevista_devolucao < current_date and  lower (alunos.nome) like lower('%"+textoPesquisa+"%')");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	
	public List<Aluno> buscaPorPendenteEmail(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos inner join emprestimos on emprestimos.aluno=alunos.id  where data_prevista_devolucao < current_date and  lower (alunos.email) like lower('%"+textoPesquisa+"%')");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	public List<Aluno> buscaPorPendenteNomeEmail(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM alunos inner join emprestimos on emprestimos.aluno=alunos.id  where data_prevista_devolucao < current_date and  (lower (alunos.email) like lower('%"+textoPesquisa+"%') or lower(alunos.nome)like lower('%"+textoPesquisa+"%')) ");
		ResultSet rs = stmt.getResultSet();
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno();
			a.setId(rs.getLong(1));
			a.setNome(rs.getString(2));
			a.setEmail(rs.getString(3));
			alunos.add(a);
		}
		return alunos;
	}
	
	
}
