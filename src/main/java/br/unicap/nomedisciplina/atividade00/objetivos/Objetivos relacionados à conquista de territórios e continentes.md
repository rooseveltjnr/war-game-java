<img src="https://portal.unicap.br/image/layout_set_logo?img_id=2214787&t=1707359594637" alt="drawing" width="300"/>

## Identificação
**Aluno**: Lucas Júlio Ribeiro de Aguiar

**Responsável por**: Todos os objetivos relacionados à conquista de territórios e continentes

**Projeto**: War C3

## Descrição da Atividade

No início do jogo: 
<ul>
  <li>Os jogadores fazem uma leitura de todos os objetivos possíveis</li>
  <li>Cada jogador então recebe, por sorteio, uma carta-objetivo</li>
  <li>Ao tomar conhecimento de seu objetivo, o jogador não revela a seus adversários</li>
</ul>

Eu sou responsável por apresentar todos os objetivos possíveis, sortear os objetivos entre os jogadores e certificar que um objetivo de território ou continente foi alcançado, determinando assim o vencedor.

## Detalhes importantes:
<ul>
  <li>Os objetivos restantes não serão utilizados no jogo</li>
  <li>No caso do número de jogadores ser inferior a 6, os objetivos relacionados com os exércitos não participantes devem ser excluídos do sorteio.</li>
  <p>Ex: Se ninguém escolher os exércitos amarelos, a carta-objetivo que manda destruir os exércitos amarelos deve ser retirada.</p>
</ul>

## Fim de jogo (objetivo alcançado)

<p> Caso algum objetivo de conquista de continentes ou territórios for alcançado, é declarado um vencedor e o jogo acaba.</p>

## Diagrama de Casos de Uso

![alt text](imagens/Untitled.jpg)

## Modelo de Domínio

![alt text](imagens/Modelo%20de%20Dominio%20(1).png)

## Especificação de casos de uso

|Caso de Uso CD1     |                |
|--------------------|----------------|
|Nome do Caso de Uso |Sorteio dos Objetivos|
|Escopo              |Projeto do Jogo War|
|Nível               |Objetivo do Usuário|
|Ator principal      |Participantes do Jogo| 
|Interessados e interesses|<p>Participantes do Jogo: Os participantes desejam descobrir qual será seu objetivo no jogo, o que é parte  fundamental do jogo War</p> <p>Sistema do Jogo: O sistema tem interesse de definir o objetivo dos participantes.</p>|
|Pré-condições       |<p> Todos os objetivos constam no sistema de jogo </p> <p> Os jogadores devem estar conectados ao sistema.</p> <p> |
|Garantia de sucesso | <p> Ao final do sorteio, todos participantes devem ter um objetivo</p> <p> Os objetivos que sobrarem não devem ser utilizados no jogo.</p>|
|Cenário de sucesso principal|<p> 1. Após iniciado, o sistema apresenta todos os objetivos possíveis aos jogadores.</p> <p>2. O sistema embaralha e sorteia os objetivos.</p> <p>3. Cada participante recebe um objetivo e o mesmo não pode ser revelado aos demais participantes.</p> <p> 4. Os jogadores confirmam ao sistema que receberam o objetivo e o sistema, por sua vez, registra os objetivos atribuídos a cada jogador. </p> <p> 5. O jogo está pronto para ser iniciado.</p>|
|Extensões|<p>1a. O sistema armazena objetivos de conquista de terrítorios ou continentes em sua memória, para que a cada início de jogo todos objetivos estejam disponíveis para sorteio.</p> <p>3a. Uma vez designados os objetivos, aqueles que sobrarem devem ser desconsiderados.</p> <p>3b. Sistema faz uma verificação para que participantes não recebam o mesmo objetivo e caso isso aconteça o sistema apresenta uma mensagem de erro e sorteio é realizado novamente.</p>|
|Requisitos especiais| <p> Sorteio é apresentado de forma interativa na tela do usuário, inclusive o seu objetivo designado.</p> <p> O participante deve poder escolher um idioma para jogar. </p> <p> O jogo deve poder ser jogado online atráves da escolha de um servidor designado para sua região. </p>
|Lista de Variantes Tecnológicas e de Dados|O sorteio pode ser realizado através de um clique ou comando de voz.
|Frequência da Ocorrência| O sorteio dos objetivos ocorre uma vez no início de cada partida do jogo.|


### Contrato de Operação

**Contrato CO1:** sorteiaObjetivo (Objetivo objetivoConquistaTerritorio, Objetivo objetivoConquistaContinente)

**Referências Cruzadas:** 
- Caso de Uso: Sortear Objetivos

**Pré-condições:**

- Todos os objetivos devem constar no sistema de jogo.
- Os jogadores devem estar conectados ao sistema.

**Pós-condições:**

- Criação de instâncias de objetos (objetivos atribuídos a cada jogador).
- Associações entre jogadores e seus objetivos.
- Modificações nos valores dos atributos (estado dos objetivos).

**Projeto de Objetos para a Pré-condição:**

Nessa fase, é preciso criar as instâncias de objetos necessárias antes de executar a operação. Com base nas pré-condições, tem-se os seguintes objetos:

- Objetivo: Representa um objetivo específico no jogo.
- Jogador: Representa um jogador conectado ao sistema. (Cada jogador deve ter uma lista de objetivos vazia inicialmente)

**Projeto de Objetos para a Pós-condição:**

Após a operação, tem-se as seguintes modificações nos objetos:

- Objetivo: Cada jogador terá objetivos atribuídos a eles.
- Jogador: Cada jogador estará associado aos objetivos que lhes foram sorteados.


## Diagrama de Comunicação

![alt text](imagens/Modelo%20de%20Fluxo%20de%20Processos%20de%20Negócios%20(1).jpeg)

## Diagrama de Classes

![alt text](imagens/Classe%20UML.jpeg)