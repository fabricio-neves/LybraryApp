package sistema.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaConsultaEmprestimo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable tblLivros;
	private JButton btnPesquisar;
	private JTextField txtPesquisa;
	private JCheckBox cboxDevAtrasadas;
	private JRadioButton rbtnNome;
	private JRadioButton rbtnEmail;
	
	public TelaConsultaEmprestimo() {
		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Consulta Empréstimos");
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
		
		txtPesquisa = new JTextField();
		topo.add(txtPesquisa);
		topo.add(Box.createRigidArea(new Dimension(0, 10)));
		
		btnPesquisar = new JButton("Pesquisar");
		topo.add(btnPesquisar);
		
		JPanel meio = new JPanel();
		meio.setLayout(new BoxLayout(meio, BoxLayout.PAGE_AXIS));
		add(meio, BorderLayout.CENTER);
		/*
		JPanel filtros = new JPanel();
		filtros.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		meio.add(filtros);
		*/
		tblLivros = new JTable();
		meio.add(new JScrollPane(tblLivros));
	}

	public JTable getTable() {
		return tblLivros;
	}
	
	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}
	
	public JTextField getTxtPesquisa() {
		return txtPesquisa;
	}
	
	public JRadioButton getRbtnNome() {
		return rbtnNome;
	}
	
	public JRadioButton getRbtnEmail() {
		return rbtnEmail;
	}
	
	public JCheckBox getCboxDevAtrasadas() {
		return cboxDevAtrasadas;
	}
	
}
