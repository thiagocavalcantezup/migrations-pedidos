package br.com.zup.handora.migrationspedidos.pedido;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.handora.migrationspedidos.item.ItemRequest;

public class PedidoRequest {

    @NotNull
    @Positive
    private Long clienteId;

    @NotNull
    @Positive
    private Long estabelecimentoId;

    @NotEmpty
    private Set<ItemRequest> itens;

    public PedidoRequest() {}

    public PedidoRequest(@NotNull @Positive Long clienteId,
                         @NotNull @Positive Long estabelecimentoId,
                         @NotEmpty Set<ItemRequest> itens) {
        this.clienteId = clienteId;
        this.estabelecimentoId = estabelecimentoId;
        this.itens = itens;
    }

    public Pedido toModel() {
        Pedido pedido = new Pedido(clienteId, estabelecimentoId);

        itens.stream().map(ItemRequest::toModel).forEach(pedido::adicionar);

        return pedido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Long getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public Set<ItemRequest> getItens() {
        return itens;
    }

}
