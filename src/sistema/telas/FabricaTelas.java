package sistema.telas;


public class FabricaTelas {

	private TelaMenuPrincipal telaMenuPrincipal;
	private TelaConsultaAlunos telaConsultaAlunos;
	private TelaAdicionaAlunos telaAdicionaAlunos;
	private TelaConsultaLivros telaConsultaLivros;
	private TelaAdicionaLivros telaAdicionaLivros;
	private TelaNovoEmprestimo telaNovoEmprestimo;
	private TelaConsultaEmprestimo telaConsultarEmprestimo;
	private TelaNovadevolucao telaNovaDevolucao;
	
	public FabricaTelas() {
		telaMenuPrincipal = new TelaMenuPrincipal();
		telaConsultaAlunos = new TelaConsultaAlunos();
		telaAdicionaAlunos = new TelaAdicionaAlunos();
		telaConsultaLivros = new TelaConsultaLivros();
		telaAdicionaLivros = new TelaAdicionaLivros();
		telaNovoEmprestimo = new TelaNovoEmprestimo();
		telaConsultarEmprestimo = new TelaConsultaEmprestimo();
		telaNovaDevolucao = new TelaNovadevolucao();
	}
	
	public TelaMenuPrincipal getTelaMenuPrincipal() {
		return telaMenuPrincipal;
	}
	
	public TelaConsultaAlunos getTelaConsultaAlunos() {
		return telaConsultaAlunos;
	}
	
	public TelaAdicionaAlunos getTelaAdicionaAlunos() {
		return telaAdicionaAlunos;
	}

	public TelaConsultaLivros getTelaConsultaLivros() {
		return telaConsultaLivros;
	}
	
	public TelaAdicionaLivros getTelaAdicionaLivros() {
		return telaAdicionaLivros;
	}

	public TelaNovoEmprestimo getTelaNovoEmprestimo() {
		return telaNovoEmprestimo;
	}

	
	public TelaConsultaEmprestimo getTelaConsultarEmprestimo() {
		return telaConsultarEmprestimo;
	}

	public TelaNovadevolucao getTelaNovaDevolucao() {
		return telaNovaDevolucao;
	}
	
	
}
