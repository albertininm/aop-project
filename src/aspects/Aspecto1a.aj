package aspects;

import br.ufpe.cin.model.Conta.Conta;

public aspect Aspecto1a {

    after(double x): call(void Conta+.debitar(double)) && args(x){
	    if(x < 0) {
	    	throw new IllegalArgumentException();
	    }
    }
}
