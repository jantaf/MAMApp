package hackforgood2017.mamapp.activities;

import android.os.Bundle;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import hackforgood2017.mamapp.R;
//unused
public class ExploreActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorAccent)
                .buttonsColor(R.color.colorPrimary)
                .image(R.drawable.explore_1)
                .description("1- Nos colocamos con los brazos caídos delante de un espejo y giramos el tronco hacia un lado y hacia el otro. El objetivo es observar si notamos algún bulto o cambio en la piel y pezones.")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorAccent)
                .buttonsColor(R.color.colorPrimary)
                .image(R.drawable.explore_1)
                .description("1- Nos colocamos con los brazos caídos delante de un espejo y giramos el tronco hacia un lado y hacia el otro. El objetivo es observar si notamos algún bulto o cambio en la piel y pezones.")
                .build());

    }

}
