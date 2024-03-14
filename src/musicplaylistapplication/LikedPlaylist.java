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
    private Node head;

    public LikedPlaylist() {
        this.head = null;
    }

    

     @Override
    public boolean isEmpty() {
      return head==null;
 
    }

    @Override
    public int size() {
     int count=0;
     Node current=head;
        while(current !=null){
        }
        
        return count;
    }
    @Override
    public void addSong(Song song) {
     Node newNode = new Node(song); 
     if(isEmpty()){
        head=newNode;
     }else{
       Node current= head;
       while (current.getNext() != null){
         current = current.getNext();
       }
       current.setNext(newNode);
     }
    }

    @Override
    public void removeSong(Song song) {
      if (isEmpty()){
      return;
      }
      if(head.getSong().equals(song)){
         head=head.getNext();
        return; 
      }
      Node prev=null;
      Node current = head;
      while(current != null&& !current.getSong().equals(song)){
          prev=current;
          current=current.getNext();
      }
      if(current != null){
          prev.setNext(current.getNext());
      }
    }
      
    @Override
    public Song searchSong(String title) {
       Node current= head;
       while (current != null){
          if(current.getSong().getTitle().equals(title)){
              return current.getSong();
          }
           current= current.getNext();  
       }
       return null;
    }

    @Override
    public void print() {
        System.out.println("Liked Playlist");
        Node current = head;
        while(current!= null){
            System.out.println(current.getSong());
            current=current.getNext();
        }
    }  
}
