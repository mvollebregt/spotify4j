package com.github.mvollebregt.spotify4j;

// This file is part of SpotifyDiscoverer.
//
// SpotifyDiscoverer is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// SpotifyDiscoverer is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with SpotifyDiscoverer.  If not, see <http://www.gnu.org/licenses/>.

import com.github.mvollebregt.musicmetamodel.Album;
import com.github.mvollebregt.musicmetamodel.Artist;
import com.github.mvollebregt.musicmetamodel.parser.MusicMetaParser;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author Michel Vollebregt
 */
public class SearchService {

    private static final String BASE_URL = "http://ws.spotify.com/search/1/";

    private MusicMetaParser parser = new MusicMetaParser();

    public List<Album> searchAlbum(String query) throws IOException, SAXException {
        URL url = new URL(BASE_URL + "album?q=" + query);
        return parser.parse(url.openStream());
    }

    public List<Artist> searchArtist(String query) throws IOException, SAXException {
        URL url = new URL(BASE_URL + "artist?q=" + query);
        return parser.parse(url.openStream());
    }

    public static void main(String[] args) throws Exception {
        List<Artist> artists = new SearchService().searchArtist("banshees");
        String id = artists.get(0).getId();
        Artist artist = new LookupService().lookupArtist(id);
        System.out.println("First found artist: " + artist);
    }

}
