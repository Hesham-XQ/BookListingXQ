package com.example.android.booklistingxq;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by SAMO on 2/14/2018.
 */


public class DetailsActivity extends AppCompatActivity {

    // declaration of String constants to be used
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    // initialise the views that will be populated with data
    private TextView bookTitle;
    private TextView bookAuthors;
    private TextView bookDescription;
    private ImageView bookImage;
    private Button linkbutton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        // initialise the views that will be populated with data
        bookTitle = (TextView) findViewById(R.id.details_title);
        bookAuthors = (TextView) findViewById(R.id.details_author);
        bookDescription = (TextView) findViewById(R.id.details_description);
        bookImage = (ImageView) findViewById(R.id.details_thumbnail);
linkbutton = (Button) findViewById(R.id.link_button);

        // populate the views with data
        final Book book = (getIntent().getParcelableExtra(Book.BOOK));
        bookTitle.setText(book.getTitle());
        bookAuthors.setText(book.getAuthor());
        bookDescription.setText(book.getDescription());
        String imageLink = book.getImageSmallThumbLink();
        // add onClickListener for the search button

        linkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri bookUri = Uri.parse(book.geturl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
        // use of Picasso library to set ImageView
        // at first we check, whether the String with image link is not empty
        if (!imageLink.matches("")) {
            Picasso.with(getApplicationContext())
                    .load(imageLink)
                    .resize((int) getApplicationContext().getResources().getDimension(R.dimen.width_of_book_image), (int) getApplicationContext().getResources().getDimension(R.dimen.height_of_book_image))
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .centerInside()
                    .into(bookImage);
        } else {
            Picasso.with(getApplicationContext())
                    .load(R.drawable.ic_launcher_background)
                    .resize((int) getApplicationContext().getResources().getDimension(R.dimen.width_of_book_image), (int) getApplicationContext().getResources().getDimension(R.dimen.height_of_book_image))
                    .centerInside()
                    .into(bookImage);
        }
    }
}