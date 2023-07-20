package com.cristianAlbornoz.ShopRopa.Utils;

import com.cristianAlbornoz.ShopRopa.DTO.UsuarioDTO;
import com.cristianAlbornoz.ShopRopa.model.Usuario;

public class Mapper {
    public Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder().email(usuarioDTO.getEmail()).rol(usuarioDTO.getRol()).password(usuarioDTO.getPassword()).build();
    }
}
