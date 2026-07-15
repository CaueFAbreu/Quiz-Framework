package quiz.framework.factory;

import quiz.framework.model.Pergunta;

import java.util.Arrays;

public final class PerguntaFactory {

    private PerguntaFactory() {
    }

    public static Pergunta criarPergunta(
            String enunciado,
            int indiceAlternativaCorreta,
            String... alternativas
    ) {
        return new Pergunta(
                enunciado,
                Arrays.asList(alternativas),
                indiceAlternativaCorreta
        );
    }
}