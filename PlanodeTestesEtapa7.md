Plano de Testes – Sistema Java Desktop "Transportadora Vrum Vrum"

1. Objetivo
Validar as funcionalidades do sistema desktop, garantindo o correto funcionamento do CRUD, login, integração com banco de dados e interface gráfica.

2. Escopo
O plano cobre os módulos: Cliente, Funcionário, Motorista, Veículo, Usuário (login) e Navegação do sistema.

3. Tipos de Teste
- Testes Funcionais
- Testes de Interface (GUI)
- Testes de Integração (DAO + Banco)

4. Casos de Teste
CT01 – Login válido: Acesso permitido ao sistema
CT02 – Login inválido: Exibir mensagem de erro
CT03 – Campos vazios no login: Bloquear acesso
CT10 – Cadastro de cliente válido: Salvar no banco
CT11 – Cadastro com campos vazios: Exibir erro
CT12 – Listagem de clientes: Exibir dados corretamente
CT13 – Atualização de cliente: Persistir alteração
CT14 – Exclusão de cliente: Remover do banco
CT20 – Cadastro de veículo: Inserção correta
CT21 – Veículo duplicado: Bloquear ou alertar
CT30 – Cadastro de funcionário: Dados válidos
CT40 – Cadastro de motorista: Dados válidos
CT50 – Criação de usuário: Login funcional
CT60 – Teste DAO: Inserção, consulta, atualização e exclusão
CT70 – Teste de interface: Botões e navegação
CT80 – Falha de conexão: Exibir erro sem travar sistema

5. Critérios de Aceitação
O sistema será considerado aprovado se todas as funcionalidades funcionarem sem erros críticos, com dados persistindo corretamente e interface responsiva.
