### 01-Introdução à Programação e à Linguagem Java

## 1. Definição
Programação é a arte de criar instruções precisas para que computadores resolvam problemas específicos. Envolve:

- **Análise de problemas**
- **Criação de algoritmos**
- **Implementação de soluções**
- **Depuração e otimização de código**

### Conceitos Fundamentais
- **Algoritmo**: Sequência lógica de passos para resolver um problema.
- **Lógica de Programação**: Técnica de encadear pensamentos para atingir um objetivo.
- **Abstração**: Capacidade de simplificar problemas complexos.

## 2. Configuração do Ambiente de Desenvolvimento

### Componentes Necessários

#### JDK (Java Development Kit)
- Conjunto de ferramentas para desenvolvimento Java.
- Inclui compilador, máquina virtual e bibliotecas.
- **Versões mais utilizadas**: JDK 8, 11, 17 (LTS).

#### IDEs Populares
- **Eclipse**: Gratuita, multiplataforma.
- **IntelliJ IDEA**: Recursos avançados.
- **NetBeans**: Fácil utilização.
- **Visual Studio Code**: Leve, extensível.

### Passos de Configuração
1. Baixar o **JDK oficial**.
2. Configurar **variáveis de ambiente**.
3. Instalar a **IDE**.
4. Testar a instalação.

## 3. História do Java

### Origem
- **Criação**: 1995 por James Gosling na Sun Microsystems.
- **Objetivo Original**: Desenvolver software para dispositivos eletrônicos.

#### Características Diferenciais
- Portabilidade.
- Orientação a objetos.
- Sintaxe similar a C++.
- Gerenciamento automático de memória.

### Evolução
- **1995**: Primeira versão pública.
- **2010**: Comprada pela Oracle.
- Atualizações constantes com novas features.
- Amplamente usado em desenvolvimento corporativo.

## 4. Sintaxe Básica de Java

### Estrutura de um Programa
```java
public class NomeClasse {
    public static void main(String[] args) {
        // Código executável
    }
}
```
## 5. Estrutura Sequencial

### Execução Linear

- Instruções executadas na ordem definida
- Cada linha é processada sequencialmente
- Fluxo de cima para baixo

```java
int valor1 = 10; // Primeira instrução
int valor2 = 20; // Segunda instrução
int soma = valor1 + valor2; // Terceira instrução
```

## 6. Variáveis e Tipos de Dados

### Tipos Primitivos

**int**: Números inteiros (-2³¹ a 2³¹-1)
**double**: Números decimais
**boolean**: Valores lógicos (true/false)
**char**: Caractere único
**byte**: Números inteiros pequenos
**long**: Inteiros de maior precisão
**float**: Números decimais de precisão simples

### Declaração

```java
int idade = 25;
double salario = 1500.50;
boolean ativo = true;
char letra = 'A';
```

## 7. Operadores

## Aritméticos

+: Adição
-: Subtração
*: Multiplicação
/: Divisão
%: Módulo (resto)

## sssRelacionais

==: Igual
!=: Diferente
>: Maior
<: Menor
>=: Maior ou igual
<=: Menor ou igual

## Lógicos

&&: E (AND)
||: OU (OR)
!: Negação (NOT)

## Exemplo

```java
int x = 10, y = 5;
boolean resultado = (x > y) && (x != 0);
```