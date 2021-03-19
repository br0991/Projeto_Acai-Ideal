package br.acai_ideal_steps;

import static br.acai_ideal_steps.EscolherAcai.cal;
import static br.acai_ideal_steps.EscolherAcai.pedido;
import static br.acai_ideal_steps.EscolherAcai.sabor;
import static br.acai_ideal_steps.EscolherAcai.tamanho;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import br.acai_ideal_enums.Extras;
import br.acai_ideal_services.Pedido;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class PersonalizarAcai {

	private Extras ingredienteExtra;

	@Quando("^o cliente selecionar a personalização extra \"(.*)\"$")
	public void oClienteSelecionarAPersonalizaçãoExtra(String extra) throws Throwable {

		if (extra.equals("Granola")) {

			ingredienteExtra = Extras.valueOf((extra.toUpperCase()));
			pedido.setIngredienteExtra(ingredienteExtra);

		} else if (extra.equals("Paçoca")) {

			ingredienteExtra = Extras.valueOf((extra.toUpperCase()));
			pedido.setIngredienteExtra(ingredienteExtra);

		} else {

			String[] field = extra.toUpperCase().split(" ");
			ingredienteExtra = Extras.valueOf(field[0] + "_" + field[1]);
			pedido.setIngredienteExtra(ingredienteExtra);

		}
	}

	@Então("^o pedido terá um adicional no valor de (\\d{1}.\\d{2})$")
	public void oPedidoTeráUmAdicionalNoValorDe(Double valorAdicional) throws Throwable {

		pedido.setValorDoPedido(pedido.getValorDoPedido() + valorAdicional);

	}

	@Então("^o preço final do açaí será de (\\d{2}.\\d{2})$")
	public void oPreçoFinalDoAçaíSeráDe(Double valorFinal) throws Throwable {

		assertEquals(valorFinal, pedido.getValorDoPedido());
		System.out.println(pedido);
	}

	@Então("^o pedido será atualizado sem nenhum custo adicional$")
	public void oPedidoSeráAtualizadoSemNenhumCustoAdicional() throws Throwable {

		System.out.println(pedido);
	}

	@Então("^o pedido terá um adicional no tempo de preparo (\\d+)$")
	public void oPedidoTeráUmAdicionalNoTempoDePreparo(int tempoAdicional) throws Throwable {

		pedido = new Pedido();
		cal.add(Calendar.MINUTE, tempoAdicional);
		pedido.addAoPedido(tamanho.getTamanhoDoPode(), sabor.name(), cal.getTime());
		pedido.setValorDoPedido(15.00);
		assertEquals(tempoAdicional, 3);
		System.out.println(pedido);
	}
}
