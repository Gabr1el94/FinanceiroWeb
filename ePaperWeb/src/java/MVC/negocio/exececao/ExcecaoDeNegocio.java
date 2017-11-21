/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.negocio.exececao;

/**
 *
 * @author Rodrigo
 */
public class ExcecaoDeNegocio extends Exception{
    
    private String mensagem;
    
    public ExcecaoDeNegocio (String erro, String mensagem) {
           // O primeiro parametro é a mensagem normal da exceçao...
           super(erro);
           // O segundo é a chave da mensagem internacionalizada
           this.mensagem = mensagem;
      }
}
