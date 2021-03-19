# language: pt
@REQ0001-EscolherAcai
Funcionalidade: Montar o açaí ideal com sucesso
  Como cliente do sistema de açaí personalizado
  Quero montar um açaí ideal
  Para que eu sacie minha vontade

  Esquema do Cenário: Deve escolher o tipo do açaí sem personalição extra
    Dado que o cliente selecionou o sabor <tipoSabor>
    E selecionou o tamanho <tipoTamanho>
    Quando finalizado o pedido
    Então o valor do açaí será de <valorDoPedido>

    Exemplos: 
      | tipoSabor | tipoTamanho | tempo | valorDoPedido |
      | "Morango" | "Pequeno"   |     5 |         10,00 |
      | "Banana"  | "Médio"     |     7 |         13,00 |
      | "Kiwi"    | "Grande"    |    10 |         15,00 |

  Esquema do Cenário: Deve escolher somente um açaí por pedido
    Quando o cliente desejar incluir um novo pedido
    Então a mensagem <mensagemAlertaPedido> será exibida

    Exemplos: 
      | mensagemAlertaPedido                          |
      | "O pedido atual deve ser finalizado primeiro" |

  Esquema do Cenário: Deve escolher somente um sabor
    Quando o cliente selecionar <outroSabor>
    Então a mensagem <mensagemAlertaSabor> será exibida

    Exemplos: 
      | outroSabor | mensagemAlertaSabor                                         |
      | "Banana"   | "Não é possível selecionar outro sabor para o mesmo pedido" |
