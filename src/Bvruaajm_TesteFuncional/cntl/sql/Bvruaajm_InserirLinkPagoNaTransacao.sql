INSERT INTO BVR.TRANSACAO (COD_LINK_PGTO, COD_TRANSACAO, VALOR, STATUS, DATA_HORA_TRANSACAO,  IP_COMPRADOR, FORMA_PGTO, NOME_COMPRADOR, NSU_BERGS, NUM_PARCELAS, CPF_COMPRADOR, DDD_COMPRADOR, TELEFONE_COMPRADOR, EMAIL_COMPRADOR, NSU_AUTORIZADOR, CPF_CNPJ_LOJISTA, TIPO_PESSOA_LOJISTA, DESCR_BANDEIRA, SUFIXO_CARTAO, BANDEIRA) VALUES ($codLink$, 1, $valor$, 'P',TO_TIMESTAMP('$dataPag$','DD/MM/YYYY HH24:MI:SS.XFF'), '10.8.2.19', 'C', '$nomeComprador$', 9999, 1, 03859866028, 51, 999999999, 'TESTE@TESTE.COM', 999999, 110560000107, 'J', 'Visa', 0148, 'V')