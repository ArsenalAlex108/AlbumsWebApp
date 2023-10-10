/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.albumswebapp.songs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khoapa
 */
public class PF02 {
    private PF02() {throw new UnsupportedOperationException("Cannot create instance of static class PF02.");}
    
    private static AlbumInfo album = null;
    
    public static String getProductCode()
    {
        return "pf02";
    }
    
    public static AlbumInfo getAlbumInfo()
    {
        if (album == null)
        {
            var song1 = new SongInfo("PF02 Song 1", "../AlbumsWebApp/songs/pf01/song1.mp3", "MP3");
            var song2 = new SongInfo("PF02 Song 2", "../AlbumsWebApp/songs/pf01/song2.mp3", "MP3");

            var list = List.of(song1, song2);

            album = new AlbumInfo("Paddlefoot - The Second CD", list);
        }
        
        return album;
    }
}
