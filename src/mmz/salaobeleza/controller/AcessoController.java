package mmz.salaobeleza.controller;

import mmz.salaobeleza.model.Acesso;
import mmz.salaobeleza.model.Pessoa;
import mmz.salaobeleza.model.Setor;
import mmz.salaobeleza.model.TipoAcesso;

import java.util.ArrayList;
import java.util.List;

public class AcessoController {
	private List<Acesso> acessoList = new ArrayList<Acesso>();

	public AcessoController (List<Acesso> acessoList){
		this.acessoList = acessoList;
	}

	public boolean cadastrarAcesso(Setor setor, TipoAcesso tipoAcesso, Pessoa pessoa){
		if ((tipoAcesso == null) || (setor == null) || (pessoa == null)) {
			System.out.println("Erro de cadastro!");
			return false;
		}
		Acesso acesso = consultarAcesso(setor, tipoAcesso);

		if (acesso == null)
			acesso = new Acesso(tipoAcesso, setor);

		acesso.addPessoa(pessoa);
		this.acessoList.add(acesso);
		return true;
	}

	public boolean atualizarAcesso(Setor setor, TipoAcesso tipoAcesso, Pessoa pessoa){
		if ((tipoAcesso == null) || (setor == null) || (pessoa == null)) {
			System.out.println("Erro de atualizacao!");
			return false;
		}
		Acesso acessoVerificado = consultarAcesso(setor, tipoAcesso);
		if (acessoVerificado == null){
			System.out.println("Nao existe esse Acesso");
			return false;
		}
		if(acessoVerificado.getPessoas().contains(pessoa)){
			acessoVerificado.getPessoas().remove(pessoa);
			return true;
		}

		return cadastrarAcesso(setor, tipoAcesso, pessoa);
	}

	public Acesso consultarAcesso(Setor setor, TipoAcesso tipoAcesso){
		return this.acessoList.stream()
				.filter(acesso -> acesso. getTipoAcesso().equals(tipoAcesso) && acesso.getSetor().equals(setor))
				.findFirst()
				.orElse(null);
	}

	public int quantidadeAcessoCriado(){
		return acessoList.size();
	}
}
