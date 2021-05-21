CREATE TABLE `monitoralog`.`Ocorrencia` (
  `id` BIGINT NOT NULL,
  `entrega_id` BIGINT NOT NULL,
  `descricao` TEXT NOT NULL,
  `data_registro` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_entrega_ocorrencia_idx` (`entrega_id` ASC) VISIBLE,
  CONSTRAINT `fk_entrega_ocorrencia`
    FOREIGN KEY (`entrega_id`)
    REFERENCES `monitoralog`.`entrega` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
