-- Consulta qual o cartão mais próximo esta para vencer
SELECT cartao.cartao_id AS "Código do Cartão",
    cartao.vencimento AS "Vencimento",
    cliente.nome AS "Nome",
    cliente.cpf AS "CPF",
    cliente.telefone AS "Telefone"
    FROM cartao
    INNER JOIN cliente ON cartao.cliente_id = cliente.cliente_id
    ORDER BY cartao.vencimento; 