package br.com.zup.handora.migrationspedidos.pedido;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(PedidoController.BASE_URI)
public class PedidoController {

    public final static String BASE_URI = "/pedidos";

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PedidoRequest pedidoRequest,
                                    UriComponentsBuilder ucb) {
        Pedido pedido = pedidoRepository.save(pedidoRequest.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(pedido.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
