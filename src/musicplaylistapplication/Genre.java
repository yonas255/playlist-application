/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplaylistapplication;

/**
 *
 * @author yonas
 */
public class Genre implements PlayListInterface{
    private String genre;
    private Node head;

    public Genre(String genre) {
        this.genre = genre;
    }

    
    public String getGenre() {
        return genre;
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
        System.out.println("Genre: " + genre + ", " + current.getSong());
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
