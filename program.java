package tp;

import java.util.Scanner;

public class program {
	public static float[] nota_av1;
	public static float[] nota_av2;
	public static String[]nome_aluno;
	
	
	private final static int QUANTIDADE_ALUNOS =100;
	
	private static void impressao(int posicao) {
		System.out.printf("{%d} Cód aluno | %.1f Nota AV1| %.1f Nota AV2 | %s Nome do aluno\n",
				posicao, nota_av1[posicao], nota_av2[posicao], nome_aluno[posicao]);
	}
	

	public static void main(String[]args) {
		
		int quantidade = Integer.valueOf(args[0]);
		if (quantidade < QUANTIDADE_ALUNOS) {
		
			nota_av1 = new float[QUANTIDADE_ALUNOS];
			nota_av2 = new float[QUANTIDADE_ALUNOS];
			nome_aluno = new String[QUANTIDADE_ALUNOS];
			
			
			Scanner sc = new Scanner (System.in);
			String opcao = null;
			int index =0;
			do {
			System.out.println("[1] Registra notas de um novo aluno");
			System.out.println("[2] Consulta boletim de um aluno");
			System.out.println("[3] Consulta notas da turma");
			System.out.println("[4] Sair");
			
			opcao = sc.next();
			
		switch (opcao) {
		
		case "1":
			if (index <= 99) {
			System.out.println("Informe o nome do aluno:");
			nome_aluno[index] = sc.next();
			System.out.println("Informe a nota 1 do aluno:");
			nota_av1[index] = sc.nextFloat();
			System.out.println("Informe a nota 2 do aluno:");
			nota_av2[index] = sc.nextFloat();
			System.out.println("O aluno foi gravado com o cód: "+ index);
			index++;
			break;
			}
			else{
				System.out.println("Número de alunos excedido, limite permitido é de:" + QUANTIDADE_ALUNOS);
			break;
			}
		case "2":
			System.out.println("Informe o cód do aluno:");
			int codigo = sc.nextInt();
			float media_nota = (nota_av1[codigo]+nota_av2[codigo])/2;

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

	
}
