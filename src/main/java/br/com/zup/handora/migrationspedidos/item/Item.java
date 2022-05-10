package br.com.zup.handora.migrationspedidos.item;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.handora.migrationspedidos.pedido.Pedido;

@Entity
@Table(name = "itens")
public class Item {

    @Id
    private String sku;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(optional = false)
    private Pedido pedido;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Item() {}

    public Item(String sku, BigDecimal valor, Integer quantidade) {
        this.sku = sku;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
