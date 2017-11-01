package com.example.miguel.eventos_views;


        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.RatingBar;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RelativeLayout relativeLayout;
    private Button botonFondo, botonLetra;
    private CheckBox checkboxMostrar;
    private TextView textoHidden, textoLargaPulsacion, textoPuntos;
    private RatingBar estrellas;
    private boolean fondoTint = false;
    private boolean letraTint = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos variables de la vista
        rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        botonFondo = (Button) findViewById(R.id.botonFondo);
        botonLetra = (Button) findViewById(R.id.botonLine);
        checkboxMostrar = (CheckBox) findViewById(R.id.checkboxMostrar);
        textoHidden = (TextView) findViewById(R.id.textoHidden);
        textoLargaPulsacion = (TextView) findViewById(R.id.textoLargo);
        textoPuntos = (TextView) findViewById(R.id.textoPuntos);
        estrellas = (RatingBar) findViewById(R.id.ratingBar);

        //Valor de OnLongClick
        textoLargaPulsacion.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "¡¡Gracias por probarlo!!";
                int duration = Toast.LENGTH_SHORT;



                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return false;
            }
        });

        //Función estrellas ratingBar
        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textoPuntos.setText("[" + Math.round(estrellas.getRating()) + "<>5]");
            }
        });

    }

    public void onClick(View v){

        //Filtramos de que botón viene
        switch (v.getId()){

            //Boton Fondo
            case R.id.botonFondo:
                //Cambiar fondo de color
                if (!fondoTint){
                    relativeLayoutl.setBackground(getDrawable(R.color.Rojo));
                    botonFondo.setText("Fondo de color blanco");
                    fondoTint = true;
                } else {
                    relativeLayoutl.setBackground(getDrawable(R.color.Transparencia));
                    botonFondo.setText("Fondo de color rojo");
                    fondoTint = false;
                }
                break;

            //El botón para cambiar el color al texto
            case R.id.botonLine:

                if (!letraTint){
                    botonLetra.setTextColor(getColor(R.color.Rojo));
                    botonLetra.setText("Texto en Negro");
                    letraTint = true;
                } else {
                    botonLetra.setTextColor(getColor(R.color.Negro));
                    botonLetra.setText("Texto en Rojo");
                    letraTint = false;
                }
                break;

            //Condiciones para el checkbox del texto Hidden
            case R.id.checkboxMostrar:
                if (checkboxMostrar.isChecked()){
                    textoHidden.setVisibility(View.VISIBLE);
                } else {
                    textoHidden.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }
}