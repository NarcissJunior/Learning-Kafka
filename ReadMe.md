
<b>Este Projeto foi desenvolvido com a finalidade de aprendizado.</b>

Apache Kafka é uma plataforma open-source e distribuída de processamento de streams desenvolvida pela Apache Software Foundation, escrita em Scala e Java.
O Apache Kafka foi originalmente desenvolvido pelo LinkedIn, e teve, posteriormente, seu código aberto no início de 2011.
Em novembro de 2014, Jun Rao, Jay Kreps, e Neha Narkhede, que trabalharam com o Kafka no LinkedIn, criaram uma nova empresa chamada Confluent com foco em Kafka.


Sendo assim, ele pode ser entendido como uma plataforma distribuída de mensagens e streaming.
Ele serve como um mecanismo de transmissão de dados e possui a capacidade de ser facilmente escalável e seguro quanto a erros.
Com ele é possível mover e transformar um grande volume de dados em tempo real entre diferentes sistemas.


O funcionamento do kafka pode ser explicado com o seguinte fluxo:

Um produtor gera uma mensagem.
Um tópico do kafka recebe esta mensagem e a armazena.
Consumidores se inscrevem nesses tópicos e podem consumir (sem excluir) essas mensagens.

Tendo isso em mente, podemos partir para os conceitos para que o entendimento fique mais claro.

<b>Mensagens:</b>
<br>
A mensagem é o principal recurso do Kafka. Todo o fluxo acima pode ser resumido à estas mensagens que são enviadas.
As mensagens podem sem ser de vários tipos de dados, por exemplo, uma string pura ou um json com informações de um objeto.
É necessário ter em mente que diferentes tipos de dados, precisam de diferentes conversões para que o kafka possa ser capaz de lidar com as mensagens.
Uma mensagem pode também ser composta por uma chave (key/value), que é utilizada para sharding e compactação dentro do Kafka.
Assim em um ambiente distribuído, é garantido a ordem das mensagens uma vez que mensagens com a mesma chaves são direcionadas para uma única partição do Kafka.

<b>Tópicos:</b>
<br>
Tópico pode ser entendido como um grupo de mensagens dentro do Kafka. Todas as mensagens enviadas pelos produtores ficam armazenadas nos tópicos e podem ser consumidas.
Para manter a ordenação do ecossistema, os tópicos possuem partições e fatores de replicação. Um tópico pode possuir n partições, mas ao receber uma nova mensagem o Kafka automaticamente direciona aquela mensagem para uma partição específica dependendo de sua chave (key).
Assim mensagens de uma mesma chave estarão apenas em uma única partição, garantindo assim a leitura ordenada de todas as mensagens de um tópico.

<b>Producers:</b>
<br>
Um Kafka Producer é responsável por enviar uma mensagem para um tópico específico. De forma simples, você pode produzir uma mensagem em um tópico.
Uma vez que uma mensagem é produzida em um tópico o próprio Kafka organiza a mensagem em uma partição, garantindo sempre a ordem das mensagens produzidas, como citado anteriormente.

<b>Consumers:</b>
<br>
É o responsável por ler as mensagens dos tópicos. É importante ressaltar que após um consumer ler uma mensagem, ela NÃO é retirada do tópico.
Você pode ter diversos consumers ouvindo o mesmo tópico, isso garante que uma mensagem enviada por um producer, possa ser lida por todos que assinaram aquele tópico.
Você também pode escolher ter vários consumers lendo o mesmo tópico e na mesma partição, para escalar sua aplicação por exemplo, neste caso estes consumers fariam parte de um Consumer Group, e compartilharão sempre a posição final de leitura entre eles (offsets).

<b>Apache Zookeeper:</b>
<br>
O Zookeeper é um serviço centralizado para, entre outras coisas, coordenação de sistemas distribuídos. O Kafka é um sistema distribuído, e consequentemente delega diversas funções de gerenciamento e coordenação para o Zookeeper.
Eles possuem uma dependência muito forte, mas isso não é tão ruim. O Kafka pode fazer o que ele intencionalmente tem que saber fazer de melhor, delegando essas demais funcionalidades para quem sabe fazer isso bem, sem precisar reinventar a roda.
