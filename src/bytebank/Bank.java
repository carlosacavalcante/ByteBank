package bytebank;

import java.util.Scanner;

public class Bank {
	public static void main(String agrs[]) {

		Scanner sc = new Scanner(System.in);
		int op = 0;

		Cliente cliente1 = new Cliente("Maria", "09697548", "Contadora");

		Cliente cliente2 = new Cliente("Jose", "987465621", "Contadora");

		Conta contaMaria = new Conta(500, 1234, 56789);

		Conta contaJose = new Conta(100, 4321, 98765);

		do {
			System.out.println(" ");
			System.out.println("Deseja fazer algunas dessas operações ?");
			System.out.println("Digite 1 - Depositar:");
			System.out.println("Digite 2 - Sacar:");
			System.out.println("Digite 3 - Transferir:");
			System.out.println("Digite 4 - Extrato:");
			System.out.println("Digite 0 - Encerrar:");
			op = sc.nextInt();

			switch (op) {
			case 1: {
				System.out.print("Informe o cpf do destinatario:");
				String cpf = sc.next();
				
				System.out.print("Informe o valor do deposito:");
				double valor = sc.nextInt();
				
				if(cliente1.getCpf().equals(cpf)) {
					contaMaria.depositar(valor);
				}
				else if(cliente2.getCpf().equals(cpf)) {
					contaJose.depositar(valor);
				}else {
					System.out.print("Cpf invalido");
				}

				break;
			}
			case 2: {
				System.out.print("Informe o valor do saque:");
				double valor = sc.nextInt();
				System.out.print("Informe o numero da conta:");
				int numero = sc.nextInt();
				System.out.print("Informe a agencia da conta:");
				int agencia = sc.nextInt();

				if (contaJose.sacar(valor, agencia, numero) == true
						|| contaMaria.sacar(valor, agencia, numero) == true) {
					System.out.print("Saque realizado com sucesso: \n");
				} else {
					System.out.print("Saque não realizado: \n");
				}

				break;

			}
			case 3: {
				
				System.out.print("Informe o cpf do destinatario:");
				String cpf = sc.next();
				
				System.out.print("Informe o valor da transferencia:");
				double valor = sc.nextDouble();
				
			
				
				if(cliente1.getCpf().equals(cpf)) {
					contaMaria.transferir(valor, contaJose);
				}
				else if(cliente2.getCpf().equals(cpf)) {
					contaJose.transferir(valor, contaMaria);
				}else {
					System.out.print("Cpf invalido");
				}

				break;

			}
			case 4: {
				System.out.print("Nome:" + cliente1.getNome() + "\ncpf:" + cliente1.getCpf() + "\nprofissão:" + cliente1.getProfissao() + "\nSaldo: " + contaMaria.getSaldo() +"\n");
				System.out.print("\nNome:" + cliente2.getNome() + "\ncpf:" + cliente2.getCpf() + "\nprofissão:" + cliente2.getProfissao() + "\nSaldo: " + contaJose.getSaldo() +"\n");
				
				break;

			}
			default: {
				System.out.print("Operação finalizada\n");
			}
			}

		} while (op != 0);

		sc.close();

	}

}
