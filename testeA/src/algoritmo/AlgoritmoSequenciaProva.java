package algoritmo;

import javax.xml.bind.ValidationException;

/**
 * Classe de implementacao do teste A.
 * 
 * @author Bruno Alves Justino - brunojustino888@gmail.com
 */
public final class AlgoritmoSequenciaProva {

	/**
	 * Construtor vazio impedindo a inicializacao da classe.
	 */
	private AlgoritmoSequenciaProva() {}

	/**
	 * Implemente o m todo que recebe um array de Inteiros de uma maneira que
	 * retorne uma String com os numeros organizados nas seguintes condi  es:
	 * 
	 * Condicao 1: "-"(hifen) Quando os numeros forem sequenciais, deve-se mostrar o
	 * primeiro e o ultimo n mero do periodo apenas colocando um "-" no meio deles.
	 * Condicao 2: ","(v rgula) Quando existir uma quebra na sequ ncia dos n meros,
	 * deve-se colocar "," e em seguida o n mero que quebrou a sequ ncia. Condi  o
	 * 3: " "(espaco) Voce n o precisa se preocupar em colocar o caractere espa o "
	 * " entre os n meros na formatacao da sua String.
	 * 
	 * Para melhor entendimento, veja alguns exemplos de entrada/saida do que se
	 * espera do algoritmo:
	 * 
	 * Exemplo 1 : Entrada : {1,2,3,4,5,6,7,8,9,10} Sa da : "1-10"
	 *
	 * Exemplo 2 : Entrada : {1,2,3,4,6,7,8,9} Sa da : "1-4,6-9"
	 *
	 * Exemplo 3 : Entrada : {1,2,3,4,5,8,10,11,12,13,14,15} Sa da : "1-5,8,10-15"
	 * 
	 * Exemplo 4 : Entrada : {1,2,3,5,7,10,11,12,13,20} Sa da : "1-3,5,7,10-13,20"
	 * 
	 * Exemplo 5 : Entrada : {1,3,5,6,9,10,11,12} Sa da : "1,3,5-6,9-12"
	 * 
	 * @param valores - int[] - array de numeros inteiros.
	 * @return removeUltimaVirgula - String - string contendo os numeros separados por
	 *         sequencia e virgulas.
	 * @throws ValidationException - lanca exception com mensagem de validacao de dados de
	 *                   entrada.
	 */
	public static String obterSequenciaFormatada(final int[] valores) throws ValidationException {

		if (valores == null) {
			throw new ValidationException("Informe um array de numeros!");
		}

		final StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < valores.length; i++) {

			int valor = valores[i];

			if (i + 1 == valores.length) {
				stringBuilder.append(valor);
				break;
			}

			final int proximoValor = valores[i + 1];

			if (valor + 1 == proximoValor) {

				stringBuilder.append(valor);
				stringBuilder.append("#");

			} else {
				stringBuilder.append(valor);
				stringBuilder.append(",");
			}

		}

		final String removeUltimaVirgula = prepareString(stringBuilder.toString());

		return removeUltimaVirgula.substring(0, removeUltimaVirgula.length() - 1);

	}

	/**
	 * Responsavel por preparar a String de retorno de acordo com cada sequencia.
	 * 
	 * @param stringCompleta - String - String completa no formato 1#2#3,6#7
	 * @return String - string tratada contendo uma virgula no ultimo char.
	 */
	private static String prepareString(final String stringCompleta) {

		final String[] sequencias = stringCompleta.split(",");

		final StringBuilder stringBuilder2 = new StringBuilder();

		for (final String sequencia : sequencias) {
			stringBuilder2.append(trataSequencia(sequencia));
			stringBuilder2.append(",");
		}

		return stringBuilder2.toString();
	}

	/**
	 * Trata cada sequencia recebida adicionando o "-".
	 * 
	 * @param sequencia - String - string contendo a sequencia.
	 * @return String - retorna o primeiro e o ultimo digito da sequencia separados por "-".
	 */
	private static String trataSequencia(final String sequencia) {

		final String[] numerosString = sequencia.split("#");

		if (numerosString.length == 1) {
			return numerosString[numerosString.length - 1];
		}

		return numerosString[0] + "-" + numerosString[numerosString.length - 1];

	}

}
