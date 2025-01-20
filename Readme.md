Prioridade: definida pelo score do motorista, tipo de veículo e distância entre o parceiro e a loja.
Valor da rota: ajustado com base na distância do motorista até a loja e limitado por um valor mínimo.
Dinâmica da distribuição: a rota é oferecida sequencialmente aos motoristas habilitados, recalculando a prioridade caso haja recusas.
Quando um motorista aceita a rota, ela é removida da fila de distribuição, e a próxima rota é oferecida aos demais motoristas. 
Além disso, o tempo estimado da rota varia de acordo com o tipo de veículo (moto ou bicicleta).


Algumas Regras Implementadas:

Atributos de motoristas: nome, tipo de veículo (moto ou bicicleta), modelo (caso seja moto), score (1 a 3) e posição. Esses dados são usados para determinar a prioridade.
Atributos de rotas: nome da loja parceira, distância da loja até o cliente, status (rota aceita ou não), entre outros dados dinâmicos em casos reais, como localização para 
cálculos de proximidade.
Cálculo Do tempo aproximado para a rota ser concluída:
     	tempo da rota leva em consideração se o parceira esta de moto ou não, se não estiver de moto, o tempo para
       	finalização da rota aumenta significativamente, leva em consideração a velocidade padrão de um veiculo entre 40 e 60 por hora.
