package aspects;

import br.ufpe.cin.business.conta.ControladorConta;
import br.ufpe.cin.dados.exceptions.ContaNaoEncontradaException;

public aspect Aspect2b {
	void around(ControladorConta conta, String s1, String s2, double x) throws ContaNaoEncontradaException: execution(* ControladorConta+.transferir(String, String, double)) && target(conta) && args(s1, s2, x) {
		proceed(conta, s2, s1, x);
	}
}