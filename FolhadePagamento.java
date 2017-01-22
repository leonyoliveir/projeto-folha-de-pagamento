import java.util.Scanner;

class Empregado {

	public String nome, endereco, metodo; // Guardam o nome, endere�o e m�todo de pagamento escolhido pelo funcion�rio
	public int numeroCadastro; // Guarda o n�mero de cadastro do funcion�rio
	public char tipo; // Guarda o tipo do funcion�rio: A - Assalariado, H - Horista, C - Comissionado
	public char sindicalista; // Guarda a informa��o se o funcion�rio � do sindicato ou n�o: S - Sim, N - N�o
	public double salarioHora; // Guarda o sal�rio a ser pago por hora para funcion�rios horistas
	public double salarioFixo; // Guarda o sal�rio fixo a ser pago para funcion�rios assalariados
	public double percentual; // Guarda o percentual sobre as vendas a ser pago para funcion�rios comissionados
	public double salario; // Guarda o sal�rio total a ser pago de cada funcion�rio
	public double taxa; // Guarda a taxa sindical do empregado
	public long numeroSindicato; // Guarda a ID do funcion�rio no sindicato
	
}

public class FolhadePagamento {

	public Scanner entrada = new Scanner(System.in);

	public static void menu() { // Exibe o menu de op��es do sistema

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

	}

	public static void cadastrado(Empregado empregado) { // Imprime na tela os dados do empregado cadastrado
		
		System.out.println("\nFuncion�rio cadastrado com sucesso!");
		
		System.out.printf("\nN�mero de cadastro: %d\n", empregado.numeroCadastro);
		System.out.println("Nome: " + empregado.nome);
		System.out.println("Endere�o: " + empregado.endereco);
		
		System.out.print("Tipo: ");
		if (empregado.tipo == 'C') {
			System.out.println("Comissionado");
			System.out.printf("Valor a ser pago quinzenalmente: %.2f\n", empregado.salarioFixo / 2);
			System.out.println("Percentual de comiss�o sobre as vendas: " + empregado.percentual + "%");
		} else if (empregado.tipo == 'A') {
			System.out.println("Assalariado");
			System.out.printf("Valor a ser pago mensalmente: %.2f\n", empregado.salarioFixo);
		} else if (empregado.tipo == 'H') {
			System.out.println("Horista");
			System.out.printf("Valor a ser pago por hora: %.2f\n", empregado.salarioHora);
		
		}
		System.out.println("M�todo de pagamento escolhido: " + empregado.metodo);
		
		if(empregado.sindicalista == 'S'){
			System.out.println("Faz parte do sindicato\n");
		} else {
			System.out.println("N�o faz parte do sindicato\n");
		}
		
	}

	public static boolean ultimoDiaDoMes (int ano, int mes, int dia){ // Informa se o dia � o �ltimo do m�s
		
		if ((dia == 31) && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)){
			return true;
		} else if ((dia == 30) && (mes == 4 || mes == 6 || mes == 9 || mes == 11)){
			return true;
		} else if ((dia == 28) && (mes == 2) && (ano % 4 != 0)){
			return true;
		} else if ((dia == 29) && (mes == 2) && (ano % 4 == 0)){
			return true;
		}
		
