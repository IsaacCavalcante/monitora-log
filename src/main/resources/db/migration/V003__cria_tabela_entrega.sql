CREATE TABLE `monitoralog`.`entrega` (
  `id` BIGINT(0) NOT NULL,
  `cliente_id` BIGINT(0) NOT NULL,
  `taxa` DECIMAL(10,2) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `data_pedido` DATETIME NOT NULL,
  `data_finalizacao` DATETIME NULL,
  `destinatario_nome` VARCHAR(60) NOT NULL,
  `destinatario_logradouro` VARCHAR(255) NOT NULL,
  `destinatario_numero` VARCHAR(30) NOT NULL,
  `destinatario_complemento` VARCHAR(60) NOT NULL,
  `destinatario_bairro` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_entrega_cliente_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_entrega_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `monitoralog`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
