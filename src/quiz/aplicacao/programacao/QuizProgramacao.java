package quiz.aplicacao.programacao;

import quiz.aplicacao.programacao.ui.SwingQuizView;
import quiz.framework.engine.QuizTemplate;
import quiz.framework.factory.PerguntaFactory;
import quiz.framework.model.Pergunta;
import quiz.framework.scoring.PontuacaoFixaStrategy;
import quiz.framework.scoring.PontuacaoStrategy;
import quiz.framework.view.QuizView;

import java.util.ArrayList;
import java.util.List;

public class QuizProgramacao extends QuizTemplate {

    @Override
    protected String criarTitulo() {
        return "Quiz de Programação";
    }

    @Override
    protected List<Pergunta> criarPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(PerguntaFactory.criarPergunta(
                "Qual princípio diz que uma classe deve ter apenas uma razão para mudar?",
                1,
                "Open/Closed Principle",
                "Single Responsibility Principle",
                "Dependency Inversion Principle",
                "Interface Segregation Principle"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Em Java, qual palavra-chave indica herança entre classes?",
                0,
                "extends",
                "implements",
                "inherits",
                "instanceof"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Qual padrão permite trocar um algoritmo sem alterar o código principal?",
                2,
                "Factory",
                "Template",
                "Strategy",
                "Observer"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "No Template Method, onde fica o esqueleto do algoritmo?",
                0,
                "Na classe abstrata",
                "Na interface gráfica",
                "No método main",
                "No banco de dados"
        ));

        perguntas.add(PerguntaFactory.criarPergunta(
                "Qual padrão centraliza a criação de objetos?",
                1,
                "Strategy",
                "Factory",
                "Template",
                "Observer"
        ));

        return perguntas;
    }

    @Override
    protected PontuacaoStrategy criarPontuacaoStrategy() {
        return new PontuacaoFixaStrategy(10);
    }

    @Override
    protected QuizView criarQuizView() {
        return new SwingQuizView();
    }
}