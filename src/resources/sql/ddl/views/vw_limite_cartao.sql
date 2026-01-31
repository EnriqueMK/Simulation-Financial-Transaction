-- Consulta limites dos clientes em ordem decrescente
SELECT cartao.cartao_id AS "Código do Cartão",
    cartao.limite AS "Limite",
    cliente.nome AS "Nome",
    cliente.cpf AS "CPF",
    cliente.telefone AS "Telefone"
    FROM cartao
    INNER JOIN cliente ON cartao.cliente_id = cliente.cliente_id
    ORDER BY cartao.limite DESC;
