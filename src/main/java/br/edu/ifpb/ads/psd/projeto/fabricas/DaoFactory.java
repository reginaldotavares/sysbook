package br.edu.ifpb.ads.psd.projeto.fabricas;



public class DaoFactory {
    public static DaoFactoryIF creatFactory(){
        return new DaoFactoryBD();
    }
}
