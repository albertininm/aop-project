package br.ufpe.cin.business.conta;

import br.ufpe.cin.business.exceptions.ContaJaCadastradaException;
import br.ufpe.cin.dados.IRepositorioContas;
import br.ufpe.cin.dados.exceptions.ContaNaoEncontradaException;
import br.ufpe.cin.model.Conta.ContaAbstrata;

/**
 * O metodo cadastrar da classe Banco deve lancar a excecao 
 * ContaJaCadastradaException quando ja existir uma conta com 
 * o mesmo numero da conta a ser cadastrada
 * 
 * Crie e utilize excecoes especificas em outros casos onde esta
 * sendo utilizada RuntimeException
 */
public class CadastroConta {

	private IRepositorioContas contasRep;

	public CadastroConta(IRepositorioContas rep) {
		this.contasRep = rep;
	}
	
	public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException{
		return contasRep.procurar(numero);
	}

	public void cadastrar(ContaAbstrata conta) throws ContaJaCadastradaException {
		String numero = conta.getNumero();
		if (contasRep.existe(numero)) {
			throw new ContaJaCadastradaException();
		} else {
			contasRep.inserir(conta);
		}
	}
	
	// ...
}