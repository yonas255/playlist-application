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
public class Genre implements PlayListInterface{
   private String genre;
    private List<Song> songs; 
    
     public Genre(String genre, List<Song> songs) {
        this.genre = genre;
        this.songs = songs;
    }


    
    
//implement playList methods 
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
     songs.add(song);
    }

    @Override
    public void removeSong(Song song) {
      songs.remove(song);
        
    }

    @Override
    public Song searchSong(String title) {
      for(Song song: songs){
      if(song.getTitle().equals(title)){
          return song;
      }
      }
      return null;
    }

    @Override
    public void print() {
      System.out.println("Playlist:"+ genre);
      for(Song song: songs){
          System.out.println(song.getTitle()+"-"+ song.getArtist());
      }
    }
}
 

