package sistema.dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Livro;

public class LivroDados {

	private Connection conexao;

	public LivroDados(Connection conexao) {
		this.conexao = conexao;
	}
		
	public List<Livro> todos() throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM livros");
		ResultSet rs = stmt.getResultSet();
		List<Livro> livros = new ArrayList<>();
		while (rs.next()) {
			Livro a = new Livro();
			a.setId(rs.getLong(1));
			a.setTitulo(rs.getString(2));
			livros.add(a);
		}
		return livros;
	}

	public Livro pegaPorId(long id) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public void insere(Livro a) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("INSERT INTO livros(nome) VALUES ('" + a.getTitulo() + "')");
	}

	public void atualiza(Livro a) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public void apaga(Livro a) throws SQLException {
		throw new UnsupportedOperationException("Não implementado ainda!");
	}

	public List<Livro> pesquisa_livros(String textoPesquisa) throws SQLException {
		Statement stmt = conexao.createStatement();
		stmt.execute("SELECT * FROM livros where Nome like '%" + textoPesquisa + "%'");
		ResultSet rs = stmt.getResultSet();
		List<Livro> livros = new ArrayList<>();
		while (rs.next()) {
			Livro a = new Livro();
			a.setId(rs.getLong(1));
			a.setTitulo(rs.getString(2));
			livros.add(a);
		}
		return livros;
	}
	
}
