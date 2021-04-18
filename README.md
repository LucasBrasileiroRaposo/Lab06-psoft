# Lab06-psoft
Projeto de controle de vacinação
Lucas Brasileiro Raposo - lucasraposo@ccc.ufcg.edu.br

Permite o cadastro de uma pessoa para vacinação (nome completo,CPF,endereço, número do cartão do SUS, e-mail,telefone, profissão, comorbidades e idade), ainda sendo 
adicionado , as datas de uma primeira e de uma segunda dose, além da situação de vacinação do indivíduo. Permite que como administrador, além de realizar esse cadastro
dos pacientes, habilite grupos de pessoas(por profissão, idade ou comorbidades) a serem aptar para tomar a primeira dose da vacina, para que em seguida este mesmo indivíduo
planeje uma data para determinado paciente tomar uma segunda dose, com a condição que a diferença entre essas data sejam de 20 dias no minimo e em seguida realizar a aplicação
da segunda dose, em massa, para todos aqueles que ja estão aptos para tomar essa segunda dose.

Para fazer o uso do padrão state, criei a classe Situação, que vai ser estendida pelas outras classe NaoHabilitado, Habilitado1Dose, Tomou1Dose, Habilitado2Dose, FinalizadaVacinacao.
Essa classe também possui os métodos vazios de: vacinar, habilitar, habilitarSegundaDose, vacinarSegundaDose, que vão ser implementados cada um em alguma classe que estende a classe.
Sendo isso implementado como tipo de um atributo de um paciente, para representar a situação de vacinação da pessoa.Ademais, cada classe que estende Situação tem seu próprio toString().

Optei por também, por utilizar de uma classe,GrupoHabilitados, que guardar os grupos de pessoas habilitados para vacina (no caso, para primeira dose), todas as profissões, comorbidades e 
a idade como atributos da classe criada, e para controlar e auxiliar na adição de dados e acesso de dados a essa classe, também criei a classe VerificaHabilitacaoParaVacina, e evitar uma
ainda maior sobrecarga a classe Controller, que já possui muitas funcionalidades e responsabilidades.
