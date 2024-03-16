/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplaylistapplication;

import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author yonas
 */
public class LikedPlaylist implements PlayListInterface {
     private Node head;
    private Song lastAddedSong; // Add a field to store the last added song

    public LikedPlaylist() {
        this.head = null;
        this.lastAddedSong = null; // Initialize the last added song to null
    }

    public Node getHead() {
        return head;
    }

    @Override
    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        // Update the last added song whenever a new song is added
        lastAddedSong = song;
    }

    @Override
    public void deleteSong(String title) {
        if (head == null) {
            return;
        }
        if (head.getSong().getTitle().equals(title)) {
            head = head.getNext();
            return;
        }
        Node prev = null;
        Node current = head;
        while (current != null && !current.getSong().getTitle().equals(title)) {
            prev = current;
            current = current.getNext();
        }
        if (current != null) {
            prev.setNext(current.getNext());
        }
    }

    @Override
    public Song searchSong(String title) {
        Node current = head;
        while (current != null) {
            if (current.getSong().getTitle().equals(title)) {
                return current.getSong();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public void printPlaylist() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getSong());
            current = current.getNext();
        }
    }

    @Override
    public int countSongs() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    } 
    
    // New method to get the last added song
   public Song getLastAddedSong() {
    Node current = head;
    Node lastNode = null;
    while (current != null) {
        lastNode = current;
        current = current.getNext();
    }
    if (lastNode != null) {
        return lastNode.getSong();
    } else {
        return null; // Liked playlist is empty
    }
   }
   
 public boolean containsSong(String title, String artist) {
    Node current = head;
    while (current != null) {
        Song song = current.getSong();
        if (song.getTitle().equals(title) && song.getArtist().equals(artist)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
}


}