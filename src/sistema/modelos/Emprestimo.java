package sistema.modelos;

import java.util.Date;

public class Emprestimo {
	private String nomeAluno;
	private String nomeLivro;
	private Date dataEmprestimo;
	private Date dataPrevDevulução;
	private Date dataDevulução;
	
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
	public Date getDataPrevDevulução() {
		return dataPrevDevulução;
	}
	public void setDataPrevDevulução(Date dataPrevDevulução) {
		this.dataPrevDevulução = dataPrevDevulução;
	}
	public Date getDataDevulução() {
		return dataDevulução;
	}
	public void setDataDevulução(Date dataDevulução) {
		this.dataDevulução = dataDevulução;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevulução == null) ? 0 : dataDevulução.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dataPrevDevulução == null) ? 0 : dataPrevDevulução.hashCode());
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
		if (dataDevulução == null) {
			if (other.dataDevulução != null)
				return false;
		} else if (!dataDevulução.equals(other.dataDevulução))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (dataPrevDevulução == null) {
			if (other.dataPrevDevulução != null)
				return false;
		} else if (!dataPrevDevulução.equals(other.dataPrevDevulução))
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
				+ ", dataPrevDevulução=" + dataPrevDevulução + ", dataDevulução=" + dataDevulução + "]";
	}

	



			
		
	
	
	
}
