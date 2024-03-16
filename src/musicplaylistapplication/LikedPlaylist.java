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
    // Reference to the head of the linked list containing songs
    private Node head;
    // Represents the last song added to the playlist
    private Song lastAddedSong;

    // Constructor for creating a LikedPlaylist object.
    public LikedPlaylist() {
        this.head = null;
        this.lastAddedSong = null;
    }

    // Getter method for retrieving the head node of the playlist.
    public Node getHead() {
        return head;
    }

    // Method to add a song to the liked playlist.
    @Override
    public void addSong(Song song) {
        // Create a new node with the song
        Node newNode = new Node(song);
        // If the playlist is empty, set the new node as the head
        if (head == null) {
            head = newNode;
        } else {
            // Traverse the list to find the last node and append the new node to it
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        lastAddedSong = song; // Update the last added song
    }

    // Method to delete a song from the liked playlist.
    @Override
    public void deleteSong(String title) {
        // If the playlist is empty, return
        if (head == null) {
            return;
        }
        // If the head node contains the song to be deleted, set the next node as the head
        if (head.getSong().getTitle().equals(title)) {
            head = head.getNext();
            if (head == null) {
                lastAddedSong = null; // If the playlist becomes empty, reset lastAddedSong
            }
            return;
        }
        // Traverse the list to find the node containing the song and adjust the links
        Node prev = null;
        Node current = head;
        while (current != null && !current.getSong().getTitle().equals(title)) {
            prev = current;
            current = current.getNext();
        }
        if (current != null) {
            prev.setNext(current.getNext());
            if (current.getNext() == null) {
                lastAddedSong = prev.getSong(); // Update lastAddedSong when the last node is deleted
            }
        }
    }

    // Method to search for a song in the liked playlist by its title.
    @Override
    public Song searchSong(String title) {
        Node current = head;
        // Traverse the list to find the song with the given title
        while (current != null) {
            if (current.getSong().getTitle().equalsIgnoreCase(title)) {
                return current.getSong();
            }
            current = current.getNext();
        }
        return null; // Song not found
    }

    // Method to print the liked playlist.
    @Override
    public void printPlaylist() {
        // If the playlist is empty, show a message and return
        if (head == null) {
            JOptionPane.showMessageDialog(null, "Liked Playlist is empty. No songs to display.");
            return;
        }
        
        // Build the playlist text
        StringBuilder playlistText = new StringBuilder();
        Node current = head;
        while (current != null) {
            playlistText.append(current.getSong()).append("\n");
            current = current.getNext();
        }
        
        // Show the playlist text in a JOptionPane message dialog
        JOptionPane.showMessageDialog(null, "Liked Playlist:\n" + playlistText.toString());
    }

    // Method to count the number of songs in the liked playlist.
    @Override
    public int countSongs() {
        // If the playlist is empty, show a message and return 0
        if (head == null) {
            JOptionPane.showMessageDialog(null, "Liked playlist is empty.");
            return 0;
        }

        int likedCount = 0;
        Node current = head;
        // Traverse the list to count the songs
        while (current != null) {
            likedCount++;
            current = current.getNext();
        }

        // Show the number of songs in the playlist in a JOptionPane message dialog
        JOptionPane.showMessageDialog(null, "Number of liked songs: " + likedCount);
        return likedCount;
    }

    // Method to get the last added song to the playlist.
    public Song getLastAddedSong() {
        return lastAddedSong;
    }

    // Method to check if a song with a given title exists in the liked playlist.
    public boolean containsSong(String title) {
        Node current = head;
        // Traverse the list to check if the song with the given title exists
        while (current != null) {
            if (current.getSong().getTitle().equals(title)) {
                return true;
            }
            current = current.getNext();
        }
        return false; // Song not found
    }
}