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
    boolean isEmpty();
    int size();
    void addSong(Song song);
    void removeSong(Song song);
    Song searchSong(String title);
    void print();    
}
