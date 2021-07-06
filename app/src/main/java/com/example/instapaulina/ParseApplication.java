package com.example.instapaulina;

import android.app.Application;

import com.parse.Parse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // set applicationId, and server server based on the values in the back4app settings.
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("q2WRDBEuE2gLsHUkXTd8xHSSpPS47kfDBQOMgwD2")
                .clientKey("4OeG0j9mK5TDGnhJ2TONlLGenLb8HlUNaHGYuFly")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
