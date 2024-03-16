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
   void addSong(Song song);
    void deleteSong(String title);
    Song searchSong(String title);
    void printPlaylist();
    int countSongs();
}



