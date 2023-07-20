package com.cristianAlbornoz.ShopRopa.controller.auth;

import com.cristianAlbornoz.ShopRopa.DTO.UsuarioDTO;
import com.cristianAlbornoz.ShopRopa.Utils.ExceptionsResponse.ResponseExGen;
import com.cristianAlbornoz.ShopRopa.Utils.ResponseAuth;
import com.cristianAlbornoz.ShopRopa.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth/")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("register")
    public ResponseEntity<ResponseAuth> saludo(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuarioService.register(usuarioDTO), HttpStatus.CREATED);
    }

    @PostMapping("authenticate")
    public ResponseEntity<ResponseAuth> authentication(@Valid @RequestBody UsuarioDTO usuarioDTO) throws ResponseExGen {
        return new ResponseEntity<>(usuarioService.authentication(usuarioDTO), HttpStatus.ACCEPTED);

    }
}
