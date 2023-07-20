package com.cristianAlbornoz.ShopRopa.service;


import com.cristianAlbornoz.ShopRopa.DTO.UsuarioDTO;
import com.cristianAlbornoz.ShopRopa.JWT.JWTService;
import com.cristianAlbornoz.ShopRopa.Utils.ExceptionsResponse.ResponseExGen;
import com.cristianAlbornoz.ShopRopa.Utils.Mapper;
import com.cristianAlbornoz.ShopRopa.Utils.ResponseAuth;
import com.cristianAlbornoz.ShopRopa.model.Usuario;
import com.cristianAlbornoz.ShopRopa.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final PasswordEncoder encode;
    private final UsuarioRepository usuarioRepository;
    private final JWTService jwtService;
    private final Mapper mapper;
    private final AuthenticationManager authenticationManager;

    public ResponseAuth register(UsuarioDTO usuario) {
        try {
            Usuario newUser = mapper.usuarioDtoToUsuario(usuario);
            newUser.setPassword(encode.encode(usuario.getPassword()));
            usuarioRepository.save(newUser);
            return ResponseAuth.builder().token(jwtService.generateToken(newUser)).build();
        } catch (Exception e) {
            return ResponseAuth.builder().build();
        }
    }

    public ResponseAuth authentication(UsuarioDTO usuario) {
        try {
            Usuario newUser = mapper.usuarioDtoToUsuario(usuario);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    newUser.getEmail(),
                    newUser.getPassword()
            ));
            return ResponseAuth.builder().token(jwtService.generateToken(newUser)).build();
        } catch (Exception e) {
            throw new ResponseExGen("500", HttpStatus.INTERNAL_SERVER_ERROR, "");
        }
    }
}
