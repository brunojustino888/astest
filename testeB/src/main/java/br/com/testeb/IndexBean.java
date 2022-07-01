package br.com.testeb;
 
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

/**
 * Managedbean da tela da calculadora.
 * 
 * @author Bruno Alves Justino - brunojustino888@gmail.com
 */
@Named 
@ViewScoped
public class IndexBean implements Serializable {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Prefixo de mensagem.
	 */
	private static final String PREFIX = "O resultado é: ";
	
	/**
	 * Representa o campo A mostrado em tela.
	 */
	private String campoA;
	
	/**
	 * Representa o campo B mostrado em tela.
	 */
	private String campoB;
	
	/**
	 * Representa o campo resultado mostrado em tela.
	 */
	private String resultado;
	
	/**
	 * Controle da exibicao do resultado.
	 */
	private boolean exibeResultado = false;
	
	/**
	 * Responsavel pela soma.
	 */
	public void soma() {
		if(this.entradaValida()) {
			try { 
				final long soma = Long.parseLong(this.campoA) + Long.parseLong(this.campoB);
				this.exibeResultado = true;
				this.resultado = PREFIX + soma;
				this.campoA="";
				this.campoB="";
			}catch(final NumberFormatException numberException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado Inválido!", "O resultado ultrapassa o valor maximo permitido de: "+ Long.MAX_VALUE +"."));
				this.reset();  
			}
		}
	}
	
	/**
	 * Responsavel pela subtracao.
	 */
	public void subtracao() {
		if(this.entradaValida()) {
			try { 
				final long subtracao = Long.parseLong(this.campoA) - Long.parseLong(this.campoB);
				this.exibeResultado = true;
				this.resultado = PREFIX + subtracao;
				this.campoA="";
				this.campoB="";
			}catch(final NumberFormatException numberException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado Inválido!", "O resultado ultrapassa o valor maximo permitido de: "+ Long.MIN_VALUE +"."));
				this.reset();  
			}
		}
	}

	/**
	 * Valida os dados de entrada.
	 * 
	 * @return true em caso de dados corretos.
	 */
	private boolean entradaValida() {
		
		if(StringUtils.isBlank(this.campoA)||StringUtils.isBlank(this.campoB)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campos Obrigatórios!", "Informe o campo A e o campo B para prosseguir."));
			this.exibeResultado = false;
			return false;
		} 
		
		try { 
			Long.parseLong(this.campoA);
			Long.parseLong(this.campoB);
		}catch(final NumberFormatException numberException) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Campos Inválidos!", "Informe um valor numérico válido para o campo A e tambem para o campo B para prosseguir. Maior valor permitido paras os campos: "+ Long.MAX_VALUE +"."));
			this.exibeResultado = false;
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Reset dos campos do ManagedBean.
	 */
	private void reset() {
		this.exibeResultado = false;
		this.campoA="";
		this.campoB="";
		this.resultado="";
	}

	/**
	 * Metodo get().
	 * 
	 * @return campoA - String - representa o campo A.
	 */
	public String getCampoA() {
		return this.campoA;
	}

	/**
	 * Metodo set().
	 * 
	 * @param campoA - String - representa o campo A.
	 */
	public void setCampoA(final String campoA) {
		this.campoA = campoA;
	}

	/**
	 * Metodo get().
	 * 
	 * @return campoB - String - representa o campo B.
	 */
	public String getCampoB() {
		return this.campoB;
	}

	/**
	 * Metodo set().
	 * 
	 * @param campoB - String - representa o campo B.
	 */
	public void setCampoB(final String campoB) {
		this.campoB = campoB;
	}

	/**
	 * Metodo get().
	 * 
	 * @return resultado - String - representa o campo resultado.
	 */
	public String getResultado() {
		return this.resultado;
	}

	/**
	 * Metodo set().
	 * 
	 * @param resultado - String - representa o campo resultado.
	 */
	public void setResultado(final String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Metodo get().
	 * 
	 * @return exibeResultado - boolean - representa a exibicao do resultado.
	 */
	public boolean isExibeResultado() {
		return this.exibeResultado;
	}

	/**
	 * Metodo set().
	 * 
	 * @param exibeResultado - boolean - representa a exibicao do resultado.
	 */
	public void setExibeResultado(final boolean exibeResultado) {
		this.exibeResultado = exibeResultado;
	}
	
}