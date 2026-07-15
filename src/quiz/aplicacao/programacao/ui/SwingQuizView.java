package quiz.aplicacao.programacao.ui;

import quiz.framework.model.Pergunta;
import quiz.framework.model.ResultadoQuiz;
import quiz.framework.view.QuizView;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.util.List;

public class SwingQuizView implements QuizView {

    @Override
    public void exibirBoasVindas(String tituloQuiz) {
        JOptionPane.showMessageDialog(
                null,
                "Bem-vindo ao " + tituloQuiz + "!",
                tituloQuiz,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public int exibirPergunta(Pergunta pergunta, int numeroPerguntaAtual, int totalPerguntas) {
        List<String> alternativas = pergunta.getAlternativas();

        while (true) {
            JPanel painel = new JPanel();
            painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

            painel.add(new JLabel("Pergunta " + numeroPerguntaAtual + " de " + totalPerguntas));
            painel.add(new JLabel(" "));
            painel.add(new JLabel(pergunta.getEnunciado()));
            painel.add(new JLabel(" "));

            ButtonGroup grupoBotoes = new ButtonGroup();
            JRadioButton[] botoes = new JRadioButton[alternativas.size()];

            for (int i = 0; i < alternativas.size(); i++) {
                botoes[i] = new JRadioButton((char) ('A' + i) + ") " + alternativas.get(i));
                grupoBotoes.add(botoes[i]);
                painel.add(botoes[i]);
            }

            int opcao = JOptionPane.showConfirmDialog(
                    null,
                    painel,
                    "Pergunta",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcao == JOptionPane.CANCEL_OPTION || opcao == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(
                        null,
                        "Você precisa responder para continuar."
                );
                continue;
            }

            for (int i = 0; i < botoes.length; i++) {
                if (botoes[i].isSelected()) {
                    return i;
                }
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Selecione uma alternativa antes de confirmar."
            );
        }
    }

    @Override
    public void exibirResultadoPergunta(boolean respostaCorreta, Pergunta pergunta, int pontosObtidos) {
        if (respostaCorreta) {
            JOptionPane.showMessageDialog(
                    null,
                    "Resposta correta!\nPontos obtidos: " + pontosObtidos
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Resposta incorreta.\nAlternativa correta: "
                            + pergunta.getAlternativaCorreta()
                            + "\nPontos obtidos: " + pontosObtidos
            );
        }
    }

    @Override
    public void exibirResultadoFinal(ResultadoQuiz resultadoQuiz) {
        String mensagem = "Resultado Final\n\n"
                + "Total de perguntas: " + resultadoQuiz.getTotalPerguntas() + "\n"
                + "Acertos: " + resultadoQuiz.getAcertos() + "\n"
                + "Erros: " + resultadoQuiz.getErros() + "\n"
                + "Pontuação final: " + resultadoQuiz.getPontuacaoFinal();

        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Resultado Final",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void fechar() {
        // Não precisa fechar nada no Swing.
    }
}