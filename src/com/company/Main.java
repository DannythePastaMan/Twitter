package com.company;

import java.io.*;

import twitter4j.*;
import java.util.ArrayList;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

    public static void main(String[] args) throws TwitterException, FileNotFoundException {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("t4BskFpLG4uascEadRdNwR948");
        cb.setOAuthConsumerSecret("7D44OTZh5a2JY9camKwGBU5hyvg2fUm87e9LVxKxmp3w4smAU3");
        cb.setOAuthAccessToken("2841807462-GMSK5i9dCM0GWkuS0tLuOZaQEkwPag93okUfuGz");
        cb.setOAuthAccessTokenSecret("5kEQBA8QO4CQPSHWHIdC6tnO6HS9lcQ1kv4plyliaSVq4");

        //genera una variable de twitter con los tokens de mi cuenta
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();

        //query es la palabra que se va a buscar en los tweets
        Query buscar = new Query("Unitec");

        //cantidad de tweets que me a retornar
        buscar.setCount(20);

        //los tweets que encontro
        QueryResult result = twitter.search(buscar);

        //una lista con cada tweet encontrado
        ArrayList tweets = (ArrayList) result.getTweets();

        //un ciclo for para crear una varaible tipo Status con cada tweet

        File file = new File("Tweets.txt");

        PrintWriter OP =  new PrintWriter(file);


        for (int i = 0; i < tweets.size(); i++) {
            Status t = (Status) tweets.get(i);
            OP.println(t);
            OP.close();
        }

    }
}