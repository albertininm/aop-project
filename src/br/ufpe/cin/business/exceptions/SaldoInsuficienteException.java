package br.ufpe.cin.business.exceptions;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException (String numero, double saldo) {
		super("O saldo atual da conta "+numero+" Ž "+saldo);
	}
}
