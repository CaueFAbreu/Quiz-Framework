package quiz.aplicacao.matematica;

import quiz.aplicacao.matematica.ui.ConsoleQuizView;
import quiz.framework.engine.QuizTemplate;
import quiz.framework.factory.PerguntaFactory;
import quiz.framework.model.Pergunta;
import quiz.framework.scoring.PontuacaoComPenalidadeStrategy;
import quiz.framework.scoring.PontuacaoStrategy;
import quiz.framework.view.QuizView;

import java.util.ArrayList;
import java.util.List;

public class QuizMatematica extends QuizTemplate {

    @Override
    protected String criarTitulo() {
        return "Quiz de Matemática";
    }

    @Override
    protected List<Pergunta> criarPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(PerguntaFactory.criarPergunta(
                "Quanto é 8 x 7?",
                2,
                "48",
                "54",
                "56",
                "64"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Qual é a raiz quadrada de 144?",
                1,
                "10",
                "12",
                "14",
                "16"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Se x + 5 = 13, qual é o valor de x?",
                0,
                "8",
                "13",
                "18",
                "5"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Qual é o resultado de 3² + 4²?",
                3,
                "12",
                "16",
                "24",
                "25"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Quanto é 15% de 200?",
                1,
                "20",
                "30",
                "40",
                "50"
        ));

        return perguntas;
    }

    @Override
    protected PontuacaoStrategy criarPontuacaoStrategy() {
        return new PontuacaoComPenalidadeStrategy(5, 2);
    }

    @Override
    protected QuizView criarQuizView() {
        return new ConsoleQuizView();
    }
}