package br.com.zup.handora.migrationspedidos.item;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class ItemRequest {

    @NotBlank
    private String sku;

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @Positive
    private Integer quantidade;

    public ItemRequest() {}

    public ItemRequest(@NotBlank String sku, @NotNull @PositiveOrZero BigDecimal valor,
                       @Positive Integer quantidade) {
        this.sku = sku;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Item toModel() {
        return new Item(sku, valor, quantidade);
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

}
