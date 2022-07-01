package br.com.teste;

import javax.xml.bind.ValidationException;

import algoritmo.AlgoritmoSequenciaProva;

/**
 * Classe responsavel pela inicializacao do teste A.
 * 
 * @author Bruno Alves Justino - brunojustino888@gmail.com
 */
public class TesteA {

	/**
	 * Metodo de execucao do teste.
	 * 
	 * @param args - String[] - argumentos da JVM.
	 * @throws Exception - Exception com mensagem de validacao dos dados de entrada.
	 */
	public static void main(final String[] args) throws ValidationException {
		
		final int[] entradaI = {1,2,3,4,5,6,7,8,9,10};
		final int[] entradaII = {1,2,3,4,6,7,8,9};
		final int[] entradaIII = {1,2,3,4,5,8,10,11,12,13,14,15};
		final int[] entradaIV = {1,2,3,5,7,10,11,12,13,20};
		final int[] entradaV = {1,3,5,6,9,10,11,12};
		
		AlgoritmoSequenciaProva.obterSequenciaFormatada(entradaI);
		AlgoritmoSequenciaProva.obterSequenciaFormatada(entradaII);
		AlgoritmoSequenciaProva.obterSequenciaFormatada(entradaIII);
		AlgoritmoSequenciaProva.obterSequenciaFormatada(entradaIV);
		AlgoritmoSequenciaProva.obterSequenciaFormatada(entradaV);
		
	}
	
}
