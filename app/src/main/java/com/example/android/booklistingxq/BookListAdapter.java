package com.example.android.booklistingxq;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SAMO on 2/12/2018.
 */


public class BookListAdapter extends ArrayAdapter<Book> {
    public BookListAdapter(Context context, int resource, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // instruct the method to reuse the views
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // initialise the views that will be populated with data
        TextView bookTitle = (TextView) listViewItem.findViewById(R.id.title);
        TextView bookAuthors = (TextView) listViewItem.findViewById(R.id.authors);
      //  TextView bookDate = (TextView) listViewItem.findViewById(R.id.date);
        TextView bookDescription = (TextView) listViewItem.findViewById(R.id.description);

        TextView bookPrice = (TextView) listViewItem.findViewById(R.id.price);
     //   TextView bookCurrency = (TextView) listViewItem.findViewById(R.id.);

        ImageView bookImageThumbnail = (ImageView) listViewItem.findViewById(R.id.book_image);



        // get each item from the List
        Book currentListItem = getItem(position);

        // populate the views with data
        bookTitle.setText(currentListItem.getTitle());
        bookAuthors.setText(currentListItem.getAuthor());
        bookDescription.setText(currentListItem.getDescription());
        bookPrice.setText(currentListItem.getPrice());

      //  bookDate.setText(currentListItem.getDate());

        // use of Picasso library to set ImageView
        // at first we check, whether the String with image link is not empty
        if (!currentListItem.getImageSmallThumbLink().matches("")) {
            Picasso.with(getContext())
                    .load(currentListItem.getImageSmallThumbLink())
                    .resize((int) getContext().getResources().getDimension(R.dimen.width_of_book_image_thumbnail), (int) getContext().getResources().getDimension(R.dimen.height_of_book_image_thumbnail))
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .centerInside()
                    .into(bookImageThumbnail);
        } else {
            Picasso.with(getContext())
                    .load(R.drawable.ic_launcher_background)
                    .resize((int) getContext().getResources().getDimension(R.dimen.width_of_book_image_thumbnail), (int) getContext().getResources().getDimension(R.dimen.height_of_book_image_thumbnail))
                    .centerInside()
                    .into(bookImageThumbnail);
        }

        // returns an inflated ListView Item
        return listViewItem;
    }

}