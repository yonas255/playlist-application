/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplaylistapplication;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author yonas
 */
public class MusicManager {
   private LikedPlaylist likedPlaylist;
    private List<Genre> genrePlaylists;
    private boolean lastSongMoved;

    public MusicManager() {
        likedPlaylist = new LikedPlaylist();
        genrePlaylists = new ArrayList<>();
        Genre rockPlaylist = new Genre("Rock");
        Genre popPlaylist = new Genre("Pop");
        genrePlaylists.add(rockPlaylist);
        genrePlaylists.add(popPlaylist);
        lastSongMoved = false; // Initialize the flag
    }

    public LikedPlaylist getLikedPlaylist() {
        return likedPlaylist;
    }

    public List<Genre> getGenrePlaylists() {
        return genrePlaylists;
    }

    public void addGenrePlaylist(Genre playlist) {
        genrePlaylists.add(playlist);
    }

    public void addSongToGenrePlaylist(String title, String artist, String genre) {
        // Check if the song already exists in any genre playlist
        for (Genre playlist : genrePlaylists) {
            if (playlist.containsSong(title)) {
                System.out.println("Song \"" + title + "\" already exists in another genre playlist. Removing from " + playlist.getGenre() + " playlist.");
                playlist.deleteSong(title);
            }
        }

        // Add the song to the specified genre playlist
        Genre targetPlaylist = null;
        for (Genre playlist : genrePlaylists) {
            if (playlist.getGenre().equalsIgnoreCase(genre)) {
                targetPlaylist = playlist;
                break;
            }
        }

        if (targetPlaylist != null) {
            targetPlaylist.addSong(new Song(title, artist));
            System.out.println("Song \"" + title + "\" added to " + genre + " playlist.");
        } else {
            System.out.println("Genre playlist for \"" + genre + "\" does not exist.");
        }
    }

    public void addSongToLikedPlaylist(String title, String artist) {
        likedPlaylist.addSong(new Song(title, artist));
        lastSongMoved = false; // Reset the flag whenever a new song is added to the liked playlist
    }

    public void moveLastAddedSongToGenrePlaylist(String genre) {
        Song lastAddedSong = likedPlaylist.getLastAddedSong();
        if (lastAddedSong != null && !lastSongMoved) {
            likedPlaylist.deleteSong(lastAddedSong.getTitle()); // Remove from Liked Playlist
            lastSongMoved = true;
            addSongToGenrePlaylist(lastAddedSong.getTitle(), lastAddedSong.getArtist(), genre);
            System.out.println("Last added song \"" + lastAddedSong.getTitle() + "\" moved to " + genre + " playlist.");
        } else {
            System.out.println("No songs in liked playlist to move or last song already moved.");
        }
    }

    public Song searchSong(String title) {
  int choice = JOptionPane.showConfirmDialog(null, "Do you want to search in Liked Playlist?");
    
    if (choice == JOptionPane.YES_OPTION) {
        return likedPlaylist.searchSong(title);
    } else if (choice == JOptionPane.NO_OPTION) {
        // Search in the Genre playlists
        for (Genre genrePlaylist : genrePlaylists) {
            Song song = genrePlaylist.searchSong(title);
            if (song != null) {
                return song;
            }
        }
    }
    
    return null; // This line will be executed only if the user cancels the dialog or closes it
  }
}