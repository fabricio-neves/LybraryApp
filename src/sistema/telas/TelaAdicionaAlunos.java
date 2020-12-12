package sistema.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaAdicionaAlunos extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable tblAlunos;
	private JButton btnAdicionar;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblEmail;
	private JTextField txtEmail;
	

	public TelaAdicionaAlunos() {
		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Adicionar Alunos");
		setLocationRelativeTo(null);
		
		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		setLayout(layout);
		
		JPanel topo = new JPanel();		
		topo.setLayout(new BoxLayout(topo, BoxLayout.LINE_AXIS));
		add(topo, BorderLayout.NORTH);
		
		lblNome = new JLabel("Nome ");
		topo.add(lblNome);
		topo.add(Box.createRigidArea(new Dimension(0, 10)));
		
		txtNome = new JTextField();
		topo.add(txtNome);
		topo.add(Box.createRigidArea(new Dimension(0, 10)));
		
		btnAdicionar = new JButton("Adicionar");
		topo.add(btnAdicionar);
		
		JPanel meio = new JPanel();
		meio.setLayout(new BoxLayout(meio, BoxLayout.PAGE_AXIS));
		add(meio, BorderLayout.CENTER);
		
		JPanel email = new JPanel();
		email.setLayout(new BoxLayout(email, BoxLayout.LINE_AXIS));
		meio.add(email);
		
		lblEmail = new JLabel("Email ");
		email.add(lblEmail);
		email.add(Box.createRigidArea(new Dimension(0, 10)));
		
		txtEmail = new JTextField();
		email.add(txtEmail);
		email.add(Box.createRigidArea(new Dimension(0, 10)));
		
		tblAlunos = new JTable();
		meio.add(new JScrollPane(tblAlunos));
	}

	public JTable getTblAluno() {
		return tblAlunos;
	}
	
	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}
	
	public JTextField getNome() {
		return txtNome;
	}

	public JTextField getEmail() {
		return txtEmail;
	}
	
}
