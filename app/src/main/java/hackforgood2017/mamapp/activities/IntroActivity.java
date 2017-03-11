package hackforgood2017.mamapp.activities;

import android.os.Bundle;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import hackforgood2017.mamapp.R;

public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.black)
                .image(R.drawable.ic_blanco_intro)
                .title("Que es MAMAPP")
                .description("Es una aplicación que pretende ayudar a la detección precoz del cáncer de mama en hombres y mujeres. No es un sustituto del médico y su única finalidad es ayudar a la autoexploración y dar una respuesta rápida y fiable al usuario")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.black)
                .image(R.drawable.ic_explore_blanco)

                .description("Tienes que realizar una auto exploración mensual como método de detección precoz")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.black)
                .image(R.drawable.ic_foto_scaner_blanco)
                .description("Hazte fotos cada mes para poder realizar un seguimiento con los datos extraídos")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.black)
                .image(R.drawable.ic_genetica_blanco)

                .description("Entre el 5 % y el 10 % de los cánceres de mama son hereditarios, causados por genes anormales que se transmiten entre parientes consanguíneos (abuelas, madre, hermanas, tías), ya sea por parte materna o paterna.")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.black)
                .image(R.drawable.ic_privacy_blanco)

                .description("En cumplimiento con lo dispuesto en la Ley Orgánica 15/1999, de 13 de diciembre, de Protección de Datos de Carácter Personal (LOPD), te informamos de que tus datos serán incorporados en un fichero de datos de carácter personal titularidad de MAMAPP En ningún caso cederemos tus datos a terceros.")
                .build());
    }
}
