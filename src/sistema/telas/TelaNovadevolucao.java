package sistema.telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



	public class TelaNovadevolucao extends JFrame {
	    private static final long serialVersionUID = 1L;
	    private JTextField Tnome;
	    private JTextField Tlivro;
	    private JButton cancelar;
	    private JButton emprestar;

	    public TelaNovadevolucao() {

	        JLabel nome = new JLabel(" Id Aluno :");
	        nome.setBounds(10, 33, 70, 29);
	        Tnome = new JTextField(30);
	        Tnome.setBounds(90, 33, 258, 29);

	        JLabel Livro = new JLabel("Id Livro :");
	        Livro.setBounds(10, 75, 70, 29);
	        Tlivro = new JTextField(30);
	        Tlivro.setBounds(90, 75, 258, 29);




	        cancelar = new JButton("cancelar");
	        emprestar = new JButton("devolver");

	        JPanel p1 = new JPanel();

	        getContentPane().add(p1, BorderLayout.CENTER);

	        JPanel p2 = new JPanel();
	        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
	        getContentPane().add(p2, BorderLayout.SOUTH);

	        setTitle("Realizar devolução");
	        setSize(420, 234);

	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        p1.setLayout(null);

	        

	        p1.add(nome);
	        p1.add(Tnome);
	        p1.add(Livro);
	        p1.add(Tlivro);
	        
	        JLabel lblNewLabel = new JLabel("Data atual :");
	        lblNewLabel.setBounds(10, 126, 65, 14);
	        p1.add(lblNewLabel);
	        
	        Calendar c1 = Calendar.getInstance(new Locale("pt-br"));
		    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		    String a = s.format(c1.getTime());
		       
	        JLabel lblNewLabel_1 = new JLabel(a);
	        lblNewLabel_1.setBounds(90, 126, 140, 14);
	        p1.add(lblNewLabel_1);
	        

	        p2.add(cancelar);
	        p2.add(emprestar);




	    }

	    public JTextField getTlivro() {
	        return Tlivro;
	    }

	    public JTextField getTnome() {
	        return Tnome;
	    }



	    public JButton getCancelar() {
	        return cancelar;
	    }

	    public JButton getSalvar() {
	        return emprestar;
	    }
	}