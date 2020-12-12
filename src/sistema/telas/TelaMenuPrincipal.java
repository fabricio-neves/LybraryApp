package sistema.telas;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Apenas uma tela Swing sem lÃ³gica e com os principais componentes disponÃ­veis 
 * via getters para que algum controlador adicione lÃ³gica.
 * 
 * Telas nÃ£o conhecem nenhum outro tipo do sistema.
 * 
 * @author Emerson C. Lima
 */
public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JMenuItem mnuSair;
	private JMenuItem mnuConsultarAlunos;
	private JMenuItem mnuCriarAlunos;
	private JMenuItem mnuConsultarLivros;
	private JMenuItem mnuAdicionarLivros;
	private JMenuItem mnuRealizarEmprestimo;
	private JMenuItem mnuRealizarDevolucao;
	private JMenuItem mnuConsultarEmprestimo;

	private JPanel panel;

	public TelaMenuPrincipal() {	
		setSize(514, 332);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Biblioteca");
		setLocationRelativeTo(null);
		JMenuBar menubar = new JMenuBar();
		JMenu mnuSistema = new JMenu("Sistema");
		menubar.add(mnuSistema);
		mnuSair = new JMenuItem("Sair");
		
		JMenu mnuAlunos = new JMenu("Alunos");
		menubar.add(mnuAlunos);
		mnuConsultarAlunos = new JMenuItem("Consultar Alunos");
		mnuAlunos.add(mnuConsultarAlunos);
		mnuCriarAlunos = new JMenuItem("Adicionar Alunos");
		mnuAlunos.add(mnuCriarAlunos);
		
		JMenu mnuLivros = new JMenu("Livros");
		menubar.add(mnuLivros);
		mnuConsultarLivros = new JMenuItem("Consultar Livros");
		mnuLivros.add(mnuConsultarLivros);
		mnuAdicionarLivros = new JMenuItem("Adicionar Livros");
		mnuLivros.add(mnuAdicionarLivros);
		
		JMenu mnuEmprestimo = new JMenu("Empréstimo");
		menubar.add(mnuEmprestimo);
		mnuRealizarEmprestimo = new JMenuItem("Realizar Empréstimos");
		mnuEmprestimo.add(mnuRealizarEmprestimo);
		mnuRealizarDevolucao = new JMenuItem("Realizar Devoluções");
		mnuEmprestimo.add(mnuRealizarDevolucao);
		mnuConsultarEmprestimo = new JMenuItem("Consultar Empréstimos");
		mnuEmprestimo.add(mnuConsultarEmprestimo);

		mnuSistema.add(mnuSair);
		setJMenuBar(menubar);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("fotos/editado.png"));
		JLabel imagem = new JLabel(icon);
		panel.add(imagem);
	}
		

	public JMenuItem getSair() { 
		return mnuSair;
	}

	public JMenuItem getConsultarAlunos() {
		return mnuConsultarAlunos;
	}
	
	public JMenuItem getConsultarLivros() {
		return mnuConsultarLivros;
	}
	
	public JMenuItem getAdicionarLivros() {
		return mnuAdicionarLivros;
	}


	public JMenuItem getNovoEmprestimo() {
		return mnuRealizarEmprestimo;
	}


	public JMenuItem getConsultarEmprestimo() {
		return mnuConsultarEmprestimo;
	}


	public JMenuItem getCriarAlunos() {
		return mnuCriarAlunos;
	}


	public JMenuItem getRealizarDevolucao() {
		return mnuRealizarDevolucao;
	}
	
	
	
}
