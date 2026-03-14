# Sistema de Gestão de Transportadora (Transportes Vrum Vrum)
Projeto desenvolvido para o Projeto Integrador (PI).
O objetivo deste projeto é implementar um sistema desktop em Java para gerenciamento de uma transportadora, permitindo cadastro e gerenciamento de clientes, motoristas, veículos, usuários e funcionários.
Nesta etapa do projeto foi realizada a refatoração do sistema, aplicando princípios de SOLID como separação de responsabilidades para preparar o sistema para futura implementação web.

# Tecnologias utilizadas
Java  com Java Swing  
MySQL  
JDBC  
NetBeans  

# Estrutura do Projeto
Src: Contendo os pacotes do projeto com suas respectivas classes/interfaces.
conexão: Responsável pela conexão com o banco de dados.
Model: Contém as entidades do sistema.
Dao: Responsável pelo acesso ao banco de dados.
Servisse: Contém as regras de negócio do sistema.
View: Responsável pela interface gráfica.

# Arquitetura
O projeto segue uma separação em camadas:
View - Interface gráfica (Swing)
Service - Regras de negócio
DAO - Acesso ao banco de dados
Model - Representação das entidades
Fluxo da aplicação:
Tela → Service → DAO → Banco de Dados

# Funcionalidades
Cadastro de clientes  
Cadastro de motoristas  
Cadastro de veículos  
Cadastro de usuários  
Cadastro de funcionários  
Login no sistema  

# Objetivo da Refatoração
Aplicar princípios SOLID no projeto:
Single Responsibility Principle (SRP)
Separar responsabilidades entre interface, regras de negócio e acesso ao banco.

# Testes rápidos no método Main()
Para verificar se a refatoração não quebrou a integração entre camadas, foi criado
um teste simples no método Main() de uma classe auxiliar. O objetivo foi conferir se
os serviços conseguem acessar os DAOs e listar registros do banco sem lançar exceções.

#CODE SMELL removido - (Classes DAO que faziam uso do JOptionPane)
Durante a refatoração também foi removido o uso de componentes de interface gráfica nas classes DAO, evitando dependência da camada de apresentação e respeitando o princípio da separação de responsabilidades.

# Autor

Juliano Santos

Projeto Integrador – Curso Técnico em Desenvolvimento de Sistemas SENAC-EAD
