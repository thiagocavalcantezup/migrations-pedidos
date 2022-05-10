package br.com.zup.handora.migrationspedidos.pedido;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.zup.handora.migrationspedidos.item.Item;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long clienteId;

    @Column(nullable = false)
    private Long estabelecimentoId;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now();

    @OneToMany(mappedBy = "pedido", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Item> itens = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Pedido() {}

    public Pedido(Long clienteId, Long estabelecimentoId) {
        this.clienteId = clienteId;
        this.estabelecimentoId = estabelecimentoId;
    }

    public void adicionar(Item item) {
        item.setPedido(this);
        this.itens.add(item);
    }

    public Long getId() {
        return id;
    }

}
