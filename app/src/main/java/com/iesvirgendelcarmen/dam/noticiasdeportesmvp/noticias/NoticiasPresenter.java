package com.iesvirgendelcarmen.dam.noticiasdeportesmvp.noticias;

import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.modelos.Noticia;
import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.modelos.api.NewsApi;

import java.util.List;

public class NoticiasPresenter {
    private NoticiasContract.View vista;
    private List<Noticia> listaNoticias;

    public NoticiasPresenter(NoticiasContract.View vista) {
        this.vista = vista;
    }

    /**
     * Obtiene una lista de noticias usando la API pública newsapi.org
     * <p>
     * Se usa un callback para recibir la lista.
     */
    void cargaDatos() {
        NewsApi api = new NewsApi();
        api.ultimasNoticias(new NewsApi.Callback() {
            @Override
            public void getLista(List<Noticia> noticias) {
                listaNoticias=noticias;
                vista.showNoticias(listaNoticias);
            }
        });
    }

    public Noticia getNoticia(int position){
        return listaNoticias.get(position);
    }

}