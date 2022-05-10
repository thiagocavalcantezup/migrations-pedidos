package br.com.zup.handora.migrationspedidos.pedido;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class PedidoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveriaCadastrarUmPedido() throws Exception {
        String pedidoRequestJson = "{\n" + "    \"clienteId\": \"1\",\n"
                + "    \"estabelecimentoId\": \"2\",\n" + "    \"itens\":\n" + "    [\n"
                + "        {\n" + "            \"sku\": \"123456\",\n"
                + "            \"valor\": 2.00,\n" + "            \"quantidade\": 3\n"
                + "        },\n" + "        {\n" + "            \"sku\": \"987654\",\n"
                + "            \"valor\": 12.00,\n" + "            \"quantidade\": 2\n"
                + "        }\n" + "    ]\n" + "}";

        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        mockMvc.perform(
            post(PedidoController.BASE_URI).contentType(MediaType.APPLICATION_JSON)
                                           .content(pedidoRequestJson)
        )
               .andExpect(status().isCreated())
               .andExpect(header().string("location", baseUrl + PedidoController.BASE_URI + "/1"));
    }

}
