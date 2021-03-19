# language: pt
@REQ0002-PersonalizarAcai
Funcionalidade: Personalizar o meu açaí com sucesso
  Como cliente do sistema de açaí personalizado
  Quero personalizar o meu pedido
  Para tornar o meu açaí do jeito que eu gosto

  Esquema do Cenário: Deve escolher a personalição extra granola
    Quando o cliente selecionar a personalização extra <extraGranola>
    Então o pedido será atualizado sem nenhum custo adicional

    Exemplos: 
      | extraGranola |
      | "Granola"    |

  Esquema do Cenário: Deve escolher a personalição extra leite ninho
    Quando o cliente selecionar a personalização extra <extraLeiteNinho>
    Então o pedido terá um adicional no valor de <valorAdicional>
    E o preço final do açaí será de <valorTotal>

    Exemplos: 
      | extraLeiteNinho | valorAdicional | valorTotal |
      | "Leite ninho"   |           3,00 |      18,00 |

  Esquema do Cenário: Deve escolher a personalição extra paçoca
    Quando o cliente selecionar a personalização extra <extraPacoca>
    Então o pedido terá um adicional no tempo de preparo <tempoAdicional>

    Exemplos: 
      | extraPacoca | tempoAdicional | valorTotal |
      | "Paçoca"    |              3 |      18,00 |
