package com.cristianAlbornoz.ShopRopa.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cliente/")
@RequiredArgsConstructor
public class ClienteController {

    @GetMapping("demo")
    public String saludo() {
        return "Cliente";
    }
}