#language:pt 

Funcionalidade: Realiza busca
  Sendo eu um cliente
  quero realizar uma busca por marca, modelo e versao 
  para visulizar as opições disponiveis de veiculos

@buscar
 Cenario: Informar opçoes marca para realizar a busca por carros novos ou semi novos
  	
  	Dado que estou no site busca carro novos ou semi novos
    Quando seleciono a marca, modelo e versao desejada
  	Entao carrega a paina com os veiculos da marca, modelo e versao selecionada

  	
    