		return false;
		
	}
	
	public static void pagarAssalariados(Empregado[] empregados){ // Informa os funcion�rios assalariados que devem ser pagos
		
		for (int i = 0; i < 20; i++){
			if (empregados[i] != null && empregados[i].tipo == 'A'){
				System.out.printf("O funcion�rio %s receber� R$ %.2f no m�todo: %s\n", empregados[i].nome, empregados[i].salarioFixo - empregados[i].taxa, empregados[i].metodo);
			}
		}
	}
	
	public static void adicionar(Scanner entrada, Empregado[] empregados) throws Exception { // Adiciona um novo empregado ao sistema
		
		int atual = 0;
		while (empregados[atual] != null) {
			atual++;
		}
		empregados[atual] = new Empregado();
		
		System.out.println("\nPor favor, digite o nome do empregado a ser cadastrado:");
		empregados[atual].nome = entrada.nextLine();
		
		System.out.println("\nPor favor, digite o endere�o do empregado:");
		empregados[atual].endereco = entrada.nextLine();
		
		System.out.println("\nPor favor, escolha o tipo de pagamento do empregado:");
		System.out.println("\nH - Horista");
		System.out.println("A - Assalariado");
		System.out.println("C - Comissionado");
		empregados[atual].tipo = (char) System.in.read();
		
		System.out.println("\nPor favor, digite o sal�rio a ser pago ao empregado:");
		if (empregados[atual].tipo == 'H') {
			empregados[atual].salarioHora = entrada.nextDouble();
		} else {
			empregados[atual].salarioFixo = entrada.nextDouble();
			if (empregados[atual].tipo == 'C') {
				System.out.println("Por favor, digite o percentual de comiss�o a ser pago ao empregado:");
				empregados[atual].percentual = entrada.nextDouble();
			}
		}
		
		System.out.println("\nPor favor, informe a forma de pagamento desejada pelo empregado:");
		System.out.println("Op��es: Correios, Dep�sito, Pessoalmente");
		String lixo = entrada.nextLine();
		empregados[atual].metodo = entrada.nextLine();
		empregados[atual].numeroCadastro = atual + 1;
		
		System.out.println("\nO funcion�rio faz parte do sindicato?");
		System.out.println("S - Sim ou N - N�o");
		empregados[atual].sindicalista = (char) System.in.read(); 
		if(empregados[atual].sindicalista == 'S'){
			System.out.println("\nQual o n�mero e identifica��o do funcion�rio no sindicato?");
			empregados[atual].numeroSindicato = entrada.nextLong();
			System.out.println("\nQual o valor da taxa do sal�rio destinada ao sindicato?");
			empregados[atual].taxa = entrada.nextDouble();
		}
		
		cadastrado(empregados[atual]);

	}

	public static void remover(Scanner entrada, Empregado[] empregados){ // Remove um empregado do sistema
		
		System.out.println("\nPor favor, digite o n�mero de cadastro do empregado a ser removido:");
		int cadastro = entrada.nextInt() - 1;
		String lixo = entrada.nextLine();
		
		if (empregados[cadastro] == null) {
			System.out.println("Empregado n�o cadastrado!");
		} else {
			System.out.println("Deseja remover " + empregados[cadastro].nome + "?");
			String resposta = entrada.nextLine();
			if (resposta.equals("sim")) {
				empregados[cadastro] = null;
				System.out.println("Empregado removido com sucesso!");
			}
		}
		
	}

	public static void ponto(Scanner entrada, Empregado[] empregados){ // Lan�a o cart�o de ponto a um empregado
		
		System.out.println("Digite o n�mero de cadastro do empregado:");
		int cadastro = entrada.nextInt() - 1;
		
		if (empregados[cadastro] == null) {
			System.out.println("Empregado n�o cadastrado!");
		} else if (empregados[cadastro].tipo == 'H') {
			System.out.println("Digite o n�mero de horas:");
			double horas = entrada.nextDouble();
			if (horas <= 8) {
				empregados[cadastro].salario += horas * empregados[cadastro].salarioHora;
			}
			System.out.println("Cart�o de ponto lan�ado com sucesso!");
		} else {
			System.out.println("Empregado n�o � horista!");
		}
		
	}
	
	public static void venda(Scanner entrada, Empregado[] empregados){ // Lan�a o resultado da venda de um empregado
		
		System.out.println("Digite o n�mero de cadastro do empregado:");
		int cadastro = entrada.nextInt() - 1;
		
		if(empregados[cadastro] == null){
			System.out.println("Empregado n�o cadastrado!");
		} else if (empregados[cadastro] != null && empregados[cadastro].tipo == 'C') {
			System.out.println("Digite o resultado da venda:");
			empregados[cadastro].salario += entrada.nextDouble() * empregados[cadastro].percentual;
			System.out.println("Resultado lan�ado com sucesso!");
		} else {
			System.out.println("Empregado n�o � comissionado!");
		}
		
	}
	
	public static void alteracoes(Scanner entrada, Empregado[] empregados) throws Exception { // Altera dados de um funcion�rio
		
		System.out.println("Digite o n�mero de cadastro do empregado:");
		int cadastro = entrada.nextInt() - 1;
		String lixo;
		
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
			
			System.out.println("Deseja alterar o endere�o do funcion�rio: " + empregados[cadastro].endereco + "?");
			resposta = entrada.nextLine();
			if (resposta.equals("sim")) {
				System.out.println("Digite o endere�o do funcion�rio:");
				empregados[cadastro].endereco = entrada.nextLine();
			}
			
			System.out.println("Deseja alterar o tipo de pagamento do funcion�rio: " + empregados[cadastro].tipo + "?");
			resposta = entrada.nextLine();
			if (resposta.equals("sim")) {
				System.out.println("Digite o tipo de pagamento do funcion�rio:");
				System.out.println("\nH - Horista");
				System.out.println("A - Assalariado");
				System.out.println("C - Comissionados");
				empregados[cadastro].tipo = (char) System.in.read();
			}
			
			System.out.println("\nPor favor, digite o sal�rio a ser pago ao empregado:");
			if (empregados[cadastro].tipo == 'H') {
				empregados[cadastro].salarioHora = entrada.nextDouble();
			} else {
				empregados[cadastro].salarioFixo = entrada.nextDouble();
				if (empregados[cadastro].tipo == 'C') {
					System.out.println("Por favor, digite o percentual de comiss�o a ser pago ao empregado:");
					empregados[cadastro].percentual = entrada.nextDouble();
				}
			}
			
			System.out.println("\nO funcion�rio faz parte do sindicato?");
			System.out.println("S - Sim ou N - N�o");
			empregados[cadastro].sindicalista = (char) System.in.read(); 
			if(empregados[cadastro].sindicalista == 'S'){
				System.out.println("\nQual o n�mero e identifica��o do funcion�rio no sindicato?");
				empregados[cadastro].numeroSindicato = entrada.nextLong();
				System.out.println("\nQual o valor da taxa do sal�rio destinada ao sindicato?");
				empregados[cadastro].taxa = entrada.nextDouble();
			}
			lixo = entrada.nextLine();
			System.out.println("Deseja alterar a forma de pagamento do funcion�rio: " + empregados[cadastro].metodo + "?");
			resposta = entrada.nextLine();
			if (resposta.equals("sim")) {
				System.out.println("\nPor favor, informe a forma de pagamento desejada pelo empregado:");
				System.out.println("Op��es: Correios, Dep�sito, Pessoalmente");
				empregados[cadastro].metodo = entrada.nextLine();
			}
			
		}
		System.out.println("Dados alterados com sucesso!");
			
	}

	public static void taxa(Scanner entrada, Empregado[] empregados){ // Registra uma taxa cobrada pelo sindicato a um funcion�rio
	
		System.out.println("Digite o n�mero de cadastro do empregado:");
		int cadastro = entrada.nextInt() - 1;
		
		if(empregados[cadastro] == null){
			System.out.println("Empregado n�o cadastrado!");
		} else if (empregados[cadastro].sindicalista == 'S'){
			System.out.println("Digite a taxa a ser deduzida do pagamento do funcion�rio:");
			empregados[cadastro].taxa += entrada.nextDouble();
			System.out.println("Taxa registrada com sucesso!");
		} else {
			System.out.println("Empregado n�o faz parte do sindicato!");
		}
		
	}
	
	public static void folha(Scanner entrada, Empregado[] empregados){ //Roda a folha de pagamento para determinado dia informado
		
		System.out.println("Por favor, informe o ano atual");
		int ano = entrada.nextInt();
		System.out.println("Por favor, informe o m�s atual:");
		int mes = entrada.nextInt();
		System.out.println("Por favor, informe a data atual:");
		int data = entrada.nextInt();
		System.out.println("Por favor, informe o dia da semana atual (Ex: Segunda-feira, S�bado):");
		String lixo = entrada.nextLine();
		String dia = entrada.nextLine();
		
		boolean ultimo = ultimoDiaDoMes(ano, mes, data);
		
		if(ultimo == true){
			pagarAssalariados(empregados);
		}
	}
	
	public static void main(String[] args) throws Exception {

		Scanner entrada = new Scanner(System.in);
		Empregado[] empregados = new Empregado[20];
		int opcao;

		do{
		menu();
		opcao = entrada.nextInt();
		String lixo = entrada.nextLine();

		switch (opcao) {
		
		case 1:
			adicionar(entrada, empregados);
			break;

		case 2:
			remover(entrada, empregados);
			break;
			
		case 3:
			ponto(entrada, empregados);
			break;
			
		case 4:
			venda(entrada, empregados);
			break;
			
		case 5:
			taxa(entrada, empregados);
			break;
			
		case 6:
			alteracoes(entrada, empregados);
			break;
			
		case 7:
			folha(entrada, empregados);
			break;
			
		}
		}while (opcao != 0);
	}
}
