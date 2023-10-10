/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anhkhoapham.albumswebapp.songs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Khoapa
 */
public final class Albums {
    private static final Albums singleton = new Albums(); 
    private final Map<String, AlbumInfo> albumDict;
    
    private Albums() 
    {
        albumDict = new HashMap<String, AlbumInfo>();
        
        albumDict.put(Band8601.getProductCode(), Band8601.getAlbumInfo());
        albumDict.put(JR01.getProductCode(), JR01.getAlbumInfo());
        albumDict.put(PF01.getProductCode(), PF01.getAlbumInfo());
        albumDict.put(PF02.getProductCode(), PF02.getAlbumInfo());
    }
    
    
    
    public static Albums get()
    {
        return singleton;
    }
    
    public Map<String, AlbumInfo> getAlbumMap()
    {
        return albumDict;
    }
}


