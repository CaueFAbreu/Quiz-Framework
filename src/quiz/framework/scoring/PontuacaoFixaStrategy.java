package quiz.framework.scoring;

public class PontuacaoFixaStrategy implements PontuacaoStrategy {

    private final int pontosPorAcerto;

    public PontuacaoFixaStrategy(int pontosPorAcerto) {
        this.pontosPorAcerto = pontosPorAcerto;
    }

    @Override
    public int calcularPontuacao(boolean respostaCorreta) {
        if (respostaCorreta) {
            return pontosPorAcerto;
        }

        return 0;
    }
}