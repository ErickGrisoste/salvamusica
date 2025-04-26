package com.erick.salvamusica.service;

import com.erick.salvamusica.dto.LoginDTO;
import com.erick.salvamusica.dto.MusicaDTO;
import com.erick.salvamusica.model.Musica;
import com.erick.salvamusica.model.Usuario;
import com.erick.salvamusica.repository.MusicaRepository;
import com.erick.salvamusica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MusicaRepository musicaRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario cadastrar(Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public boolean autenticar(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.email())
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        boolean senhaCorreta = passwordEncoder.matches(loginDTO.senha(), usuario.getSenha());

        if (!senhaCorreta) {
            throw new RuntimeException("Senha incorreta");
        }

        return true;
    }


    public void favoritarMusica(Long usuarioId, MusicaDTO musicaDTO){
       Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Musica musica = musicaRepository.findByNomeAndArtista(
                musicaDTO.title(),
                musicaDTO.artist().name()
        ).orElseGet(() -> {
            Musica nova = new Musica(musicaDTO);
            return musicaRepository.save(nova);
        });

        if (!usuario.getFavoritas().contains(musica)) {
            usuario.getFavoritas().add(musica);
            usuarioRepository.save(usuario);
        }
    }

    public List<Musica> listarFavs(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        return usuario.getFavoritas();
    }
}

