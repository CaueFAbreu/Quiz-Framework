package quiz.framework.scoring;

public class PontuacaoComPenalidadeStrategy implements PontuacaoStrategy {

    private final int pontosPorAcerto;
    private final int penalidadePorErro;

    public PontuacaoComPenalidadeStrategy(int pontosPorAcerto, int penalidadePorErro) {
        this.pontosPorAcerto = pontosPorAcerto;
        this.penalidadePorErro = penalidadePorErro;
    }

    @Override
    public int calcularPontuacao(boolean respostaCorreta) {
        if (respostaCorreta) {
            return pontosPorAcerto;
        }

        return -penalidadePorErro;
    }
}