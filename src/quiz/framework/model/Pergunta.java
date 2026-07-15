package quiz.framework.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pergunta {

    private final String enunciado;
    private final List<String> alternativas;
    private final int indiceAlternativaCorreta;

    public Pergunta(String enunciado, List<String> alternativas, int indiceAlternativaCorreta) {
        if (enunciado == null || enunciado.isBlank()) {
            throw new IllegalArgumentException("O enunciado não pode ser vazio.");
        }

        if (alternativas == null || alternativas.size() < 2) {
            throw new IllegalArgumentException("A pergunta deve ter pelo menos duas alternativas.");
        }

        if (indiceAlternativaCorreta < 0 || indiceAlternativaCorreta >= alternativas.size()) {
            throw new IllegalArgumentException("Índice da alternativa correta inválido.");
        }

        this.enunciado = enunciado;
        this.alternativas = Collections.unmodifiableList(new ArrayList<>(alternativas));
        this.indiceAlternativaCorreta = indiceAlternativaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public int getIndiceAlternativaCorreta() {
        return indiceAlternativaCorreta;
    }

    public String getAlternativaCorreta() {
        return alternativas.get(indiceAlternativaCorreta);
    }

    public boolean estaCorreta(int indiceEscolhido) {
        return indiceEscolhido == indiceAlternativaCorreta;
    }
}