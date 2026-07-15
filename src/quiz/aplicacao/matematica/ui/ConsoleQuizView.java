package quiz.aplicacao.matematica.ui;

import quiz.framework.model.Pergunta;
import quiz.framework.model.ResultadoQuiz;
import quiz.framework.view.QuizView;

import java.util.List;
import java.util.Scanner;

public class ConsoleQuizView implements QuizView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void exibirBoasVindas(String tituloQuiz) {
        System.out.println(tituloQuiz);
        System.out.println("Digite a letra da alternativa correta.");
        System.out.println();
    }

    @Override
    public int exibirPergunta(Pergunta pergunta, int numeroPerguntaAtual, int totalPerguntas) {
        List<String> alternativas = pergunta.getAlternativas();

        System.out.println("Pergunta " + numeroPerguntaAtual + " de " + totalPerguntas);
        System.out.println(pergunta.getEnunciado());

        for (int i = 0; i < alternativas.size(); i++) {
            char letra = (char) ('A' + i);
            System.out.println(letra + ") " + alternativas.get(i));
        }

        while (true) {
            System.out.print("Sua resposta: ");

            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.length() == 1) {
                int indiceEscolhido = resposta.charAt(0) - 'A';

                if (indiceEscolhido >= 0 && indiceEscolhido < alternativas.size()) {
                    return indiceEscolhido;
                }
            }

            System.out.println("Resposta inválida. Digite uma alternativa válida.");
        }
    }

    @Override
    public void exibirResultadoPergunta(boolean respostaCorreta, Pergunta pergunta, int pontosObtidos) {
        if (respostaCorreta) {
            System.out.println("Resposta correta!");
            System.out.println("Pontos obtidos: " + pontosObtidos);
        } else {
            System.out.println("Resposta incorreta.");
            System.out.println("Alternativa correta: " + pergunta.getAlternativaCorreta());
            System.out.println("Pontos obtidos: " + pontosObtidos);
        }

        System.out.println();
    }

    @Override
    public void exibirResultadoFinal(ResultadoQuiz resultadoQuiz) {
        System.out.println("RESULTADO FINAL");
        System.out.println("Total de perguntas: " + resultadoQuiz.getTotalPerguntas());
        System.out.println("Acertos: " + resultadoQuiz.getAcertos());
        System.out.println("Erros: " + resultadoQuiz.getErros());
        System.out.println("Pontuação final: " + resultadoQuiz.getPontuacaoFinal());
    }

    @Override
    public void fechar() {
        scanner.close();
    }
}