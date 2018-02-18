package com.example.android.booklistingxq;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SAMO on 2/12/2018.
 */

public class Book implements Parcelable {

    private String title , authors , price , currency , url;
    private String description;
    private String imageSmallThumbLink;


    protected static final String BOOK = "BOOK";
    public Book( String mtitle, String mauthors, String mdescription, String mimageSmallThumbLink, String mprice , String mcurrency ,String murl){
     title = mtitle;
    authors = mauthors;
    description = mdescription;
    imageSmallThumbLink = mimageSmallThumbLink;
    price = mprice ;
    currency = mcurrency ;
    url = murl ;
    }




    public String getTitle() {
        return title ;
    }

    public String getAuthor() {
        return authors ;
    }


    public String getDescription() {return  description;}

    public String getImageSmallThumbLink() {return imageSmallThumbLink ;}

    public String getPrice() {return  price + currency;}

   public String geturl() {return  url ;}


    @Override
    public int describeContents() {
        return 0;
    }

    protected Book(Parcel in) {
        title = in.readString();
        authors = in.readString();
        imageSmallThumbLink = in.readString();
        description = in.readString();
        price = in.readString();
        currency = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(authors);
        dest.writeString(imageSmallThumbLink);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeString(currency);
        dest.writeString(url);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
