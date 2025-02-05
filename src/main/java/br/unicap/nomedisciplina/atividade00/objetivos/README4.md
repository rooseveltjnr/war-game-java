<img src="https://portal.unicap.br/image/layout_set_logo?img_id=2214787&t=1707359594637" alt="drawing" width="200"/>

## Identificação
**Aluno**: Luiz Fernando Soares Ximenes Accioly

**Responsável por**: Iniciar o jogo 

**Projeto**: War C3

## Testes para criar

<ul>
  <li>Teste território: Nome, Jogador dono e exércitos</li>
  <li>Teste jogador: N Territórios e cartas</li>
  <li>Testar se cada player tem um objetivo</li>
</ul>

## Como funciona: 
<div>
<h3><b>Iniciando jogo</b></h3>
<ol>
<li>No inicio do jogo é necessário:</li>
<li>Que todos os paises possuam ao menos 1 exército</li>
<li>Os players tenham exatamente 1 objetivo</li>
</ol>
</div>


## Diagrama de classes:
![Caso de uso](https://github.com/c3-disciplina-eng2/2024-1-minf-0601-projeto-war-c3/assets/86210723/2ed87c24-6fbf-4e0f-9997-559c98bc5d35)

|Caso de Uso CD1     |                |
|--------------------|----------------|
|Nome do Caso de Uso |Inicialização do Jogo|
|Escopo              |Projeto do Jogo War|
|Nível               |Objetivo do Usuário|
|Ator principal      |Participantes do Jogo| 
|Interessados e interesses|Jogador: Deseja eliminar adversários específicos para cumprir objetivos e potencialmente ganhar vantagens no jogo. Adversários: Querem evitar ser eliminados e podem tomar ações para se proteger. Sistema: Deve validar as eliminações e garantir que elas sigam as regras do jogo.|
|Pré-condições       |O sistema está pronto para iniciar um novo jogo. Com o diagrama de classes todos conferidos.<br>Os jogadores estão definidos e prontos para iniciar.|
|Garantia de sucesso |Os jogadores têm seus territórios e exércitos iniciais distribuídos equitativamente.<br>O jogo está pronto para entrar na fase seguinte.|
|Cenário de sucesso principal|1. O sistema solicita o número de jogadores.<br>2. Os jogadores fornecem seus nomes e selecionam suas cores.<br>3. O sistema gera o tabuleiro e distribui os territórios equitativamente entre os jogadores.<br>4. O sistema calcula e distribui o número inicial de exércitos para cada jogador.<br>5. Os jogadores posicionam seus exércitos nos territórios atribuídos.<br>6. O sistema confirma que a inicialização está completa e o jogo pode começar.|
|Requisitos especiais           |A distribuição de territórios e exércitos deve ser feita de maneira aleatória|


