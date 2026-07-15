package quiz.framework.view;

import quiz.framework.model.Pergunta;
import quiz.framework.model.ResultadoQuiz;

public interface QuizView {

    void exibirBoasVindas(String tituloQuiz);

    int exibirPergunta(Pergunta pergunta, int numeroPerguntaAtual, int totalPerguntas);

    void exibirResultadoPergunta(boolean respostaCorreta, Pergunta pergunta, int pontosObtidos);

    void exibirResultadoFinal(ResultadoQuiz resultadoQuiz);

    void fechar();
}