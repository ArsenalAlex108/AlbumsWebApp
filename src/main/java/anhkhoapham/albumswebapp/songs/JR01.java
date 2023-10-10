/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.albumswebapp.songs;

import java.util.List;

/**
 *
 * @author Khoapa
 */
public final class JR01 {
    private JR01() {throw new UnsupportedOperationException("Cannot create instance of static class JR01.");}
    
    private static AlbumInfo album = null;
    
    public static String getProductCode()
    {
        return "jr01";
    }
    
    public static AlbumInfo getAlbumInfo()
    {
        if (album == null)
        {
            var song1 = new SongInfo("JR01 Song 1", "../AlbumsWebApp/songs/jr01/song1.mp3", "MP3");
            var song2 = new SongInfo("JR01 Song 2", "../AlbumsWebApp/songs/jr01/song2.mp3", "MP3");

            var list = List.of(song1, song2);

            album = new AlbumInfo("Joe Rut - Genuine Wood Grained Finish", list);
        }
        
        return album;
    }
}
