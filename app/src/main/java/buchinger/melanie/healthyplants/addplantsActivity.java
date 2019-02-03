package buchinger.melanie.healthyplants;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.app.Activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class addplantsActivity extends Activity {

    ImageView imageView;
    Button photobutton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants);




        Button photobutton  = (Button) findViewById(R.id.photobutton);
        imageView = (ImageView) findViewById(R.id.photoframe);


        photobutton.setOnClickListener (new View.OnClickListener()

        {@Override
        public void onClick (View view) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);

        }

        } );



    }







    public void onClickfab(View view) {
        Intent i = new Intent(this, meinGartenActivity.class);
        startActivity(i);
    }



    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get ("data");
        imageView .setImageBitmap(bitmap);




    }







}