import java.util.Scanner;

class Empregado {

	public String nome, endereco, metodo; // Guardam o nome, endereço e método de pagamento escolhido pelo funcionário
	public int numeroCadastro; // Guarda o número de cadastro do funcionário
	public char tipo; // Guarda o tipo do funcionário: A - Assalariado, H - Horista, C - Comissionado
	public double salarioHora; // Guarda o salário a ser pago por hora para funcionários horistas
	public double salarioFixo; // Guarda o salário fixo a ser pago para funcionários assalariados
	public double percentual; // Guarda o percentual sobre as vendas a ser pago para funcionários comissionados
	public double salario; // Guarda o salário total a ser pago de cada funcionário

}

public class FolhadePagamento {

	public Scanner entrada = new Scanner(System.in);

	public static void menu() { // Exibe o menu de opções do sistema

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

	}

	public static void cadastrado(Empregado empregado) { // Imprime na tela os dados do empregado cadastrado
		System.out.println("\nFuncionário cadastrado com sucesso!");
		System.out.printf("\nNúmero de cadastro: %d\n", empregado.numeroCadastro);
		System.out.println("Nome: " + empregado.nome);
		System.out.println("Endereço: " + empregado.endereco);
		System.out.print("Tipo: ");
		if (empregado.tipo == 'C') {
			System.out.println("Comissionado");
			System.out.printf("Valor a ser pago quinzenalmente: %.2f\n", empregado.salarioFixo / 2);
			System.out.println("Percentual de comissão sobre as vendas: " + empregado.percentual + "%");
		} else if (empregado.tipo == 'A') {
			System.out.println("Assalariado");
			System.out.printf("Valor a ser pago mensalmente: %.2f\n", empregado.salarioFixo);
		} else if (empregado.tipo == 'H') {
			System.out.println("Horista");
			System.out.printf("Valor a ser pago por hora: %.2f\n", empregado.salarioHora);
		}
		System.out.println("Método de pagamento escolhido: " + empregado.metodo);
	}

	public static Empregado adicionar(Scanner entrada, int indice) throws Exception { // Adiciona um novo empregado ao sistema
		Empregado empregado = new Empregado();
		System.out.println("\nPor favor, digite o nome do empregado a ser cadastrado:");
		empregado = new Empregado();
		empregado.nome = entrada.nextLine();
		System.out.println("\nPor favor, digite o endereço do empregado:");
		empregado.endereco = entrada.nextLine();
		System.out.println("\nPor favor, escolha o tipo de pagamento do empregado:");
		System.out.println("\nH - Horista");
		System.out.println("A - Assalariado");
		System.out.println("C - Comissionado");
		empregado.tipo = (char) System.in.read();
		System.out.println("\nPor favor, digite o salário a ser pago ao empregado:");
		if (empregado.tipo == 'H') {
			empregado.salarioHora = entrada.nextDouble();
		} else {
			empregado.salarioFixo = entrada.nextDouble();
			if (empregado.tipo == 'C') {
				System.out.println("Por favor, digite o percentual de comissão a ser pago ao empregado:");
				empregado.percentual = entrada.nextDouble();
			}
		}
		System.out.println("\nPor favor, informe a forma de pagamento desejada pelo empregado:");
		System.out.println("Opções: Correios, Depósito, Pessoalmente");
		String lixo = entrada.nextLine();
		empregado.metodo = entrada.nextLine();
		empregado.numeroCadastro = indice + 1;

		return empregado;
	}

	public static void remover(Scanner entrada, Empregado[] empregados){ // Remove um empregado do sistema
		
		System.out.println("\nPor favor, digite o número de cadastro do empregado a ser removido:");
		int cadastro = entrada.nextInt() - 1;
		String lixo = entrada.nextLine();
		if (empregados[cadastro] == null) {
			System.out.println("Empregado não cadastrado!");
		} else {
			System.out.println("Deseja remover " + empregados[cadastro].nome + "?");
			String resposta = entrada.nextLine();
			if (resposta.equals("sim")) {
				empregados[cadastro] = null;
				System.out.println("Empregado removido com sucesso!");
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		Scanner entrada = new Scanner(System.in);
		int opcao, cadastro;
		Empregado[] empregados = new Empregado[20];

		menu();
		opcao = entrada.nextInt();
		String lixo = entrada.nextLine();
		int atual = 0;

		switch (opcao) {
		
		case 1:

			while (empregados[atual] != null) {
				atual++;
			}
			empregados[atual] = adicionar(entrada, atual);
			cadastrado(empregados[atual]);
			break;

		case 2:
			
			remover(entrada, empregados);
			break;
			
		case 3:
			
			System.out.println("Digite o número de cadastro do empregado:");
			cadastro = entrada.nextInt() - 1;
			if (empregados[cadastro] == null) {
				System.out.println("Empregado não cadastrado!");
			} else if (empregados[cadastro].tipo == 'H') {
				System.out.println("Digite o número de horas:");
				double horas = entrada.nextDouble();
				if (horas <= 8) {
					empregados[cadastro].salario += horas * empregados[cadastro].salarioHora;
				}
				System.out.println("Cartão de ponto lançado com sucesso!");
			} else {
				System.out.println("Empregado não é horista!");
			}
			
			break;
		case 4:
			
			System.out.println("Digite o número de cadastro do empregado:");
			cadastro = entrada.nextInt() - 1;
			if (empregados[cadastro] != null && empregados[cadastro].tipo == 'C') {
				System.out.println("Digite o resultado da venda:");
				empregados[cadastro].salario += entrada.nextDouble() * empregados[cadastro].percentual;
				System.out.println("Resultado lançado com sucesso!");
			} else {
				System.out.println("Empregado não é comissionado!");
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
				resposta = entrada.nextLine();
				if (resposta.equals("sim")) {
					System.out.println("Digite o endereço do funcionário:");
					empregados[cadastro].endereco = entrada.nextLine();
				}
				System.out.println(
						"Deseja alterar o tipo de pagamento do funcionário: " + empregados[cadastro].tipo + "?");
				resposta = entrada.nextLine();
				if (resposta.equals("sim")) {
					System.out.println("Digite o tipo de pagamento do funcionário:");
					System.out.println("\nH - Horista");
					System.out.println("A - Assalariado");
					System.out.println("C - Comissionados");
					empregados[cadastro].tipo = (char) System.in.read();
				}
				break;
			}
		}
	}
}
