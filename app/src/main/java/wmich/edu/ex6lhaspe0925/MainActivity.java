package wmich.edu.ex6lhaspe0925;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
//import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/*
*************************************
* Programmer: Lee Hasper
* Class ID: lhaspe0925
* Example 6
* CIS 2610: Business Mobile Programming
* Spring 2016
* Due date: 03/018/2016
* Date completed: 03/17/2016
*************************************
* Program Explanation
This application displays 9 images of food in a grid that a user can click to select.
Once an image is clicked on by the user, a large copy of the image opens up below the grid for a more detailed view of the selection.
A custom toast message is displayed relaying to the user which item they selected.
*************************************
*/


public class MainActivity extends AppCompatActivity {

    //CLASS VARIABLES that can be used by entire activity
    //declare integer array as an index of foods photos to represent the place in the grid where that image is held.

    Integer[] foods = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7,
            R.drawable.food8, R.drawable.food9};

    //imgPhotoHolder is referenced as a class variable and initialized.
    ImageView imgPhotoHolder;

    Integer width = 180;//custom width size of images in grid view
    Integer height = 180;//custom height size of images in the grid view

    //Button btnClose;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btnClose.setVisibility(View.INVISIBLE);

        final GridView gvFoodImages = (GridView) findViewById(R.id.gridVImages);//grid view instantiated

        final ImageView imgPhotoHolder = (ImageView) findViewById(R.id.imgPlaceHolder);//imageview is instantiated with class variable assignment

       /* final Button btnClose = (Button)findViewById(R.id.button);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvFoodImages.setVisibility(View.VISIBLE);
                //imgPhotoHolder.setVisibility(View.INVISIBLE);
                btnClose.setVisibility(View.INVISIBLE);

            }
        });*/

        gvFoodImages.setAdapter(new ImageAdapter(this));//image adapter coded for GridView control. This class displays image in grid

        gvFoodImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {//awaits on user to select phote from grid
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //custom toast method displayed when photo is clicked by user.
                Toast.makeText(getBaseContext(), "food Selection " + (position + 1), Toast.LENGTH_SHORT).show();
                imgPhotoHolder.setImageResource((foods[position]));


            }
        });

    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;//context variable is initialized as part of image adapter class

        public ImageAdapter(Context c) {//Image adapter class is added with auto generated methods
            context = c;//image adapter will now hold customized Context resources
        }

        @Override
        public int getCount() {
            return foods.length;//returns the length of foods array
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            imgPhotoHolder = new ImageView(context);//new image view instance is created
            imgPhotoHolder.setImageResource(foods[position]);//displayed image is set by user screen click position
            imgPhotoHolder.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//image is scaled to fit the gridview control
            LinearLayout.LayoutParams imgDisplayed = new LinearLayout.LayoutParams(width, height);//custom parameters for displaying the image grid
            imgPhotoHolder.setLayoutParams(imgDisplayed); //make image photo holder display custom formatting
            return imgPhotoHolder;
        }
    }
}
