package sistema.modelos;

import java.util.Date;

public class Emprestimo {
	private String nomeAluno;
	private String nomeLivro;
	private Date dataEmprestimo;
	private Date dataPrevDevulu��o;
	private Date dataDevulu��o;
	
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataPrevDevulu��o() {
		return dataPrevDevulu��o;
	}
	public void setDataPrevDevulu��o(Date dataPrevDevulu��o) {
		this.dataPrevDevulu��o = dataPrevDevulu��o;
	}
	public Date getDataDevulu��o() {
		return dataDevulu��o;
	}
	public void setDataDevulu��o(Date dataDevulu��o) {
		this.dataDevulu��o = dataDevulu��o;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevulu��o == null) ? 0 : dataDevulu��o.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dataPrevDevulu��o == null) ? 0 : dataPrevDevulu��o.hashCode());
		result = prime * result + ((nomeAluno == null) ? 0 : nomeAluno.hashCode());
		result = prime * result + ((nomeLivro == null) ? 0 : nomeLivro.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataDevulu��o == null) {
			if (other.dataDevulu��o != null)
				return false;
		} else if (!dataDevulu��o.equals(other.dataDevulu��o))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (dataPrevDevulu��o == null) {
			if (other.dataPrevDevulu��o != null)
				return false;
		} else if (!dataPrevDevulu��o.equals(other.dataPrevDevulu��o))
			return false;
		if (nomeAluno == null) {
			if (other.nomeAluno != null)
				return false;
		} else if (!nomeAluno.equals(other.nomeAluno))
			return false;
		if (nomeLivro == null) {
			if (other.nomeLivro != null)
				return false;
		} else if (!nomeLivro.equals(other.nomeLivro))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Emprestimo [idLivro=" + nomeLivro + ", idAluno=" + nomeAluno + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataPrevDevulu��o=" + dataPrevDevulu��o + ", dataDevulu��o=" + dataDevulu��o + "]";
	}

	



			
		
	
	
	
}
