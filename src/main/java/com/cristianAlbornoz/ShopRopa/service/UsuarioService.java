package com.cristianAlbornoz.ShopRopa.service;

import com.cristianAlbornoz.ShopRopa.DTO.UsuarioDTO;
import com.cristianAlbornoz.ShopRopa.Utils.ResponseAuth;

public interface UsuarioService {

    ResponseAuth register(UsuarioDTO usuario);

    ResponseAuth authentication(UsuarioDTO usuarioDTO);

}
