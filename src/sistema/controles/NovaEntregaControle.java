package sistema.controles;

import java.awt.event.ActionEvent;
import java.sql.SQLException;


import javax.swing.JOptionPane;

import sistema.dados.EmprestimoDados;

import sistema.telas.TelaNovadevolucao;



public class NovaEntregaControle {

	private TelaNovadevolucao tela;
	
	public NovaEntregaControle(TelaNovadevolucao tela, EmprestimoDados dados) throws SQLException {		
		this.tela = tela;
		
		  tela.getSalvar().addActionListener((ActionEvent e)-> {
              String idnome = tela.getTnome().getText();
              String idlivro = tela.getTlivro().getText();
        

              try {
                  dados.remove(idnome, idlivro);
                  JOptionPane.showMessageDialog(null, "devolução realizada com sucesso", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);
              } catch (SQLException e1) {
            	  
                  JOptionPane.showMessageDialog(null, "Não foi possível acessar o banco de dados", "Opa!", JOptionPane.INFORMATION_MESSAGE, null);

                  e1.printStackTrace();
              }
              
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

