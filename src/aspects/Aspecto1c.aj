package aspects;

import br.ufpe.cin.model.Conta.ContaAbstrata;

public aspect Aspecto1c {
	
	double previousValue = 0;
	
	before(ContaAbstrata conta, double x): call(void ContaAbstrata+.debitar(double)) && target(conta) && args(x){
		previousValue = conta.getSaldo();
		System.out.println(conta.getSaldo());
	}

	after(ContaAbstrata conta, double x): call(void ContaAbstrata+.debitar(double)) && target(conta) && args(x) {
		double saldo = conta.getSaldo();
		System.out.println(previousValue + " " +conta.getSaldo());
		if((saldo == (previousValue - x))) {
			System.out.println("O valor da conta era " + previousValue + "\nFoi debitado corretamente " + x + "\nO valor atual é "+ saldo);	
		} else {
			throw new RuntimeException("O valor não foi debitado corretamente. Saldo atual continua "+saldo);
		}
	}
}
