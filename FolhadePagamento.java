import java.util.Scanner;

public class FolhadePagamento {

	public static void main(String[] args) throws Exception {

		Scanner entrada = new Scanner(System.in);
		int opcao, atual = 1, cadastro;
		Empregado[] empregados = new Empregado[20];

		empregados[0] = new Empregado();
		empregados[0].nome = "Luís José de Souza";
		empregados[0].endereco = "Avenida Dourada, 77";
		empregados[0].horas = 0;
		empregados[0].comissao = 0;
		empregados[0].salarioMes = 800.00;
		empregados[0].tipoPagamento = 'C';
		empregados[0].numeroCadastro = 1;

		System.out.println("Bem-vindo ao sistema de cadastros de funcionários!");
		System.out.println("\nPor favor, escolha uma opção para iniciar:");
		System.out.println("\n1 - Adicionar um funcionário");
		System.out.println("2 - Remover um funcionário");
		System.out.println("3 - Lançar um cartão de ponto");
		System.out.println("4 - Lançar um resultado venda");
		System.out.println("5 - Lançar uma taxa de serviço");
		System.out.println("6 - Alterar detalhes de um empregado já cadastrado");
		System.out.println("7 - Rodar a folha de pagamento para hoje");
		System.out.println("8 - Desfazer a última tarefa feita");
		System.out.println("9 - Refazer a última tarefa feita");
		System.out.println("10 - Agenda de Pagamento");
		System.out.println("11 - Criar nova Agenda de Pagamento");

		opcao = entrada.nextInt();
		String lixo = entrada.nextLine();

		switch (opcao) {
		case 1:
			System.out.println("\nPor favor, digite o nome do empregado a ser cadastrado:");
			empregados[atual] = new Empregado();
			empregados[atual].nome = entrada.nextLine();
			System.out.println("\nPor favor, digite o endereço do empregado:");
			empregados[atual].endereco = entrada.nextLine();
			System.out.println("\nPor favor, escolha o tipo de pagamento do empregado:");
			System.out.println("\nH - Horista");
			System.out.println("A - Assalariado");
			System.out.println("C - Comissionados");
			empregados[atual].tipoPagamento = (char) System.in.read();
			System.out.println("\nPor favor, digite o salário a ser pago ao empregado:");
			if (empregados[atual].tipoPagamento == 'H') {
				empregados[atual].salarioHora = entrada.nextDouble();
			} else {
				empregados[atual].salarioMes = entrada.nextDouble();
			}
			empregados[atual].comissao = 0;
			empregados[atual].horas = 0;
			empregados[atual].numeroCadastro = atual + 1;
			System.out.println("\nFuncionário cadastrado com sucesso!");
			System.out.println("\nNúmero de cadastro: " + empregados[atual].numeroCadastro);
			System.out.println("Nome: " + empregados[atual].nome);
			System.out.println("Endereço: " + empregados[atual].endereco);
			System.out.print("Tipo: ");
			if (empregados[atual].tipoPagamento == 'C') {
				System.out.println("Comissionado");
				System.out.printf("Valor a ser pago por período de trabalho combinado: %.2f",
						empregados[atual].salarioMes);
			} else if (empregados[atual].tipoPagamento == 'A') {
				System.out.println("Assalariado");
				System.out.printf("Valor a ser pago por período de trabalho combinado: %.2f",
						empregados[atual].salarioMes);
			} else if (empregados[atual].tipoPagamento == 'H') {
				System.out.println("Horista");
				System.out.printf("Valor a ser pago por período de trabalho combinado: %.2f",
						empregados[atual].salarioHora);
			}
			atual++;
			break;
		case 2:
			System.out.println("\nPor favor, digite o número de cadastro do empregado a ser removido:");
			cadastro = entrada.nextInt() - 1;
			if (empregados[cadastro] == null) {
				System.out.println("Empregado não cadastrado");
			} else {
				empregados[cadastro] = null;
				System.out.println("Empregado removido com sucesso!");
			}
			break;
		case 3:
			System.out.println("Digite o número de cadastro do empregado:");
			cadastro = entrada.nextInt() - 1;
			if (empregados[cadastro] == null) {
				System.out.println("Empregado não cadastrado!");
			} else {
				System.out.println("Digite o número de horas:");
				empregados[cadastro].horas += entrada.nextDouble();
				System.out.println("Cartão de ponto lançado com sucesso!");
			}
			break;
		case 4:
			System.out.println("Digite o número de cadastro do empregado:");
			cadastro = entrada.nextInt() - 1;
			if (empregados[cadastro] != null && empregados[cadastro].tipoPagamento == 'C') {
				System.out.println("Digite o resultado da venda:");
				empregados[cadastro].comissao += entrada.nextDouble();
				System.out.println("Resultado lançado com sucesso!");
			}
			break;
		case 5:

			break;
		case 6:
			System.out.println("Digite o número de cadastro do empregado:");
			cadastro = entrada.nextInt() - 1;
			if (empregados[cadastro] == null) {
				System.out.println("Empregado não cadastrado!");
			} else {
				System.out.println("Deseja alterar o nome do funcionário: " + empregados[cadastro].nome + "?");
				lixo = entrada.nextLine();
				String resposta = entrada.nextLine();
				if (resposta.equals("sim")) {
					System.out.println("Digite o nome do funcionário:");
					empregados[cadastro].nome = entrada.nextLine();
				}
				System.out.println("Deseja alterar o endereço do funcionário: " + empregados[cadastro].endereco + "?");
				lixo = entrada.nextLine();
				resposta = entrada.nextLine();
				if (resposta.equals("sim")) {
					System.out.println("Digite o endereço do funcionário:");
					empregados[cadastro].endereco = entrada.nextLine();
				}
				System.out.println("Deseja alterar o tipo de pagamento do funcionário: " + empregados[cadastro].tipoPagamento + "?");
				lixo = entrada.nextLine();
				resposta = entrada.nextLine();
				if (resposta.equals("sim")) {
					System.out.println("Digite o tipo de pagamento do funcionário:");
					System.out.println("\nH - Horista");
					System.out.println("A - Assalariado");
					System.out.println("C - Comissionados");
					empregados[cadastro].tipoPagamento = (char) System.in.read();
				}
				System.out.println("Deseja alterar o endereço do funcionário: " + empregados[cadastro].endereco + "?");
				lixo = entrada.nextLine();
				resposta = entrada.nextLine();
				if (resposta.equals("sim")) {
					System.out.println("Digite o endereço do funcionário:");
					empregados[cadastro].endereco = entrada.nextLine();
				}
			}
		}
	}
}
