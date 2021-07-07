package com.example.instapaulina;

import android.app.Application;

import com.example.instapaulina.Models.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        // set applicationId, and server server based on the values in the back4app settings.
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("q2WRDBEuE2gLsHUkXTd8xHSSpPS47kfDBQOMgwD2")
                .clientKey("4OeG0j9mK5TDGnhJ2TONlLGenLb8HlUNaHGYuFly")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
