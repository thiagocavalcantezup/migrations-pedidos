CREATE TABLE itens (
  sku VARCHAR(255) NOT NULL PRIMARY KEY,
  valor DECIMAL(19, 2) NOT NULL,
  quantidade INTEGER NOT NULL,
  pedido_id BIGINT NOT NULL
)