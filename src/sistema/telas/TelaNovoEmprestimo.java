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



	public class TelaNovoEmprestimo extends JFrame {
	    private static final long serialVersionUID = 1L;
	    private JTextField Tnome;
	    private JTextField Tlivro;
	    private JButton cancelar;
	    private JButton emprestar;
	    private JLabel data;

	    public TelaNovoEmprestimo() {

	        JLabel nome = new JLabel(" Id Aluno :");
	        nome.setBounds(10, 11, 61, 29);
	        Tnome = new JTextField(30);
	        Tnome.setBounds(72, 11, 288, 29);

	        JLabel Livro = new JLabel("Id Livro :");
	        Livro.setBounds(10, 65, 52, 29);
	        Tlivro = new JTextField(30);
	        Tlivro.setBounds(72, 65, 288, 29);




	        cancelar = new JButton("cancelar");
	        emprestar = new JButton("emprestar");

	        JPanel p1 = new JPanel();

	        getContentPane().add(p1, BorderLayout.CENTER);

	        JPanel p2 = new JPanel();
	        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
	        getContentPane().add(p2, BorderLayout.SOUTH);

	        setTitle("Realizar Emprestimo");
	        setSize(420, 209);

	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        p1.setLayout(null);

	        // jlabel

	        p1.add(nome);
	        p1.add(Tnome);
	        p1.add(Livro);
	        p1.add(Tlivro);
	        
	        Calendar c1 = Calendar.getInstance(new Locale("pt-br"));
	       c1.add( Calendar.MONTH, 1 );
	       SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
	       
	       String a = s.format(c1.getTime());
	      
	;
	        
	        JLabel lblNewLabel = new JLabel("Data prevista para devolu\u00E7\u00E3o:");
	        lblNewLabel.setBounds(10, 112, 190, 14);
	        p1.add(lblNewLabel);
	        
	        data= new JLabel(a);
	        data.setBounds(190, 112, 142, 14);
	        p1.add(data);
	        // botoes

	        p2.add(cancelar);
	        p2.add(emprestar);




	    }

	    public JTextField getTlivro() {
	        return Tlivro;
	    }

	    public JTextField getTnome() {
	        return Tnome;
	    }



	    public void setData(JLabel data) {
			this.data = data;
		}

		public JButton getCancelar() {
	        return cancelar;
	    }

	    public JButton getSalvar() {
	        return emprestar;
	    }
	}