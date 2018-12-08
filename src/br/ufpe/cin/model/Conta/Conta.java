package br.ufpe.cin.model.Conta;

import br.ufpe.cin.business.exceptions.SaldoInsuficienteException;

public class Conta extends ContaAbstrata {
	
	public Conta(String numero) {
		super(numero);
	}
	
	public void debitar(double valor) throws SaldoInsuficienteException {
		this.setSaldo(this.getSaldo() - valor);
	}
		
}