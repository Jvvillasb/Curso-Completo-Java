### Módulo 16: Ferramentas de DevOps e Integração Contínua

## 1. Introdução ao CI/CD

**CI/CD** (Integração Contínua e Entrega Contínua) são práticas fundamentais no desenvolvimento moderno.  
- **Integração Contínua (CI):** Automatiza o processo de integração de código, garantindo que as alterações sejam testadas e integradas constantemente.  
- **Entrega Contínua (CD):** Automatiza a entrega do software em ambientes de produção (ou pré-produção), reduzindo o tempo entre a codificação e o deploy.

### **Benefícios do CI/CD**
- Redução de erros de integração.
- Deploys rápidos e confiáveis.
- Feedback rápido sobre alterações no código.

---

## 2. Pipelines com Jenkins
O **Jenkins** é uma ferramenta popular de automação para construir pipelines de CI/CD. Ele permite configurar e gerenciar processos de build, teste e deploy automatizados.

### **Exemplo: Configurando uma Pipeline no Jenkins**
1. Certifique-se de ter o Jenkins instalado e configurado.
2. Crie um arquivo `Jenkinsfile` no seu repositório para definir a pipeline:

```groovy
   pipeline {
       agent any
       stages {
           stage('Build') {
               steps {
                   echo 'Construindo o projeto...'
                   sh './mvnw clean package'
               }
           }
           stage('Test') {
               steps {
                   echo 'Executando testes...'
                   sh './mvnw test'
               }
           }
           stage('Deploy') {
               steps {
                   echo 'Fazendo deploy...'
                   sh './scripts/deploy.sh'
               }
           }
       }
   }
```

3. No Jenkins, crie um novo item do tipo Pipeline e configure o repositório Git onde o Jenkinsfile está localizado

## 3. Configuração e Deploy Automático

- O deploy automático em pipelines CI/CD reduz a necessidade de intervenções manuais e garante entregas rápidas. O processo pode ser configurado para diversos ambientes (desenvolvimento, homologação, produção).

**Exemplo: Deploy em Ambiente Remoto com Jenkins:**

1. Configure o SSH no servidor remoto para automação.

2. Crie um script de deploy **(deploy.sh):**

```sh
#!/bin/bash
echo "Iniciando deploy no servidor remoto..."
scp target/meu-app.jar usuario@servidor:/caminho/para/deploy
ssh usuario@servidor "sudo systemctl restart meu-app"
echo "Deploy concluído com sucesso!"
```

3. Adicione o script ao estágio de deploy no **Jenkinsfile**

```groovy
stage('Deploy') {
    steps {
        echo 'Fazendo deploy no servidor remoto...'
        sh './scripts/deploy.sh'
    }
}
```

## 4. Testes Automatizados na Pipeline

- Automatizar testes dentro da pipeline é essencial para detectar falhas rapidamente antes que o código chegue em produção.

**Exemplo: Executando Testes com Maven**

- No **Jenkinsfile**, inclua o estágio para testes:

```groovy
stage('Test') {
    steps {
        echo 'Executando testes automatizados...'
        sh './mvnw test'
    }
}
```

- Resultados de testes podem ser capturados em relatórios:

```groovy
stage('Test') {
    steps {
        junit '**/target/surefire-reports/*.xml'
    }
}
```

## 5. Controle de Versão com Git

- O Git é a principal ferramenta de controle de versão utilizada no mercado. Ele permite rastrear alterações no código, colaborar em equipe e gerenciar branches para diferentes funcionalidades.

***Comandos Básicos do Git***

**Clonar um repositório:**

```sh
git clone https://github.com/usuario/meu-repositorio.git
```

**Criar uma nova branch:**

```sh
git checkout -b feature/nova-funcionalidade
```

**Adicionar e commitar alterações:**

```sh
git add .
git commit -m "Implementação da nova funcionalidade"
```

**Fazer o push da branch:**

```sh
git push origin feature/nova-funcionalidade
```

**Mesclar branches (merge):**

```sh
git checkout main
git merge feature/nova-funcionalidade
```
