package br.ufpe.cin.ui;

import br.ufpe.cin.business.BancoFachada;
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
		Conta c = new Conta("123");
		try {
			c.creditar(10);
			c.debitar(12);
			c.debitar(12);
		}catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//		try {
//			BancoFachada banco = new BancoFachada();
//
//			banco.cadastrar(new Conta("123"));
//			banco.cadastrar(new ContaEspecial("456"));
//			banco.cadastrar(new Poupanca("789"));
//			banco.cadastrar(new ContaImposto("012"));
//
//			banco.creditarConta("123", 100);
//			banco.creditarConta("456", 200);
//			banco.creditarConta("789", 300);
//			banco.creditarConta("012", 400);
//
//			banco.debitarConta("123", 10);
//			banco.debitarConta("456", 20);
//			banco.debitarConta("789", 30);
//			banco.debitarConta("012", 40);		
//
//			System.out.println("123: " + banco.getSaldoConta("123"));
//			System.out.println("456: " + banco.getSaldoConta("456"));
//			System.out.println("789: " + banco.getSaldoConta("789"));
//			System.out.println("012: " + banco.getSaldoConta("012"));
//			
//			banco.renderBonusConta("456");
//			banco.renderBonusConta("789");
//			
//			System.out.println("\nDepois de render juros e bonus...");
//			System.out.println("123: " + banco.getSaldoConta("123"));
//			System.out.println("456: " + banco.getSaldoConta("456"));
//			System.out.println("789: " + banco.getSaldoConta("789"));
//			System.out.println("012: " + banco.getSaldoConta("012"));
//
//			banco.transferirEntreContas("123", "789", 10);
//			
//			System.out.println("\nDepois de transferir...");
//			System.out.println("123: " + banco.getSaldoConta("123"));
//			System.out.println("456: " + banco.getSaldoConta("456"));
//			System.out.println("789: " + banco.getSaldoConta("789"));
//			System.out.println("012: " + banco.getSaldoConta("012"));
//			
//			System.out.println("\nAgora a proxima linha gera um erro que ser� devidaente tratado");
//			banco.renderBonusConta("123");
//		} catch (ContaJaCadastradaException e) {
//			System.out.println(e.getMessage());
//		} catch (ContaNaoEncontradaException e) {
//			System.out.println(e.getMessage());
//		} catch (SaldoInsuficienteException e) {
//			System.out.println(e.getMessage());
//		} catch (RenderBonusContaEspecialException e) {
//			System.out.println(e.getMessage());
//		} 
//	}

}
