<img src="https://portal.unicap.br/image/layout_set_logo?img_id=2214787&t=1707359594637" alt="drawing" width="300"/>

## Identificação
**Aluno**: Ricardo Cavalcanti De Melo Costa

**Responsável por**: Coordenação da fase de ataque entre territórios

**Projeto**: War C3

## Descrição da Atividade

Durante a fase de ataque entre territórios: 
<ul>
  <li>Para realizar um ataque a partir de um território, é necessário que haja pelo menos 1 exército em cada território ocupado. Assim, para atacar a partir de um território, são necessários pelo menos 4 exércitos neste mesmo território, excluindo o exército de ocupação, que não tem o direito de atacar.</li>
  <li>O ataque só pode ser direcionado a um território adversário que tenha fronteiras em comum (território contíguo) ou seja ligado por um pontilhado (como a Terra é redonda, pode-se atacar, por exemplo, do Alasca para o Japão e vice-versa).</li>
  <li>O número de exércitos que poderá participar de um ataque será igual ao número de exércitos situados no território atacante menos um, sendo o máximo de 3, mesmo que o número de exércitos possuídos no território seja superior a 4.</li>
<li>Um jogador pode atacar tantas vezes quantas quiser para conquistar um território adversário, até ficar com apenas um exército no seu território ou, ainda, até quando achar conveniente não atacar.</li>
<li>Na sua vez de jogar, cada participante pode realizar ataques partindo de um ou vários territórios, de acordo com sua estratégia. Se ele quiser atacar de mais de um território, deve indicar antes de qual território partirá o ataque e contra qual território será feito.</li>
<li>Após um ataque, o jogador poderá iniciar outro ataque a partir do mesmo ou outro território que lhe pertença.</li>
<li>O número máximo de exércitos que a defesa pode usar em cada batalha é de no máximo 3 e no mínimo 0 (podendo utilizar inclusive o exército de ocupação).</li>
<li>O jogador atacante jogará com tantos dados quantos forem seus exércitos participantes da batalha, o mesmo ocorrendo com o jogador da defesa.</li>
<li>Após uma batalha, a decisão de quem ganha e quem perde exércitos é feita comparando-se o maior ponto do dado atacante com o maior ponto do dado defensor, e assim sucessivamente até resolver todos os dados. O vencedor é quem tiver os maiores resultados em todas as comparações.</li>
<li>Após uma batalha, o atacante retira do território atacante um número de exércitos igual ao número de derrotas sofridas na batalha, enquanto o defensor retira do território defensor um número de exércitos igual ao número de derrotas sofridas na batalha.</li>
</ul>

Eu sou responsável por garantir que os ataques sejam realizados de maneira correta e justa, seguindo as regras estipuladas pelo jogo. Devo resolver eventuais disputas ou dúvidas sobre os resultados dos ataques, assegurando que todas as jogadas sejam transparentes e respeitem as regras do jogo.

## Detalhes importantes:
<ul>
  <li>O sistema não permitirá que jogador atque um pais não adjacente.</li>
  <li>O sitema só permitirá o ataque se o jogador tiver mais que um soldado</li>
</ul>

## Finalização da fase de ataque:

<p> A fase de ataque entre territórios termina quando todos os jogadores tiverem concluído seus ataques ou decidirem voluntariamente não realizar mais ataques.

## Especificação de casos de uso

|Caso de Uso CD1     |                |
|--------------------|----------------|
|Nome do Caso de Uso |Fase de ataque|
|Escopo              |Projeto do Jogo War|
|Nível               |Ataque do pais vizinho|
|Ator principal      |Participantes do Jogo| 
|Interessados e interesses|<p>Participantes do Jogo: Os participantes terão que concluir o objetivo por meio da realização de ataques nos países adversários vizinhos.</p> <p>Sistema do Jogo: O sistema tem interesse de analisar se o pais desejavel para o ataque é vizinho de pelo menos um pais do jogador</p>|
|Pré-condições       |<p> Todos os jogadores terão a possiblidade de atacar quando chegar a sua vez </p> <p> Os jogadores devem estar conectados ao sistema.</p> <p> |
|Garantia de sucesso | <p> Se a maior pontuação dos dados for para o jogador atacante</p> <p> Se a maior pontuação dos dados for para o jogador defensor, a fase de ataque é finalizado sem sucesso.</p>|
|Cenário de sucesso principal|<p> 1. Após a vitória do ataque, o jogador move pelo menos um soldado para o seu novo território.</p> <p>2. O sistema permite que o jogador realize outro ataque.</p> <p>3. As fases de taque para cada jogador serão finalizadas com a decisão do próprio jogador.</p> <p> 4. Após a fase de ataque de um jogador específico, a vez será passado para o próximo jogador.</p>|
|Extensões|<p>O sistema armazena a numeração e a quantidade de dados para o sorteio de ataque.</p>|
|Requisitos especiais| <p> Sorteio é apresentado de forma interativa na tela do usuário, inclusive o seu objetivo designado.</p> <p> O participante deve poder escolher um idioma para jogar. </p> <p> O jogo deve poder ser jogado online atráves da escolha de um servidor designado para sua região. </p>
|Lista de Variantes Tecnológicas e de Dados| <p> O sorteio pode ser realizado através de um clique ou comando de voz.</p>
|Frequência da Ocorrência| O sorteio dos dados ocorre uma ou mais vezes na rodada de cada jogador.|