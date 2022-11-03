package mmz.salaobeleza.model;

import java.util.ArrayList;
import java.util.List;

public class Acesso {
	private TipoAcesso tipoAcesso;
	private Setor setor;
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public Acesso(TipoAcesso tipoAcesso, Setor setor){
		this.tipoAcesso = tipoAcesso;
		this.setor = setor;
	}

	public Acesso(TipoAcesso tipoAcesso, Setor setor, List<Pessoa> pessoas){
		this.tipoAcesso = tipoAcesso;
		this.setor = setor;
		this.pessoas = pessoas;
	}

	public void addPessoa(Pessoa pessoa)   { this.pessoas.add(pessoa); }
	public void removePessoa(Pessoa pessoa){ this.pessoas.remove(pessoa); }

	public TipoAcesso getTipoAcesso() { return tipoAcesso; }
	public Setor getSetor()          { return setor; }
	public List<Pessoa> getPessoas() { return pessoas; }

	public void setTipoAcesso(TipoAcesso tipoAcesso) { this.tipoAcesso = tipoAcesso; }
	public void setSetor(Setor setor)               { this.setor = setor; }
	public void setPessoas(List<Pessoa> pessoas)    { this.pessoas = pessoas; }
}
