ALTER TABLE
  itens
ADD
  CONSTRAINT FK_ITEM_PEDIDO_ID FOREIGN KEY (pedido_id) REFERENCES pedidos
