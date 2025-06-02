# Nome:Rodrigo Vinzent Ariñez Viscarra RM:559192

# Nome:Gabriel Borges Gonçaves Silva RM:558861

# Nome:Tarik Omar Mazloum RM:554933

# FloodGuard
# Sistema de Alerta de Enchentes

Este projeto consiste em um sistema de back-end para monitorar dados de sensores e gerar alertas em caso de risco de enchente. Os dados dos sensores (nível da água, temperatura e umidade) são recebidos através de uma API REST, armazenados em um banco de dados H2 em arquivo, e usados para determinar o nível de risco de enchente. O sistema também permite registrar ações de controle, como a ativação de barreiras.

## Funcionalidades Implementadas

* **Recebimento de dados de sensores:** Através do endpoint `/sensores` (método POST), o sistema recebe dados de sensores no formato JSON.
* **Armazenamento de dados:** Os dados dos sensores recebidos são persistidos no banco de dados H2 em arquivo (`./data/banco_enchentes.mv.db`).
* **Geração de alertas:** Com base no nível da água recebido, o sistema gera alertas com diferentes níveis de risco (Baixo, Médio, Alto) e os armazena no banco de dados.
* **Listagem de alertas:** O endpoint `/alertas` (método GET) permite listar todos os alertas gerados.
* **Controle de ações:**
    * O endpoint `/controle/barreira/ativar` (método POST) permite registrar a ativação de barreiras.
    * O endpoint `/controle/historico` (método POST) permite registrar eventos no histórico do sistema.
    * O endpoint `/controle/acoes` (método GET) permite listar todas as ações de controle registradas.
* **Banco de dados:** Utilização do banco de dados H2 em arquivo para persistência de dados (sensores, alertas e ações de controle). O arquivo do banco está localizado no diretório `/data` do projeto.

## Endpoints da API

* **`POST /sensores`**: Recebe dados de um sensor. Exemplo de body:
    ```json
    {
        "sensorId": "sensor001",
        "nivelAgua": 3.5,
        "temperatura": 25.0,
        "umidade": 70.0
    }
    ```
* **`GET /sensores`**: Lista todos os dados de sensores armazenados.
* **`GET /alertas`**: Lista todos os alertas gerados.
* **`POST /controle/barreira/ativar`**: Registra a ativação de uma barreira. Exemplo de body:
    ```json
    "Descrição da ativação da barreira."
    ```
* **`POST /controle/historico`**: Registra um evento no histórico. Exemplo de body:
    ```json
    "Descrição do evento histórico."
    ```
* **`GET /controle/acoes`**: Lista todas as ações de controle registradas.

## Banco de Dados

* **H2 em arquivo:** Os dados são armazenados no arquivo `banco_enchentes.mv.db` dentro do diretório `data/` do projeto.
* **Tabelas:**
    * `DADOS_SENSOR`: Armazena os dados brutos dos sensores.
    * `ALERTA`: Armazena os alertas gerados pelo sistema.
    * `ACAO_CONTROLE`: Armazena as ações de controle registradas.
## Como Utilizar o Sistema

Para interagir com o sistema de alerta de enchentes, você pode utilizar um cliente HTTP como o Postman para enviar requisições aos endpoints da API.

**Envio de Dados de Sensores:**

1.  Utilize o método `POST` no endpoint `/sensores`.
2.  No corpo da requisição (formato JSON), envie os dados do sensor, incluindo `sensorId`, `nivelAgua`, `temperatura` e `umidade`.
3.  Ao enviar dados com um `nivelAgua` acima de 5.0, o sistema gerará um alerta.

**Visualização de Dados e Alertas:**

1.  Utilize o método `GET` nos endpoints `/sensores` e `/alertas` para recuperar os dados armazenados e os alertas gerados, respectivamente.

**Registro de Ações de Controle:**

1.  Para registrar a ativação de uma barreira, utilize o método `POST` no endpoint `/controle/barreira/ativar` e envie uma descrição no corpo da requisição.
2.  Para registrar um evento histórico, utilize o método `POST` no endpoint `/controle/historico` e envie a descrição do evento no corpo.
3.  Para listar todas as ações de controle, utilize o método `GET` no endpoint `/controle/acoes`.

**Inspeção do Banco de Dados (Opcional):**

Para inspecionar diretamente o banco de dados H2, você pode:

1.  Certificar-se de que a aplicação Spring Boot está rodando.
2.  Abrir um navegador web e acessar `http://localhost:8080/h2-console`.
3.  Utilizar as configurações de conexão:
    * **JDBC URL:** `jdbc:h2:file:./data/banco_enchentes`
    * **User Name:** `sa`
    * **Password:** (em branco)
4.  No console SQL, você pode executar comandos como `SELECT * FROM DADOS_SENSOR;`, `SELECT * FROM ALERTA;` e `SELECT * FROM ACAO_CONTROLE;` para visualizar os dados.

---
