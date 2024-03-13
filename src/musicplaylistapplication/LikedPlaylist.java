/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplaylistapplication;

import java.util.List;

/**
 *
 * @author yonas
 */
public class LikedPlaylist implements PlayListInterface {
    private List<Song> songs;

    public LikedPlaylist(List<Song> songs) {
        this.songs = songs;
    }

    

     @Override
    public boolean isEmpty() {
      return songs.isEmpty();
 
    }

    @Override
    public int size() {
      
        return songs.size();
    }

    @Override
    public void addSong(Song song) {
       
    }

    @Override
    public void removeSong(Song song) {
        
    }

    @Override
    public Song searchSong(String title) {
    }

    @Override
    public void print() {

    }  
}
