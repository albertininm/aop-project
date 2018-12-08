package aspects;

import br.ufpe.cin.model.Conta.ContaAbstrata;;

public aspect Aspecto1a {

    after(double x): call(void ContaAbstrata+.debitar(double)) && args(x){
	    if(x < 0) {
	    	throw new IllegalArgumentException("Tentando debitar valor negativo");
	    }
    }
}
