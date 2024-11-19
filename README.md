Projeto Spring Boot

Este é um projeto desenvolvido com Spring Boot, um framework Java que simplifica o desenvolvimento de aplicações robustas e escaláveis. O projeto é configurado para servir como ponto de partida para criar aplicações baseadas em RESTful APIs.
🚀 Tecnologias

    Java 17+
📋 Pré-requisitos

    Java 17
    Banco de dados postgres
    rabiitMQ
    
🔧 Configuração
Clonando o Repositório

    git clone https://github.com/MatheusWith/MatheusWith.git
    cd EmailService
🛠️ Executando o Projeto

    mvn clean package
    java -jar /caminho para o app.jar gerado pelo comando anterior

  📋Nota:

    Para compilar o projeto gerando o jar é necessario o rabbit e o banco de dados
    Clone o serviço de email presente em https://github.com/MatheusWith/EmailService.git para uma pasta ao lado do projeto atual
    Excutando docker-compose up --build na pasta do presente projeto será criados os containers da aplicação
