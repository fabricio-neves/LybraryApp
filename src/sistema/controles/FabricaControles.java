package sistema.controles;

import java.sql.SQLException;

import sistema.dados.FabricaDados;
import sistema.telas.FabricaTelas;

/**
 * Classe responsável por construir os controladores da aplicação, ou seja, 
 * instânciar e conectar as instâncias dos controladores com suas dependencias.
 *
 * Usa outras fábricas para adquirir instâncias das telas e 
 * instâncias de acesso aos dados.
 * 
 * 
 * Ela só pode interagir com controladores do próprio pacote ou outras fábricas.
 * 
 * @author Emerson C. Lima
 */
public class FabricaControles {

	private MenuPrincipalControle menuPrincipalControle;
	private ConsultaAlunosControle consultaAlunosControle;
	private AdicionaAlunosControle adicionaAlunosControle;
	private ConsultaLivrosControle consultaLivrosControle;
	private AdicionaLivrosControle adicionaLivrosControle;
	private ConsultarEmprestimoControle consultaEmprestimoControle;
	private AdicionaEmprestimoControle adicionarEmprestimoControle;
	private NovaEntregaControle novaEntregaControle;
	
	public FabricaControles(FabricaDados fabricaDados, FabricaTelas fabricaTelas) throws SQLException {
		this.consultaAlunosControle = new ConsultaAlunosControle(fabricaTelas.getTelaConsultaAlunos(), fabricaDados.getAlunoDados());
		this.adicionaAlunosControle = new AdicionaAlunosControle(fabricaTelas.getTelaAdicionaAlunos(), fabricaDados.getAlunoDados());
		this.consultaLivrosControle = new ConsultaLivrosControle(fabricaTelas.getTelaConsultaLivros(), fabricaDados.getLivroDados());
		this.adicionaLivrosControle = new AdicionaLivrosControle(fabricaTelas.getTelaAdicionaLivros(), fabricaDados.getLivroDados());
		this.consultaEmprestimoControle = new ConsultarEmprestimoControle(fabricaTelas.getTelaConsultarEmprestimo(),fabricaDados.getEmprestimoDados());
		this.adicionarEmprestimoControle = new AdicionaEmprestimoControle(fabricaTelas.getTelaNovoEmprestimo(),fabricaDados.getEmprestimoDados());
		this.novaEntregaControle = new NovaEntregaControle(fabricaTelas.getTelaNovaDevolucao(),fabricaDados.getEmprestimoDados());
		this.menuPrincipalControle = new MenuPrincipalControle(fabricaTelas.getTelaMenuPrincipal(), consultaAlunosControle, consultaLivrosControle, adicionaLivrosControle,consultaEmprestimoControle,adicionaAlunosControle,adicionarEmprestimoControle,novaEntregaControle);
		
	}
	
	
	public AdicionaEmprestimoControle getAdicionarEmprestimoControle() {
		return adicionarEmprestimoControle;
	}


	public AdicionaAlunosControle getAdicionaAlunosControle() {
		return adicionaAlunosControle;
	}


	public MenuPrincipalControle getControleMenuPrincipal() {
		return menuPrincipalControle;
	}

	public ConsultaAlunosControle getControleConsultaAluno() {
		return consultaAlunosControle;
	}

	public ConsultaLivrosControle getControleConsultaLivro() {
		return consultaLivrosControle;
	}


	public ConsultarEmprestimoControle getConsultaEmprestimoControle() {
		return consultaEmprestimoControle;
	}
	
}
