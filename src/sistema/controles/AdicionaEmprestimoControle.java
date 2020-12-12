package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import sistema.dados.EmprestimoDados;
import sistema.telas.TelaNovoEmprestimo;


public class AdicionaEmprestimoControle {

	private TelaNovoEmprestimo tela;
	
	public AdicionaEmprestimoControle(TelaNovoEmprestimo tela, EmprestimoDados dados) throws SQLException {		
		this.tela = tela;
		
		try {
			dados.todos();
			
		} catch (Exception err) {
			JOptionPane.showMessageDialog(null, "Não foi possível acessar o banco de dados");
		}
		  tela.getSalvar().addActionListener((ActionEvent e)-> {
              String idnome = tela.getTnome().getText();
              String idlivro = tela.getTlivro().getText();
              long longo = System.currentTimeMillis();
              Date dataprevdev = new Date(longo);
              Calendar calendario = Calendar.getInstance();
              calendario.setTime(dataprevdev);
              calendario.add(Calendar.DATE, 30);
              dataprevdev = calendario.getTime();

              try {
                  dados.insere(idnome, idlivro, new java.sql.Date(dataprevdev.getTime()));
              } catch (SQLException e1) {
                  JOptionPane.showMessageDialog(null, "Não foi possível acessar o banco de dados", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);

                  e1.printStackTrace();
              }
              JOptionPane.showMessageDialog(null, "Emprestimo realizado com Sucesso!", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);
          });
		  
		  tela.getCancelar().addActionListener((ActionEvent e)-> {
			  if(e.getSource()== tela.getCancelar()) {
				  tela.dispose();
			  }
			  
		  });

	}
	
	public void mostra() {
		this.tela.setVisible(true);
	}
}

