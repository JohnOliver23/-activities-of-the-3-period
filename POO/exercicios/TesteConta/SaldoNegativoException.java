package view;

public class SaldoNegativoException extends Exception {
	public SaldoNegativoException() {
		super("saldo negativo");
	}
}
