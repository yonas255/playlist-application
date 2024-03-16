/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplaylistapplication;

/**
 *
 * @author yonas
 */
public class Node {
   private Song song;
   private Node next;
    
   // constructor 
    public Node(Song song) {
        this.song = song;
        this.next = null;
    }

    //setters and getters 
    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

   
}