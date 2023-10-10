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
public final class Band8601 {
    private static AlbumInfo album = null;
    
    private Band8601() {throw new UnsupportedOperationException("Cannot create instance of static class Band8601.");}
    
    public static String getProductCode()
    {
        return "8601";
    }
    
    public static AlbumInfo getAlbumInfo()
    {
        if (album == null)
        {
            var star = new SongInfo("You Are a Star", "../AlbumsWebApp/songs/8601/star.mp3", "MP3");
            var noDifference = new SongInfo("Don't Make No Difference", "../AlbumsWebApp/songs/8601/no_difference.mp3", "MP3");

            var list = List.of(star, noDifference);

            album = new AlbumInfo("86 (the band) - True Life Songs and Pictures", list);
        }
        
        return album;
    }
}
