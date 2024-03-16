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
  // Represents the liked playlist managed by the music manager
    private LikedPlaylist likedPlaylist;
    // Represents the list of genre playlists managed by the music manager
    private List<Genre> genrePlaylists;
    // Represents whether the last song was moved to a genre playlist
    private boolean lastSongMoved;

    // Constructor for creating a MusicManager object.
    public MusicManager() {
        likedPlaylist = new LikedPlaylist();
        genrePlaylists = new ArrayList<>();
        // Initialize genre playlists for Rock and Pop
        Genre rockPlaylist = new Genre("Rock");
        Genre popPlaylist = new Genre("Pop");
        genrePlaylists.add(rockPlaylist);
        genrePlaylists.add(popPlaylist);
        lastSongMoved = false; // Initialize the flag
    }

    // Getter method for retrieving the liked playlist.
    public LikedPlaylist getLikedPlaylist() {
        return likedPlaylist;
    }

    // Getter method for retrieving the list of genre playlists.
    public List<Genre> getGenrePlaylists() {
        return genrePlaylists;
    }

    // Method to add a genre playlist to the music manager.
    public void addGenrePlaylist(Genre playlist) {
        genrePlaylists.add(playlist);
    }

    // Method to add a song to a specified genre playlist.
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

    // Method to add a song to the liked playlist.
    public void addSongToLikedPlaylist(String title, String artist) {
        likedPlaylist.addSong(new Song(title, artist));
        lastSongMoved = false; // Reset the flag whenever a new song is added to the liked playlist
    }

    // Method to move the last added song from the liked playlist to a genre playlist.
    public void moveLastAddedSongToGenrePlaylist(String genre) {
        // Get the last added song from the liked playlist
        Song lastAddedSong = likedPlaylist.getLastAddedSong();

        // Check if there's a last added song and it hasn't been moved yet
        if (lastAddedSong != null && !lastSongMoved) {
            // Delete the last added song from the liked playlist
            likedPlaylist.deleteSong(lastAddedSong.getTitle());

            // Add the last added song to the specified genre playlist
            Genre targetGenre = null;
            for (Genre genrePlaylist : genrePlaylists) {
                if (genrePlaylist.getGenre().equalsIgnoreCase(genre)) {
                    targetGenre = genrePlaylist;
                    break;
                }
            }

            if (targetGenre != null) {
                // Add the last added song to the genre playlist
                targetGenre.addSong(lastAddedSong);

                // Mark the last song as moved
                lastSongMoved = true;

                // Show JOptionPane message confirming the move
                JOptionPane.showMessageDialog(null, "Last added song \"" + lastAddedSong.getTitle() + "\" moved to " + genre + " playlist.");

                // Set the second last song as the new last added song
                lastAddedSong = likedPlaylist.getLastAddedSong();
                if (lastAddedSong != null) {
                    lastSongMoved = false; // Reset the flag for the new last song
                }
            } else {
                // Show JOptionPane message if the genre playlist doesn't exist
                JOptionPane.showMessageDialog(null, "Genre playlist for \"" + genre + "\" does not exist.");
            }
        } else {
            // Show JOptionPane message if there are no songs in the liked playlist to move or the last song has already been moved
            JOptionPane.showMessageDialog(null, "No songs in liked playlist to move or last song already moved.");
        }
    }

    // Method to search for a song by its title in the liked playlist and genre playlists.
    public Song searchSong(String title) {
        int choice = JOptionPane.showConfirmDialog(null, "Please choose YES for Liked Playlist and NO for Genre Playlist");
        
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