package com.angelobezutti.spotifyapi.controller;


import com.angelobezutti.spotifyapi.client.AuthSpotifyClient;
import com.angelobezutti.spotifyapi.client.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;

    public AlbumController(AuthSpotifyClient authSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
    }

    @GetMapping("/albums")
    public ResponseEntity<String> helloWorld(){
        var request = new LoginRequest(
                "client_credentials",
                "my_clientId",
                "myclient_secret"
        );
        return ResponseEntity.ok(authSpotifyClient.login(request).getAccessToken());
    }

}
