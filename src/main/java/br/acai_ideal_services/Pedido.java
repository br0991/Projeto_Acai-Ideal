package br.acai_ideal_services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.acai_ideal_enums.Extras;

public class Pedido {

	private List<Object> pedidos = new ArrayList<>();
	private Extras ingredienteExtra;
	private Double valorDoPedido;
	static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public List<Object> getPedido() {
		return pedidos;
	}

	public Double getValorDoPedido() {
		return valorDoPedido;
	}

	public void setValorDoPedido(Double valorDoPedido) {
		this.valorDoPedido = valorDoPedido;
	}

	public Extras getIngredienteExtra() {
		return ingredienteExtra;
	}

	public void setIngredienteExtra(Extras ingredienteExtra) {
		this.ingredienteExtra = ingredienteExtra;
	}

	public void addAoPedido(String tamanho, String sabor, Date tempoDePreparo) {

		
		pedidos.add(tamanho);
		pedidos.add(sabor);
		pedidos.add(dateFormat.format(tempoDePreparo));
	}

	public String toString() {
		StringBuilder build = new StringBuilder();

		build.append("\n\n");
		build.append("***DETALHES DO PEDIDO***: " + "\n");
		build.append("Tamanho.: " + pedidos.get(0) + "\n");
		build.append("Sabor.: " + pedidos.get(1) + "\n");
		build.append("Tempo de preparo.: " + pedidos.get(2) + "\n");
		if (ingredienteExtra == null) {

			build.append("Valor Total.: " + String.format("%.2f", valorDoPedido) + "\n");
		} else {

			build.append("Valor Total (ATUALIZADO).: " + String.format("%.2f", valorDoPedido) + "\n");
			build.append("Personalizações.: " + ingredienteExtra);
		}
		return build.toString();
	}
}
