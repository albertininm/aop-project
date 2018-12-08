package br.ufpe.cin.ui;

import br.ufpe.cin.business.BancoFachada;
import br.ufpe.cin.business.conta.ControladorConta;
import br.ufpe.cin.business.exceptions.ContaJaCadastradaException;
import br.ufpe.cin.business.exceptions.RenderBonusContaEspecialException;
import br.ufpe.cin.business.exceptions.SaldoInsuficienteException;
import br.ufpe.cin.dados.exceptions.ContaNaoEncontradaException;
import br.ufpe.cin.model.Conta.Conta;
import br.ufpe.cin.model.Conta.ContaEspecial;
import br.ufpe.cin.model.Conta.ContaImposto;
import br.ufpe.cin.model.Conta.Poupanca;

/**
 * Mova a classe Programa para o pacote br.ufpe.cin.ui, 
 * ela deve tratar todas as excecoes dando uma mensagem de 
 * erro para o usuario
 *
 */
public class Programa {

	public static void main(String[] args) {
//		Conta c = new Conta("123");
//		try {
//			c.creditar(10);
//			c.debitar(12);
//		}catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		catch (SaldoInsuficienteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		try {
			BancoFachada banco = new BancoFachada();
			Conta conta1 = new Conta("123");
			conta1.creditar(1000);
			Conta conta2 = new Conta("123123");
			
			banco.cadastrar(conta1);
			banco.cadastrar(conta2);

			banco.transferirEntreContas("123", "123123", 10);
			
			System.out.println("\nDepois de transferir...");
			System.out.println("123: " + banco.getSaldoConta("123"));
			System.out.println("123123: " + banco.getSaldoConta("123123"));
			

		} catch (ContaJaCadastradaException e) {
			System.out.println(e.getMessage());
		} catch (ContaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
	}

}
