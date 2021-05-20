ALTER TABLE `monitoralog`.`entrega`
MODIFY COLUMN `id` BIGINT;
ALTER TABLE `monitoralog`.`entrega`
MODIFY COLUMN `cliente_id` BIGINT;
ALTER TABLE `monitoralog`.`entrega`
MODIFY COLUMN `destinatario_complemento` VARCHAR(60);