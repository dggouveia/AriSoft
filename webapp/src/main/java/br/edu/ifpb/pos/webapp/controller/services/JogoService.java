package br.edu.ifpb.pos.webapp.controller.services;

import br.edu.ifpb.pos.core.entidades.Foto;
import br.edu.ifpb.pos.core.entidades.Jogo;
import br.edu.ifpb.pos.webapp.controller.forms.AdicionarJogoForm;
import br.edu.ifpb.pos.webapp.controller.webservices.interfaces.AppWebServiceSingleton;
import java.rmi.RemoteException;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
public class JogoService{

    public void criarJogo (AdicionarJogoForm form, byte[] imagem) throws RemoteException{
        Jogo jogo = new Jogo();
        jogo.setEnredo(form.getEnredo());
        Foto foto = new Foto();
        foto.setBytes(imagem);
        jogo.setFoto(foto);
        jogo.setHorario(form.getHorario());
        jogo.setLocal(form.getLocal());
        jogo.setMissao(form.getMissao());
        jogo.setObjetivo(form.getObjetivo());
        AppWebServiceSingleton.getInstance().criarJogo(jogo);
    }
    
    public void adicionarMembros (long idJogo, String emails){
        AppWebServiceSingleton.getInstance().adicionarMembrosAoJogo(idJogo, emails.split(","));
    }
    
    public void encerrarJogo (long jogoId){
        AppWebServiceSingleton.getInstance().encerrarJogo(jogoId);
    }
    
    public void cancelarJogo (long jogoId){
        AppWebServiceSingleton.getInstance().cancelarJogo(jogoId);
    }
    
}
