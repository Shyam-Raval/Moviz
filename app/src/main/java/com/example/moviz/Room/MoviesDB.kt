package com.example.moviz.Room

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviz.Retrofit.Movie


@Database(entities = [Movie::class],version = 1)
abstract class MoviesDB: RoomDatabase() {
    //DAO istance
    abstract val moviesDao: MovieDAO

    //singleton design pattern
    //only one instance of the DB exists  avoiding
    // unnecessary multiple instance associated with
    // DB creation
    companion object {
        //Volatile : prevents any possible race
        //conditions in Multithreading
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun getInstance(context: Context): MoviesDB? {
            //ensures that only one thread  can execute the
            //block of code inside the synch block at
            //any gives time
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        "movies_db"

                    ).build()
                }
                INSTANCE = instance
                return instance
            }

        }


    }

}