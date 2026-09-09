# 🧠 Quiz Framework

> Framework extensível em Java para criação e execução de quizzes, desenvolvido com foco em padrões de projeto de software.

---

## 📋 Sobre o Projeto

O **Quiz Framework** é um trabalho final desenvolvido para a disciplina de **Padrões de Projeto de Software** na Universidade Federal de Uberlândia (UFU). O objetivo é construir uma solução orientada a objetos para gerenciamento de quizzes, aplicando padrões de design reconhecidos pela indústria para garantir extensibilidade, manutenibilidade e baixo acoplamento.

O relatório técnico completo do projeto está disponível em [`Relatorio_Tecnico_Quiz_Framework.pdf`](./Relatorio_Tecnico_Quiz_Framework.pdf).

---

## 🏗️ Arquitetura e Padrões de Projeto

O projeto aplica padrões de projeto do catálogo GoF (Gang of Four), estruturando o framework em camadas coesas:

| Padrão | Aplicação no projeto |
|--------|---------------------|
| **Factory Method** | Criação de diferentes tipos de questões |
| **Template Method** | Fluxo padrão de execução do quiz |
| **Strategy** | Estratégias intercambiáveis de pontuação |
| **Observer** | Notificação de eventos durante o quiz |

> Os padrões utilizados são detalhados no relatório técnico do projeto.

---

## 📁 Estrutura do Projeto

```
Quiz-Framework/
├── src/
│   └── quiz/           # Pacote principal do framework
├── .idea/              # Configurações do IntelliJ IDEA
├── Trabalho Final.iml  # Módulo do projeto
├── Relatorio_Tecnico_Quiz_Framework.pdf
└── .gitignore
```

---

## 🚀 Como Executar

### Pré-requisitos

- **Java JDK 11+**
- **IntelliJ IDEA** (recomendado) ou qualquer IDE compatível com projetos Java

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/CaueFAbreu/Quiz-Framework.git
   cd Quiz-Framework
   ```

2. Abra o projeto na sua IDE:
   - No IntelliJ IDEA: `File > Open` → selecione a pasta do projeto
   - O arquivo `Trabalho Final.iml` já configura o módulo automaticamente

3. Compile e execute a classe principal:
   ```bash
   # Via linha de comando (a partir da raiz do projeto)
   javac -d out src/quiz/*.java
   java -cp out quiz.Main
   ```

---

## 🧪 Funcionalidades

- ✅ Criação de quizzes com múltiplos tipos de questão
- ✅ Execução interativa via terminal
- ✅ Sistema de pontuação configurável
- ✅ Arquitetura extensível para novos tipos de pergunta

---

## 📄 Relatório Técnico

O arquivo [`Relatorio_Tecnico_Quiz_Framework.pdf`](./Relatorio_Tecnico_Quiz_Framework.pdf) contém:

- Descrição e motivação do projeto
- Diagrama de classes UML
- Detalhamento de cada padrão de projeto aplicado
- Justificativas de design e decisões arquiteturais

---

## 🛠️ Tecnologias

- **Java** — Linguagem principal
- **IntelliJ IDEA** — Ambiente de desenvolvimento
- **Paradigma OOP** — Herança, polimorfismo e encapsulamento
- **Padrões GoF** — Creational, Structural e Behavioral

---

