# Usando a imagem oficial do PostgreSQL como base
FROM postgres:latest

# Definindo variáveis de ambiente para configuração do PostgreSQL
# Essas variáveis são usadas para configurar o banco de dados na criação do container
ENV POSTGRES_USER=user
ENV POSTGRES_PASSWORD=password
ENV POSTGRES_DB=logs_db

# Copiar scripts ou arquivos adicionais, se necessário
# COPY init.sql /docker-entrypoint-initdb.d/

# Expondo a porta 5432, que é a padrão do PostgreSQL
EXPOSE 5432

# O Docker automaticamente utiliza o entrypoint do PostgreSQL,
# então não precisamos adicionar comandos adicionais aqui
