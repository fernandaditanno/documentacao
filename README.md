# documentacao

## Gestao de documentos
<sup>Plataforma para gestão e versionamento de documentos, oferecendo uma abordagem simplificada e eficiente para organização, controle e rastreamento de alterações.</sup>

### Estrutura

> Documento: 
> * Id, Titulo, Descricao, Versao, Sigla, Fase.
> * Fase (MINUTA /VIGENTE/ OBSOLETO)
> * SIGLA + FASE =>  Chave exclusiva para cada registro
> * CRUD :  Criar, Editar, Excluir e Ler registros

### Requisitos

* Regras adicionais: Copia de um registro somando ao numero de varsao mais um
* Para o documento alterado de minuta para vigente, validar o mesmo documento vigente e alterar ele para obsoleto.

### Sistema

 - Backend desenvolvido em api java 22 com spring boot e maven. 
 - Frontend desenvolvido em Angular usando material deisgn.



