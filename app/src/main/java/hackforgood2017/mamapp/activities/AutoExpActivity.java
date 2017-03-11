package hackforgood2017.mamapp.activities;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import hackforgood2017.mamapp.R;

public class AutoExpActivity extends AppCompatActivity {
    CircularProgressButton circularProgressButton;
    ValueAnimator animator = ValueAnimator.ofFloat(0, 1f);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_exp);
        RecyclerView myRecycler = (RecyclerView) findViewById(R.id.myRecycler);
        circularProgressButton=(CircularProgressButton)findViewById(R.id.btnCircular);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecycler.setLayoutManager(manager);
        myRecycler.setHasFixedSize(true);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
        final List<String> descriptions=new ArrayList<>();
        descriptions.add("Nos colocamos con los brazos caídos delante de un espejo y giramos el tronco hacia un lado y hacia el otro. El objetivo es observar si notamos algún bulto o cambio en la piel y pezones.");
        descriptions.add("Con el mismo objetivo, levantamos los brazos y comprobamos que los pechos son uniformes y siguen el mismo movimiento. ");
        descriptions.add("Seguidamente de pie con la mano detrás de la cabeza palpamos el pecho con las yemas de los dedos del brazo contrario. Lo hacemos desde la axila hacia el pezón con movimientos circulares. ");
        descriptions.add("Con la yema de los dedos palpa tu pecho de arriba abajo y en espiral. ");
        descriptions.add("Realizamos el mismo procedimiento, pero esta vez nos tumbamos sobre la cama con una almohada debajo de la espalda.");
        descriptions.add("Por último, apretamos los pezones para comprobar si nos sale líquido.");
        final List<Integer>images=new ArrayList<>();
        images.add(R.drawable.explore_1);
        images.add(R.drawable.explore_2);
        images.add(R.drawable.explore_3);
        images.add(R.drawable.explore_4);
        images.add(R.drawable.explore_5);
        images.add(R.drawable.explore_6);
        final List<String> content = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            content.add(getListString(i));


        ParallaxRecyclerAdapter<String> stringAdapter = new ParallaxRecyclerAdapter<String>(content) {
            @Override
            public void onBindViewHolderImpl(final RecyclerView.ViewHolder viewHolder, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {

                ((SimpleViewHolder)viewHolder).tvElement.setText(descriptions.get(i));
                ((SimpleViewHolder)viewHolder).imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),images.get(i)));
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        viewHolder.itemView.setScaleX((Float) animation.getAnimatedValue());
                        viewHolder.itemView.setScaleY((Float) animation.getAnimatedValue());
                    }
                });



            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolderImpl(ViewGroup viewGroup, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler, viewGroup, false);
                return new SimpleViewHolder(view);

            }

            @Override
            public int getItemCountImpl(ParallaxRecyclerAdapter parallaxRecyclerAdapter) {
                return descriptions.size();
            }
        };


        stringAdapter.setParallaxHeader(getLayoutInflater().inflate(R.layout.header_recycler, myRecycler, false), myRecycler);
        stringAdapter.setOnParallaxScroll(new ParallaxRecyclerAdapter.OnParallaxScroll() {
            @Override
            public void onParallaxScroll(float percentage, float offset, View parallax) {
                //TODO: implement toolbar alpha. See README for details
            }
        });
        myRecycler.setAdapter(stringAdapter);
        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutoExpActivity.this,TestExploreActivity.class));
                finish();
            }
        });



    }

    static class SimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvElement;
        public SimpleViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.img_element);
            tvElement=(TextView)itemView.findViewById(R.id.tv_element);
        }
    }

    public String getListString(int position) {
        return position + " - android";
    }


}
