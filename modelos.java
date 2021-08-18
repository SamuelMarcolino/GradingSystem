

import java.util.Scanner;

public class modelos {
	//vetores a serem usados. Usar Alt+Shift+R para mudar todas as váriaveis com mesmo nome
	public static float[] example_1;
	public static float[] example_2;
	public static String[] example_name;
	
	//variável para limitar número execuções
	private final static int QUANTIDADE_TESTE =100;
	
	//método de impressão
	private static void impressao(int posicao) {
		System.out.printf("{%d} Cód aluno | %.1f Nota AV1| %.1f Nota AV2 | %s Nome do aluno\n",
				posicao, example_1[posicao], example_2[posicao], example_name[posicao]);
	}
	

	public static void main(String[]args) {
		// verificador pra ver se a quantidade excede a desejada
		int quantidade = Integer.valueOf(args[0]);
		if (quantidade < QUANTIDADE_TESTE) {
		
			//setando valores pros vetores
			example_1 = new float[QUANTIDADE_TESTE];
			example_2 = new float[QUANTIDADE_TESTE];
			example_name = new String[QUANTIDADE_TESTE];
			
			
			Scanner sc = new Scanner (System.in);

			//criando variáveis que serão usadas a seguir
			String opcao = null;
			int index =0;

			//início do método switch e setando opções
			do {
			System.out.println("[1] Registra notas de um novo aluno");
			System.out.println("[2] Consulta boletim de um aluno");
			System.out.println("[3] Consulta notas da turma");
			System.out.println("[4] Sair");
			
			opcao = sc.next();
			
		switch (opcao) {
		
		//incluindo valores dentro dos vetores
		case "1":
			if (index <= 99) {
			System.out.println("Informe o nome do aluno:");
			example_name[index] = sc.next();
			System.out.println("Informe a nota 1 do aluno:");
			example_1[index] = sc.nextFloat();
			System.out.println("Informe a nota 2 do aluno:");
			example_2[index] = sc.nextFloat();
			System.out.println("O aluno foi gravado com o cód: "+ index);
			index++;
			break;
			}
			else{
				System.out.println("Número de alunos excedido, limite permitido é de:" + QUANTIDADE_TESTE);
			break;
			}

		//fazendo display de informações definidas no case anterior
		case "2":
			System.out.println("Informe o cód do aluno:");
			int codigo = sc.nextInt();
			float media_nota = (example_1[codigo]+example_2[codigo])/2;

			if (media_nota < 4) {
				System.out.println("Reprovado");
			}
			else if (media_nota > 4 && media_nota < 7) {
				System.out.println("Prova final!");
			}
			else {
				System.out.println("Aprovado");
			}
			break;

		//fazendo o display de tudo dentro dos vetores através da impressão
		case "3":
			for(int i = 0; i<index; i++) {
				impressao(i);
			}
			break;
		case "4":
			System.out.println("Saindo do sistema...");
			break;
		default:
			System.out.println("Opção incorreta!");
			break;
		}
		} while (!"4".equals(opcao));
	
	}
		else {
			System.out.println("Quantidade de alunos excede o limite");
		}
	}