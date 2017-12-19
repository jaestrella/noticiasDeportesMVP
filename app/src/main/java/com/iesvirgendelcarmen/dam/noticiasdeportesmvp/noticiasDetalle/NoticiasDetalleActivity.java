package com.iesvirgendelcarmen.dam.noticiasdeportesmvp.noticiasDetalle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.R;
import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.modelos.Noticia;
import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.modelos.api.VolleySingleton;
import com.iesvirgendelcarmen.dam.noticiasdeportesmvp.noticias.NoticiasActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticiasDetalleActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.detalletitulo)
    TextView titulo;
    @BindView(R.id.detalleAutor)
    TextView autor;
    @BindView(R.id.detalleDescripcion)
    TextView descripcion;
    @BindView(R.id.detalleFecha)
    TextView fecha;
    @BindView(R.id.detalleImagen)
    NetworkImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_detalle);
        ButterKnife.bind(this);

        Noticia noticia = (Noticia) getIntent().getExtras().getSerializable(NoticiasActivity.EXTRA_NOTICIA);

        setLayout();
        setNoticia(noticia);
    }


    private void setLayout() {
        //Establece la toolbar de la libreria de soporte
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * Establece valores para los views de la noticia
     *
     * @param noticia Objeto noticia
     */
    private void setNoticia(Noticia noticia) {
        if (noticia != null) {
            titulo.setText(noticia.getTitle());
            autor.setText(noticia.getAuthor());
            descripcion.setText(noticia.getDescription());
            fecha.setText(noticia.getFormatPublishedAt());
            imagen.setImageUrl(noticia.getUrlToImage(), VolleySingleton.getInstance(this).getImageLoader());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
