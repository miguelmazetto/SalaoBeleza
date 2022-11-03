package mmz.salaobeleza;

import mmz.salaobeleza.controller.AcessoController;
import mmz.salaobeleza.model.Acesso;
import mmz.salaobeleza.model.Pessoa;
import mmz.salaobeleza.model.Setor;
import mmz.salaobeleza.model.TipoAcesso;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static mmz.salaobeleza.model.TipoAcesso.*;
import static mmz.salaobeleza.model.Setor.*;

public class AcessoControllerTest {

	AcessoController acesso;

	private void resetAcessos(){
		acesso = new AcessoController(new ArrayList<Acesso>());
	}
	private Pessoa expessoa(){
		return new Pessoa("B","d");
	}
	private Setor exsetor(){
		return FORMA_PAGAMENTO;
	}
	private TipoAcesso extipoacesso(){
		return CONSULTAR;
	}

	@Test
	public void test_cadastrarAcessoSemSetor(){
		resetAcessos();
		Assert.assertFalse("Nao deu erro quando deveria dar!",
			acesso.cadastrarAcesso(null, extipoacesso(), expessoa()));
	}
	@Test
	public void test_cadastrarAcessoSemTipoAcesso(){
		resetAcessos();
		Assert.assertFalse("Nao deu erro quando deveria dar!",
				acesso.cadastrarAcesso(exsetor(), null, expessoa()));
	}
	@Test
	public void test_cadastrarAcessoSemPessoa(){
		resetAcessos();
		Assert.assertFalse("Nao deu erro quando deveria dar!",
			acesso.cadastrarAcesso(exsetor(), extipoacesso(), null));
	}
	@Test
	public void test_cadastrarAcessoCompleto(){
		resetAcessos();
		Assert.assertFalse("Deu erro quando nao deveria dar!",
			acesso.cadastrarAcesso(exsetor(), extipoacesso(), expessoa()));
	}
}
