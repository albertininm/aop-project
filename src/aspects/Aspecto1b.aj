package aspects;

import br.ufpe.cin.model.Conta.ContaAbstrata;

public aspect Aspecto1b {

	after(ContaAbstrata conta, double x): call(void ContaAbstrata+.debitar(double)) && target(conta) && args(x){
	    if(conta.getSaldo() < 0) {
	    	throw new IllegalArgumentException("O débito de  "+ x + " da conta " + conta.getNumero() + " fez com que o saldo ficasse negativo.\n Saldo atual é " + conta.getSaldo());
	    }
    }
}
