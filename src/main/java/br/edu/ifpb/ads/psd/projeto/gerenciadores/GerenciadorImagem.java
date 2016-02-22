package br.edu.ifpb.ads.psd.projeto.gerenciadores;



import br.edu.ifpb.ads.psd.projeto.entidades.ImagemDeRequisicao;
import java.io.IOException;
import org.apache.commons.fileupload.FileItem;



/**
 * @Date  16/01/2016 @Time 17:51:39
 * @author Wellington Lins Claudino Duarte   <wellingtonlins2013@gmail.com>
 */ 
public class GerenciadorImagem {
    
 
    public void inserirImagemPerfil(FileItem item, String realPath, String nomeDaImagem) throws IOException{
        
        ImagemDeRequisicao.inserirImagem(item, realPath, nomeDaImagem);
    }
}
