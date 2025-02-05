## Identificação
**Aluno**: Roosevelt Bispo dos Santos Junior

**Responsável por**: Realização de uma jogada e fase de povoamento de um território recentemente conquistado

**Projeto**: War C3

## Descrição da Atividade
Durante a fase de jogo, acontecem 2 ações principais:
- Realização de uma jogada de ataque ou movimentação
- Povoamento de um território recentemente conquistado

Minha função é garantir que essas ações sejam realizadas corretamente durante o turno de um jogador.

## Objetivos a serem alcançados:
1. Realizar uma jogada de ataque ou movimentação conforme as regras do jogo
2. Povoar um território recentemente conquistado com exércitos

## Como funciona: 
### **Realização de uma Jogada**
Durante seu turno, o jogador pode optar por realizar uma jogada de ataque a um território adjacente ou movimentar exércitos entre territórios conquistados. As jogadas de ataque seguem as regras de combate do jogo, enquanto as movimentações permitem o reforço de territórios conforme a estratégia do jogador.

### **Povoamento de um Território**
Após a conquista de um território, o jogador tem a opção de povoá-lo movendo um número de exércitos para o novo território. Este processo é crucial para fortalecer a presença do jogador no território conquistado e prepará-lo para defesa contra ataques futuros.

## Contrato de Operação

### Operação: realizarJogada (jogador: Jogador, origem: Territorio, destino: Territorio)

**Referências Cruzadas:** Casos de Uso: Jogada, Povoamento de Território

**Pré-Condições:** 
- O jogador deve ter exércitos disponíveis no território de origem.
- O território de origem e o território de destino devem ser adjacentes.
- O jogador deve estar no estado de ataque.
- O jogador deve possuir o território de origem.
- O território de destino deve ser conquistável (não exceder o número máximo de exércitos).

**Pós-Condições:**
- A quantidade de exércitos no território de origem foi atualizada (reduzida).
- A quantidade de exércitos no território de destino foi atualizada (aumentada).
- O estado do jogo é alterado para "povoamento" se o território de destino foi conquistado.
- O território de destino pode ser associado ao jogador se for conquistado (modificação de propriedade).

### Operação: povoarTerritorio (jogador: Jogador, territorio: Territorio, quantidade: int)

**Referências Cruzadas:** Casos de Uso: Povoamento de Território

**Pré-Condições:** 
- O jogador deve possuir o território.
- O jogador deve estar no estado de povoamento.
- A quantidade de exércitos a ser movida deve ser válida (entre 1 e 3).

**Pós-Condições:**
- A quantidade de exércitos no território foi atualizada (aumentada).
- A quantidade de exércitos disponíveis do jogador foi atualizada (reduzida).

## Diagrama de Classes

![image](https://github.com/c3-disciplina-eng2/2024-1-minf-0601-projeto-war-c3/assets/101573032/966713d0-d229-4a1e-9139-6817d7174138)  
