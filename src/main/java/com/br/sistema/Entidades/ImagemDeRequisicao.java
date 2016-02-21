package com.br.sistema.Entidades;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItem;



/**
 * @Date  16/01/2016 @Time 17:51:39
 * @author Wellington Lins Claudino Duarte   <wellingtonlins2013@gmail.com>
 */ 

public class ImagemDeRequisicao {

    public static void inserirImagem(FileItem item, String realPath, String nomeDaImagem) throws IOException {

        //Pegar o diretorio /imagensPerfil dentro do diretorio atual
        String diretorio = realPath + "/";

        //Criar diretorio caso não exista;
        File f = new File(diretorio);

        if (!f.exists()) {
            f.mkdir();
        }

        //Mandar o arquivo para o diretorio informado
        f = new File(diretorio + nomeDaImagem + ".jpg");

        try (FileOutputStream output = new FileOutputStream(f)) {
            InputStream is = item.getInputStream();

            byte[] buffer = new byte[2048];

            int nLidos;

            while ((nLidos = is.read(buffer)) >= 0) {
                output.write(buffer, 0, nLidos);
            }

            output.flush();
        }

    }

}
