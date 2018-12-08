package br.ufpe.cin.business;

import br.ufpe.cin.business.conta.CadastroConta;
import br.ufpe.cin.business.conta.ControladorConta;
import br.ufpe.cin.business.exceptions.ContaJaCadastradaException;
import br.ufpe.cin.business.exceptions.RenderBonusContaEspecialException;
import br.ufpe.cin.business.exceptions.RenderJurosPoupancaException;
import br.ufpe.cin.business.exceptions.SaldoInsuficienteException;
import br.ufpe.cin.dados.RepositorioContasArray;
import br.ufpe.cin.dados.exceptions.ContaNaoEncontradaException;
import br.ufpe.cin.model.Conta.ContaAbstrata;

public class BancoFachada {
	
	private ControladorConta controladorConta;
	
	public BancoFachada(){
		this.controladorConta = new ControladorConta(new CadastroConta(new RepositorioContasArray(100)));
	}
	
	public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException{
		return this.controladorConta.procurar(numero);
	}

	public void cadastrar(ContaAbstrata conta) throws ContaJaCadastradaException {
		this.controladorConta.cadastrar(conta);
	}
	
	public void creditarConta(String numero, double valor) throws ContaNaoEncontradaException{
		this.controladorConta.creditar(numero, valor);
	}

	public void debitarConta(String numero, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException {
		this.controladorConta.debitar(numero, valor);
	}

	public double getSaldoConta(String numero) throws ContaNaoEncontradaException{
		return this.controladorConta.getSaldo(numero);
	}

	public void transferirEntreContas(String de, String para, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException {
		this.controladorConta.transferir(de, para, valor);
	}
	
	public void renderJurosConta(String numero) throws ContaNaoEncontradaException, RenderJurosPoupancaException{
		this.controladorConta.renderJuros(numero);
	}

	public void renderBonusConta(String numero) throws ContaNaoEncontradaException, RenderBonusContaEspecialException{
		this.controladorConta.renderBonus(numero);
	}
}
