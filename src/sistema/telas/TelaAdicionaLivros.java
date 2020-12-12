package sistema.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaAdicionaLivros extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable tblLivros;
	private JButton btnAdicionar;
	private JTextField txtNome;
	private JCheckBox cboxDevAtrasadas;
	private JRadioButton rbtnNome;
	private JLabel lblNome;

	public TelaAdicionaLivros() {
		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Adicionar Livros");
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
		
		tblLivros = new JTable();
		meio.add(new JScrollPane(tblLivros));
	}

	public JTable getTable() {
		return tblLivros;
	}
	
	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}
	
	public JTextField getTxtPesquisa() {
		return txtNome;
	}
	
	public JRadioButton getRbtnNome() {
		return rbtnNome;
	}
		
	public JCheckBox getCboxDevAtrasadas() {
		return cboxDevAtrasadas;
	}
	
}
