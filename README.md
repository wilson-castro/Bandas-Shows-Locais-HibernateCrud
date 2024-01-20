
  <h1>Projeto de Cadastro de Shows, Bandas e Locais</h1>

  <h2>Tecnologias</h2>
  <p align="center">
    <a href="https://skillicons.dev">
      <img src="https://skillicons.dev/icons?i=java,hibernate,mysql" />
    </a>
  </p>

  <h2>Descrição do Projeto</h2>
  <p>Este é um projeto Java Web baseado em Servlets e Hibernate, desenvolvido para gerenciar informações relacionadas a shows, bandas e locais. O sistema utiliza o MySQL como banco de dados para armazenar os dados relevantes.</p>

  <h2>Tecnologias Utilizadas</h2>
  <ul>
      <li>Java</li>
      <li>Servlets</li>
      <li>Hibernate</li>
      <li>MySQL</li>
      <li>JSP (JavaServer Pages)</li>
      <li>HTML, CSS, JavaScript</li>
  </ul>

  <h2>Configuração do Ambiente</h2>
  <ol>
      <li><strong>Java Development Kit (JDK):</strong> Certifique-se de ter o JDK instalado. Recomenda-se a versão 8 ou superior. <a href="https://www.oracle.com/java/technologies/javase-downloads.html">Download do JDK</a></li>
      <li><strong>Servidor de Aplicação:</strong> Configure um servidor de aplicação compatível, como Apache Tomcat. <a href="http://tomcat.apache.org/">Download do Apache Tomcat</a></li>
      <li><strong>Banco de Dados:</strong> Instale e configure o MySQL. Crie um banco de dados chamado <code>cadastro_shows</code>. Configure as informações de conexão no arquivo <code>hibernate.cfg.xml</code>.</li>
      <li><strong>IDE (Ambiente de Desenvolvimento Integrado):</strong> Use uma IDE Java, como Eclipse ou IntelliJ, para facilitar o desenvolvimento. <a href="https://www.eclipse.org/downloads/">Eclipse IDE</a>, <a href="https://www.jetbrains.com/idea/">IntelliJ IDEA</a></li>
      <li><strong>Dependências Maven:</strong> As dependências do projeto estão configuradas no arquivo <code>pom.xml</code>. Certifique-se de que sua IDE está configurada para baixar as dependências automaticamente.</li>
  </ol>

  <h2>Configuração do Banco de Dados</h2>
  <ol>
      <li>Execute o script SQL <code>sql.sql</code> para criar as tabelas necessárias.</li>
  </ol>

  <h2>Configuração do Hibernate</h2>
  <ol>
      <li>Configure as informações de conexão com o banco de dados no arquivo <code>ConnectionFactory</code> localizado em <code>src/main/java/jdbc</code>.</li>
  </ol>

  <h2>Executando o Projeto</h2>
  <ol>
      <li>Importe o projeto para sua IDE.</li>
      <li>Certifique-se de que o servidor de aplicação está configurado corretamente.</li>
      <li>Inicie o servidor e implante o projeto.</li>
      <li>Acesse o aplicativo pelo navegador: <code>http://localhost:8080/nome-do-projeto</code></li>
  </ol>

  <h2>Funcionalidades</h2>
  <ul>
      <li>Cadastro, edição e exclusão de shows, bandas e locais.</li>
      <li>Visualização de informações detalhadas sobre shows, bandas e locais.</li>
  </ul>
