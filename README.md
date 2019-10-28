# Benchmark-api 
Este software foi elaborado para o Trabalho de Conclusão de Curso da PUC Minas
Onde o foco é realizar um teste de benchmark comparando um ambiente Docker x Virtualização tradicional.
Este código foi desenvolvido utilizando Java JDK 8 e Framework Spring Boot vesão 2.2.0

# Requisitos
* Java 8 JDK / Java 8 SDK
* Tomcat 9
* MySql Server

# Instalação
Para instalar clone o código em sua pasta de preferencia.
* Abra o terminal ou na sua IDE importe o projeto utilizando o "Maven Exist Projects".
* Abra o arquivo "aplication.propperties" em (SRC->Main->Resources) configure seu banco de dados de acordo com o arquivo.
* Após configurar o seu projeto e escolher o banco de dados corretamente, execute o comando:

*$ mvn clean package
  
*Abra o painel do MySql e Execute os script no banco.
  * CREATE DATABASE benchmark;  
  * CREATE TABLE pessoa (id int NOT NULL AUTO_INCREMENT, 
    nome varchar(100) NOT NULL, 
    sobre_nome varchar(100) NOT NULL, 
    email varchar(150) NOT NULL,
    PRIMARY KEY (id));
* Após criar o banco, e a tabela pessoa, vá na pasta "target" dentro do fonte do projeto e copie o "benchmark-0.0.1-SNAPSHOT.war"
para a pasta "webapps" do seu tomcat.

* Inicie seu tomcat utilizando entrando na pasta "bin" e executando o "startup.bat" (windows) ou no terminal do linux executando
$ sh startup.sh
assim que o tomcat iniciar pode realizar os testes.

# Utilização
* Recomendo utilizar o Postman para realizar as requisições ou outro consumidor de api de sua preferência.

Endpoints:
* Boas vindas: 'GET': http://SeuServidor:8080/
* Upload de arquivo: 'POST' http://SeuServidor:8080/file
* obs: No envio do arquivo configurar o 'post', no campo 'body' selecionar 'form-data', em Key atribuir "file" e escolher o tipo para "file", inserindo o arquivo no campo value; (Limitação de arquivos de até 1024MB)

* Cadastro de pessoas: 'POST': http://SeuServidor:8080/lista
* Utilizei o site: https://www.onlinedatagenerator.com/ para criar o json, o tamanho você escolhe.
* Estrutura: 
  ```json  
    [
      {
        "nome":"David",
        "sobreNome":"Roth",
        "email":"David_Roth6988@gompie.com"
      },
      {
        "nome":"Julian",
        "sobreNome":"Clarke",
        "email":"Julian_Clarke1918@bretoux.com"
      },
      {
        "nome":"Lana",
        "sobreNome":"Edler",
        "email":"Lana_Edler8323@sveldo.biz"
      },
      {
        "nome":"Gil",
        "sobreNome":"Rossi",
        "email":"Gil_Rossi2686@womeona.net"
      }
    ]
  ```
