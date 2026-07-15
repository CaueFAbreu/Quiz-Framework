package quiz.framework.model;

public class ResultadoQuiz {

    private final int totalPerguntas;
    private final int acertos;
    private final int erros;
    private final int pontuacaoFinal;

    public ResultadoQuiz(int totalPerguntas, int acertos, int erros, int pontuacaoFinal) {
        this.totalPerguntas = totalPerguntas;
        this.acertos = acertos;
        this.erros = erros;
        this.pontuacaoFinal = pontuacaoFinal;
    }

    public int getTotalPerguntas() {
        return totalPerguntas;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    public int getPontuacaoFinal() {
        return pontuacaoFinal;
    }
}