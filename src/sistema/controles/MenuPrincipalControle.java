package sistema.controles;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import sistema.telas.TelaMenuPrincipal;

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
public class MenuPrincipalControle {

	TelaMenuPrincipal tela;
	
	public MenuPrincipalControle(TelaMenuPrincipal tela, ConsultaAlunosControle consultaAlunosControle, ConsultaLivrosControle consultaLivrosControle, AdicionaLivrosControle adicionaLivrosControle,ConsultarEmprestimoControle cosultarEmprestimoControle,AdicionaAlunosControle adicionarAlunosControle,AdicionaEmprestimoControle adicionaEmprestimoControle,NovaEntregaControle novaEntregaControle) {		
		this.tela = tela;
		
		this.tela.getSair().addActionListener((ActionEvent e) -> {
			for (Frame f: Frame.getFrames()) {
				f.dispose();
			}
		});
		
		this.tela.getConsultarAlunos().addActionListener((ActionEvent e) -> {
			consultaAlunosControle.mostra();
		});
		
		this.tela.getConsultarLivros().addActionListener((ActionEvent e) -> {
			consultaLivrosControle.mostra();
		});
		this.tela.getAdicionarLivros().addActionListener((ActionEvent e) -> {
			adicionaLivrosControle.mostra();
		});
		this.tela.getConsultarEmprestimo().addActionListener((ActionEvent e) -> {
			cosultarEmprestimoControle.mostra();
		});
		
		this.tela.getCriarAlunos().addActionListener((ActionEvent e) -> {
			adicionarAlunosControle.mostra();
		});
		
		this.tela.getNovoEmprestimo().addActionListener((ActionEvent e) -> {
			adicionaEmprestimoControle.mostra();
		});
		this.tela.getRealizarDevolucao().addActionListener((ActionEvent e) -> {
			novaEntregaControle.mostra();
		});
		
		
		
	}
	
	public void mostra() {
		this.tela.setVisible(true);		
	}
	
}
