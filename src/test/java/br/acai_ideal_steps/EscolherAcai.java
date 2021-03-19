package br.acai_ideal_steps;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import br.acai_ideal_entities.TamanhoAcai;
import br.acai_ideal_enums.SaborAcai;
import br.acai_ideal_exceptions.AlertException;
import br.acai_ideal_services.Pedido;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class EscolherAcai {

	public static SaborAcai sabor;
	public static TamanhoAcai tamanho;
	private AlertException mensagemDealerta;
	public static Pedido pedido;
	public static Calendar cal = Calendar.getInstance();

	@Dado("^que o cliente selecionou o sabor \"(.*)\"$")
	public void queOClienteSelecionouOSabor(String tipoSabor) throws Throwable {

		if (tipoSabor.equals("Morango")) {

			sabor = SaborAcai.valueOf((tipoSabor.toUpperCase()));

		} else if (tipoSabor.equals("Banana")) {

			sabor = SaborAcai.valueOf((tipoSabor.toUpperCase()));

		} else {

			sabor = SaborAcai.valueOf((tipoSabor.toUpperCase()));

		}
	}

	@Dado("^selecionou o tamanho \"(.*)\"$")
	public void selecionouOTamanho(String tipoTamanho) throws Throwable {

		tamanho = new TamanhoAcai();
		tamanho.setTamanhoDoPote(tipoTamanho);

		if (sabor.equals(SaborAcai.KIWI) && tipoTamanho.equals("Pequeno")) {

			cal.add(Calendar.MINUTE, 10);
		} else if (sabor.equals(SaborAcai.KIWI) && tipoTamanho.equals("Médio")) {

			cal.add(Calendar.MINUTE, 12);

		} else if (sabor.equals(SaborAcai.KIWI) && tipoTamanho.equals("Grande")) {

			cal.add(Calendar.MINUTE, 15);

		} else if (!sabor.equals(SaborAcai.KIWI) && (tipoTamanho.equals("Pequeno"))) {

			cal.add(Calendar.MINUTE, 5);
		} else if (!sabor.equals(SaborAcai.KIWI) && (tipoTamanho.equals("Médio"))) {

			cal.add(Calendar.MINUTE, 7);
		} else if (!sabor.equals(SaborAcai.KIWI) && (tipoTamanho.equals("Grande"))) {

			cal.add(Calendar.MINUTE, 10);
		}
		cal.getTime();
	}

	@Quando("^finalizado o pedido$")
	public void finalizadoOPedido() throws Throwable {

		pedido = new Pedido();
		pedido.addAoPedido(tamanho.getTamanhoDoPode(), sabor.name(), cal.getTime());
	}

	@Então("^o valor do açaí será de (\\d{2}.\\d{2})$")
	public void oValorDoAçaíSeráDe(Double valor) throws Throwable {

		pedido.setValorDoPedido(valor);
		assertEquals(valor, pedido.getValorDoPedido());
		System.out.println(pedido);
	}

	@Quando("^o cliente desejar incluir um novo pedido$")
	public void oClienteDesejarIncluirUmNovoPedido() throws AlertException {

		Pedido outroPedido = new Pedido();
		if (outroPedido.equals(outroPedido)) {

			mensagemDealerta = new AlertException("O pedido atual deve ser finalizado primeiro");
		}
	}

	@Quando("^o cliente selecionar \"(.*)\"$")
	public void oClienteSelecionar(String outroSabor) throws AlertException {

		sabor = SaborAcai.valueOf(outroSabor.toUpperCase());
		if (!sabor.name().isEmpty()) {

			mensagemDealerta = new AlertException("Não é possível selecionar outro sabor para o mesmo pedido");
		}
	}

	@Então("^a mensagem \"(.*)\" será exibida$")
	public void aMensagemSeráExibida(String alerta) throws Throwable {

		assertEquals(alerta, mensagemDealerta.getLocalizedMessage());
	}

}