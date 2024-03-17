package com.angelobezutti.spotifyapi.controller;


import com.angelobezutti.spotifyapi.client.Album;
import com.angelobezutti.spotifyapi.client.AlbumSpotifyClient;
import com.angelobezutti.spotifyapi.client.AuthSpotifyClient;
import com.angelobezutti.spotifyapi.client.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;

    private final AlbumSpotifyClient albumSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient, AlbumSpotifyClient albumSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> helloWorld(){
        var request = new LoginRequest(
                "client_credentials",
                "my_clientId",
                "myclient_secret"
        );

        var token = authSpotifyClient.login(request).accessToken();

        var response = albumSpotifyClient.getReleases("Bearer "+ token);

        return ResponseEntity.ok(response.albums().items());
    }

}
