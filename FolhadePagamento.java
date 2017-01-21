import java.util.Scanner;

public class FolhadePagamento {

	public static void main(String[] args) throws Exception {

		Scanner entrada = new Scanner(System.in);
		int opcao, cadastro;
		Empregado[] empregados = new Empregado[20];

		empregados[0] = new Empregado();
		empregados[0].nome = "Lu�s Jos� de Souza";
		empregados[0].endereco = "Avenida Dourada, 77";
		empregados[0].horas = 0;
		empregados[0].comissao = 0;
		empregados[0].metodo = "Correios";
		empregados[0].percentual = 0;
		empregados[0].salarioFixo = 800.00;
		empregados[0].salarioHora = 0;
		empregados[0].tipoPagamento = 'A';
		empregados[0].numeroCadastro = 1;

		do {
			System.out.println("Bem-vindo ao sistema de cadastros de funcion�rios!");
			System.out.println("\nPor favor, escolha uma op��o para iniciar:");
			System.out.println("\n1 - Adicionar um funcion�rio");
			System.out.println("2 - Remover um funcion�rio");
			System.out.println("3 - Lan�ar um cart�o de ponto");
			System.out.println("4 - Lan�ar um resultado venda");
			System.out.println("5 - Lan�ar uma taxa de servi�o");
			System.out.println("6 - Alterar detalhes de um empregado j� cadastrado");
			System.out.println("7 - Rodar a folha de pagamento para hoje");
			System.out.println("8 - Desfazer a �ltima tarefa feita");
			System.out.println("9 - Refazer a �ltima tarefa feita");
			System.out.println("10 - Agenda de Pagamento");
			System.out.println("11 - Criar nova Agenda de Pagamento");

			opcao = entrada.nextInt();
			String lixo = entrada.nextLine();
			int atual = 0;

			switch (opcao) {
			case 0:
				break;
			case 1:
				while(empregados[atual] != null){
					atual++;
				}
				System.out.println("\nPor favor, digite o nome do empregado a ser cadastrado:");
				empregados[atual] = new Empregado();
				empregados[atual].nome = entrada.nextLine();
				System.out.println("\nPor favor, digite o endere�o do empregado:");
				empregados[atual].endereco = entrada.nextLine();
				System.out.println("\nPor favor, escolha o tipo de pagamento do empregado:");
				System.out.println("\nH - Horista");
				System.out.println("A - Assalariado");
				System.out.println("C - Comissionado");
				empregados[atual].tipoPagamento = (char) System.in.read();
				System.out.println("\nPor favor, digite o sal�rio a ser pago ao empregado:");
				if (empregados[atual].tipoPagamento == 'H') {
					empregados[atual].salarioHora = entrada.nextDouble();
				} else {
					empregados[atual].salarioFixo = entrada.nextDouble();
					if (empregados[atual].tipoPagamento == 'C') {
						System.out.println("Por favor, digite o percentual de comiss�o a ser pago ao empregado:");
						empregados[atual].percentual = entrada.nextDouble();
					}
				}
				System.out.println("\nPor favor, informe a forma de pagamento desejada pelo empregado:");
				System.out.println("Op��es: Correios, Dep�sito, Pessoalmente");
				lixo = entrada.nextLine();
				empregados[atual].metodo = entrada.nextLine();
				empregados[atual].comissao = 0;
				empregados[atual].horas = 0;
				empregados[atual].numeroCadastro = atual + 1;
				System.out.println("\nFuncion�rio cadastrado com sucesso!");
				System.out.printf("\nN�mero de cadastro: %d\n", empregados[atual].numeroCadastro);
				System.out.println("Nome: " + empregados[atual].nome);
				System.out.println("Endere�o: " + empregados[atual].endereco);
				System.out.print("Tipo: ");
				if (empregados[atual].tipoPagamento == 'C') {
					System.out.println("Comissionado");
					System.out.printf("Valor a ser pago quinzenalmente: %.2f\n",
							empregados[atual].salarioFixo);
				} else if (empregados[atual].tipoPagamento == 'A') {
					System.out.println("Assalariado");
					System.out.printf("Valor a ser pago por per�odo mensalmente: %.2f\n",
							empregados[atual].salarioFixo);
				} else if (empregados[atual].tipoPagamento == 'H') {
					System.out.println("Horista");
					System.out.printf("Valor a ser pago por per�odo de trabalho combinado: %.2f\n",
							empregados[atual].salarioHora);
				}
				System.out.println("M�todo de pagamento escolhido: " + empregados[atual].metodo);
				break;
			case 2:
				System.out.println("\nPor favor, digite o n�mero de cadastro do empregado a ser removido:");
				cadastro = entrada.nextInt() - 1;
				lixo = entrada.nextLine();
				if (empregados[cadastro] == null) {
					System.out.println("Empregado n�o cadastrado");
				} else {
					System.out.println("Deseja remover " + empregados[cadastro].nome + "?");
					String resposta = entrada.nextLine();
					if (resposta.equals("sim")) {
						empregados[cadastro] = null;
						System.out.println("Empregado removido com sucesso!");
					}
				}
				break;
			case 3:
				System.out.println("Digite o n�mero de cadastro do empregado:");
				cadastro = entrada.nextInt() - 1;
				if (empregados[cadastro] == null) {
					System.out.println("Empregado n�o cadastrado!");
				} else {
					System.out.println("Digite o n�mero de horas:");
					empregados[cadastro].horas += entrada.nextDouble();
					System.out.println("Cart�o de ponto lan�ado com sucesso!");
				}
				break;
			case 4:
				System.out.println("Digite o n�mero de cadastro do empregado:");
				cadastro = entrada.nextInt() - 1;
				if (empregados[cadastro] != null && empregados[cadastro].tipoPagamento == 'C') {
					System.out.println("Digite o resultado da venda:");
					empregados[cadastro].comissao += entrada.nextDouble();
					System.out.println("Resultado lan�ado com sucesso!");
				}
				break;
			case 5:

				break;
			case 6:
				System.out.println("Digite o n�mero de cadastro do empregado:");
				cadastro = entrada.nextInt() - 1;
				if (empregados[cadastro] == null) {
					System.out.println("Empregado n�o cadastrado!");
				} else {
					System.out.println("Deseja alterar o nome do funcion�rio: " + empregados[cadastro].nome + "?");
					lixo = entrada.nextLine();
					String resposta = entrada.nextLine();
					if (resposta.equals("sim")) {
						System.out.println("Digite o nome do funcion�rio:");
						empregados[cadastro].nome = entrada.nextLine();
					}
					System.out.println(
							"Deseja alterar o endere�o do funcion�rio: " + empregados[cadastro].endereco + "?");
					resposta = entrada.nextLine();
					if (resposta.equals("sim")) {
						System.out.println("Digite o endere�o do funcion�rio:");
						empregados[cadastro].endereco = entrada.nextLine();
					}
					System.out.println("Deseja alterar o tipo de pagamento do funcion�rio: "
							+ empregados[cadastro].tipoPagamento + "?");
					resposta = entrada.nextLine();
					if (resposta.equals("sim")) {
						System.out.println("Digite o tipo de pagamento do funcion�rio:");
						System.out.println("\nH - Horista");
						System.out.println("A - Assalariado");
						System.out.println("C - Comissionados");
						empregados[cadastro].tipoPagamento = (char) System.in.read();
					}
				}
			}
		} while (opcao != 0);
	}
}
