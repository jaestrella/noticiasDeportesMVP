package com.iesvirgendelcarmen.dam.noticiasdeportesmvp.noticias;

import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.modelos.Noticia;

import java.util.List;

/**
 * Created by matinal on 18/12/2017.
 */

public interface NoticiasContract {

    interface View{
        public void showNoticias(List<Noticia> lista);
    }
}
