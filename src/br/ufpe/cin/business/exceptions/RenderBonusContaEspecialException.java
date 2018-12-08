package br.ufpe.cin.business.exceptions;

public class RenderBonusContaEspecialException extends Exception {

	public RenderBonusContaEspecialException () {
		super("Erro ao render bonus, o numero informado nao eh de uma Conta Especial");
	}
}
