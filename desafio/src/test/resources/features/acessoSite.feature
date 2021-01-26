#language:pt 

Funcionalidade: Realiza acesso ao site 
  Sendo eu um cliente
  quero realizar acesso ao site 
  para visulizar as informações da pagina

@buscar
 Cenario: Acessar opiçao de compra carros novos ou semi novos
    
    Dado que estou no site 
    E seleciono o comando compra 
    Quando seleciono o comando carros novos ou semi novos
    Entao visualizo a pagina     

  	
 @buscar
 Cenario: Informar opçoes marca para realizar a busca por carros novos ou semi novos
  	
  	Dado que estou no site busca carro novos ou semi novos
    Quando seleciono a marca, modelo e versao desejada
  	Entao carrega a paina com os veiculos da marca, modelo e versao selecionada
    
