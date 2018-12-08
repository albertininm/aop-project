package br.ufpe.cin.business.conta;

import br.ufpe.cin.business.exceptions.ContaJaCadastradaException;
import br.ufpe.cin.business.exceptions.RenderBonusContaEspecialException;
import br.ufpe.cin.business.exceptions.RenderJurosPoupancaException;
import br.ufpe.cin.business.exceptions.SaldoInsuficienteException;
import br.ufpe.cin.dados.exceptions.ContaNaoEncontradaException;
import br.ufpe.cin.model.Conta.ContaAbstrata;
import br.ufpe.cin.model.Conta.ContaEspecial;
import br.ufpe.cin.model.Conta.Poupanca;

public class ControladorConta {

	private CadastroConta cadastroConta;
	
	private final double TAXA = 0.008;

	public ControladorConta(CadastroConta cadastroConta) {
		this.cadastroConta = cadastroConta;
	}
	
	public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException{
		return this.cadastroConta.procurar(numero);
	}

	public void cadastrar(ContaAbstrata conta) throws ContaJaCadastradaException {
		this.cadastroConta.cadastrar(conta);
	}
	
	public void creditar(String numero, double valor) throws ContaNaoEncontradaException{
		ContaAbstrata c = this.cadastroConta.procurar(numero);
		c.creditar(valor);
	}

	public void debitar(String numero, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException {
		ContaAbstrata c = this.cadastroConta.procurar(numero);
		c.debitar(valor);
	}

	public double getSaldo(String numero) throws ContaNaoEncontradaException{
		ContaAbstrata c = this.cadastroConta.procurar(numero);
		return c.getSaldo();
	}

	public void transferir(String de, String para, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException {
		ContaAbstrata origem = this.cadastroConta.procurar(de);
		ContaAbstrata destino = this.cadastroConta.procurar(para);
		origem.debitar(valor);
		destino.creditar(valor);
	}
	
	public void renderJuros(String numero) throws ContaNaoEncontradaException, RenderJurosPoupancaException{
		ContaAbstrata c = this.cadastroConta.procurar(numero);
		if (c instanceof Poupanca) {
			((Poupanca) c).renderJuros(TAXA);
		} 
		else {
			throw new RenderJurosPoupancaException();
		}
	}

	public void renderBonus(String numero) throws ContaNaoEncontradaException, RenderBonusContaEspecialException{
		ContaAbstrata c = this.cadastroConta.procurar(numero);
		if (c instanceof ContaEspecial) {
			((ContaEspecial) c).renderBonus();
		} 
		else {
			throw new RenderBonusContaEspecialException();
		}
	}

}
