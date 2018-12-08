package aspects;

import br.ufpe.cin.business.exceptions.SaldoInsuficienteException;
import br.ufpe.cin.model.Conta.Conta;

public aspect Aspecto1c {
	
	pointcut debit(): call(void Conta+.debitar(double));
																
	public double Conta.previousValue = 0;
	
	public void Conta.setPreviousValue(double value) {
		this.previousValue = value;
	}
	
	before(Conta conta): debit() && target(conta){
		conta.setPreviousValue(conta.getSaldo());
		System.out.println("Valor antigo: " + conta.getSaldo());
	}
	
	after(Conta conta, double x): debit() && target(conta) && args(x) {
		System.out.print(conta.getSaldo());
		if(conta.getSaldo() == (conta.previousValue - x)) {
			System.out.println("Valor foi debitado corretamente!\nValor atual: " + conta.getSaldo());
		}
	}
}
