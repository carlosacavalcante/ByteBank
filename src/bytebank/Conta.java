package bytebank;

public class Conta {

	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	
	public Conta() {

	}
	
	public Conta(double saldo, int agencia, int numero) {
		this.saldo = saldo;
		this.agencia = agencia;
		this.numero = numero;
	}


	public Cliente getTitular() {
		return this.titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void depositar(double valor) {
			this.saldo += valor;
	}
	
	public boolean sacar(double valor, int agencia, int numero) {
		if (this.agencia == agencia && this.numero == numero && this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transferir(double valor, Conta destino) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			destino.depositar(valor);
			return true;
		}else {
			return false;
		}
	}
}
