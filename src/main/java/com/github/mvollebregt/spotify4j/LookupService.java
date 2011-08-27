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

import com.github.mvollebregt.musicmetamodel.Artist;
import com.github.mvollebregt.musicmetamodel.parser.MusicMetaParser;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;

/**
 * @author Michel Vollebregt
 */
public class LookupService {

    private final static String BASE_URL = "http://ws.spotify.com/lookup/1/";

    private MusicMetaParser parser = new MusicMetaParser();

    public Artist lookupArtist(String spotifyUri) throws IOException, SAXException {
        URL url = new URL(BASE_URL + "?uri=" + spotifyUri);
        return parser.parse(url.openStream());
    }
}
