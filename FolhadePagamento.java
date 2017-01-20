import java.util.Scanner;

public class FolhadePagamento {

	public static void main(String[] args) throws Exception{

		Scanner entrada = new Scanner(System.in);
		int opcao, atual = 0;
		String lixo;
		Empregado[] empregados = new Empregado[20];
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
		lixo = entrada.nextLine();

		switch (opcao) {
		case 1:
			System.out.println("\nPor favor, digite o nome do empregado a ser cadastrado:");
			empregados[atual] = new Empregado();
			empregados[atual].nome = entrada.nextLine();
			System.out.println("\nPor favor, digite o endere�o do empregado:");
			empregados[atual].endereco = entrada.nextLine();
			System.out.println("\nPor favor, escolha o tipo de pagamento do empregado:");
			System.out.println("\nH - Horista");
			System.out.println("A - Assalariado");
			System.out.println("C - Comissionados");
			empregados[atual].tipoPagamento = (char)System.in.read();
			System.out.println("\nPor favor, digite o sal�rio a ser pago ao empregado:");
			empregados[atual].salario = entrada.nextDouble();
			empregados[atual].numeroCadastro = atual + 1;
			System.out.println("\nFuncion�rio cadastrado com sucesso!");
			System.out.println("\nN�mero de cadastro: " + empregados[atual].numeroCadastro);
			System.out.println("Nome: " + empregados[atual].nome);
			System.out.println("Endere�o: " + empregados[atual].endereco);
			System.out.print("Tipo: ");
			if (empregados[atual].tipoPagamento == 'C') System.out.println("Comissionado");
			else if (empregados[atual].tipoPagamento == 'A') System.out.println("Assalariado");
			else if (empregados[atual].tipoPagamento == 'H') System.out.println("Horista");
			System.out.printf("Valor a ser pago por per�odo de trabalho combinado: %.2f", empregados[atual].salario);
			atual++;
			break;
		}

	}

}
