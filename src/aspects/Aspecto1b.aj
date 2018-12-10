package aspects;

import br.ufpe.cin.model.Conta.ContaAbstrata;

public aspect Aspecto1b {

	before(ContaAbstrata conta, double x): call(void ContaAbstrata+.debitar(double)) && target(conta) && args(x){
		if(conta.getSaldo() < 0) {
			throw new IllegalArgumentException("Você está tentando debitar "+ x + " da conta " + conta.getNumero() + " cujo saldo atual é " + conta.getSaldo());
		}	
    }
}
