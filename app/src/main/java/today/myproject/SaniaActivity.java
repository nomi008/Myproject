package today.myproject;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SaniaActivity extends AppCompatActivity {

    Button Left, Right, Up, Down;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sania);

        View parentView = findViewById(R.id.img);
        parentView.post(new Runnable() {
            @Override
            public void run() {

                Rect delegateArea = new Rect();
                img = (ImageView) findViewById(R.id.imageView);
                img.setEnabled(true);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SaniaActivity.this, "Touch the Boundary", Toast.LENGTH_SHORT).show();
                    }
                });
                img.getHitRect(delegateArea);
                delegateArea.right += 100;
                delegateArea.bottom += 100;

                TouchDelegate touchDelegate = new TouchDelegate(delegateArea, img);
                if (View.class.isInstance(img.getParent())) {
                    ((View) img.getParent()).setTouchDelegate(touchDelegate);


                }
            }
        });

        Left = (Button) findViewById(R.id.button);
        Right = (Button) findViewById(R.id.button2);
        Up = (Button) findViewById(R.id.button3);
        Down = (Button) findViewById(R.id.button4);

        img = (ImageView) findViewById(R.id.img);

        Left.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                img.setX(img.getX() + 2);

            }
        });
        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             img.setX(img.getX()-2);
            }
        });
        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            img.setX(img.getX()+2);
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            img.setX(img.getX()-2);
            }
        });
    }
}
