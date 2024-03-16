/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package musicplaylistapplication;

/**
 *
 * @author yonas
 */
public interface PlayListInterface {
   void addSong(Song song);//add a song to the playlist.
    void deleteSong(String title);// delete for a song by title
    Song searchSong(String title);// search for a song by title
    void printPlaylist();// print the song list
    int countSongs();// count the songs in the playlsit
}



