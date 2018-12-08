package br.ufpe.cin.dados;

import br.ufpe.cin.dados.exceptions.ContaNaoEncontradaException;
import br.ufpe.cin.model.Conta.ContaAbstrata;

/**
 * Metodos ajustados para lancar a excecao ContaNaoEncontradaException  
 *
 */
public interface IRepositorioContas {
	  void inserir(ContaAbstrata conta);
	  ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException;
	  void remover(String numero) throws ContaNaoEncontradaException;
	  void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException;
	  boolean existe(String numero);

}
