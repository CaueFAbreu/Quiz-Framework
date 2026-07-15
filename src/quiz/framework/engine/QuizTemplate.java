package quiz.framework.engine;

import quiz.framework.model.Pergunta;
import quiz.framework.model.ResultadoQuiz;
import quiz.framework.scoring.PontuacaoStrategy;
import quiz.framework.view.QuizView;

import java.util.List;

public abstract class QuizTemplate {

    public final void iniciar() {
        String titulo = criarTitulo();
        List<Pergunta> perguntas = criarPerguntas();
        PontuacaoStrategy pontuacaoStrategy = criarPontuacaoStrategy();
        QuizView quizView = criarQuizView();

        validarConfiguracao(titulo, perguntas, pontuacaoStrategy, quizView);

        int acertos = 0;
        int erros = 0;
        int pontuacaoFinal = 0;

        quizView.exibirBoasVindas(titulo);

        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta perguntaAtual = perguntas.get(i);

            int alternativaEscolhida = quizView.exibirPergunta(
                    perguntaAtual,
                    i + 1,
                    perguntas.size()
            );

            boolean respostaCorreta = perguntaAtual.estaCorreta(alternativaEscolhida);

            int pontosObtidos = pontuacaoStrategy.calcularPontuacao(respostaCorreta);

            pontuacaoFinal += pontosObtidos;

            if (respostaCorreta) {
                acertos++;
            } else {
                erros++;
            }

            quizView.exibirResultadoPergunta(
                    respostaCorreta,
                    perguntaAtual,
                    pontosObtidos
            );
        }

        ResultadoQuiz resultadoQuiz = new ResultadoQuiz(
                perguntas.size(),
                acertos,
                erros,
                pontuacaoFinal
        );

        quizView.exibirResultadoFinal(resultadoQuiz);
        quizView.fechar();
    }

    protected abstract String criarTitulo();

    protected abstract List<Pergunta> criarPerguntas();

    protected abstract PontuacaoStrategy criarPontuacaoStrategy();

    protected abstract QuizView criarQuizView();

    private void validarConfiguracao(
            String titulo,
            List<Pergunta> perguntas,
            PontuacaoStrategy pontuacaoStrategy,
            QuizView quizView
    ) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalStateException("O quiz precisa ter um título.");
        }

        if (perguntas == null || perguntas.isEmpty()) {
            throw new IllegalStateException("O quiz precisa ter pelo menos uma pergunta.");
        }

        if (pontuacaoStrategy == null) {
            throw new IllegalStateException("O quiz precisa ter uma Strategy de pontuação.");
        }

        if (quizView == null) {
            throw new IllegalStateException("O quiz precisa ter uma View.");
        }
    }
}