/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplaylistapplication;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author yonas
 */
public class LikedPlaylist implements PlayListInterface {
    private Node head;
    private Song lastAddedSong;

    public LikedPlaylist() {
        this.head = null;
        this.lastAddedSong = null;
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
        if (current.getSong().getTitle().equalsIgnoreCase(title)) {
            return current.getSong();
        }
        current = current.getNext();
    }
    return null;
    }

    @Override
    public void printPlaylist() {
      if (head == null) {
        JOptionPane.showMessageDialog(null, "Liked Playlist is empty. No songs to display.");
        return;
    }
    
    StringBuilder playlistText = new StringBuilder();
    Node current = head;
    while (current != null) {
        playlistText.append(current.getSong()).append("\n");
        current = current.getNext();
    }
    
    JOptionPane.showMessageDialog(null, "Liked Playlist:\n" + playlistText.toString());
    }

    @Override
    public int countSongs() {
    if (head == null) {
        JOptionPane.showMessageDialog(null, "Liked playlist is empty.");
        return 0;
    }

    int likedCount = 0;
    Node current = head;
    while (current != null) {
        likedCount++;
        current = current.getNext();
    }

    JOptionPane.showMessageDialog(null, "Number of liked songs: " + likedCount);
    return likedCount;

    
    }
 
    
    // New method to get the last added song
    public Song getLastAddedSong() {
        return lastAddedSong;
    }

    public boolean containsSong(String title) {
        Node current = head;
        while (current != null) {
            if (current.getSong().getTitle().equals(title)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}