package aspects;

import br.ufpe.cin.model.Conta.Conta;

public aspect Aspecto1b {

	
	before(Conta conta, double x): execution(void Conta+.debitar(double)) && target(conta) && args(x){
	    if(conta.getSaldo() < 0) {
	    	throw new IllegalArgumentException("Você está tentando debitar "+ x + " da conta " + conta.getNumero() + " cujo saldo atual é " + conta.getSaldo());
	    }
    }
}
