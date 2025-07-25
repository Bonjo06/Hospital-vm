package com.perfulandia_spa.perfulandia_spa.Controller;


import java.util.List;
import com.perfulandia_spa.perfulandia_spa.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia_spa.perfulandia_spa.Model.Usuario;

@RestController

//Anotacion que indica la ruta base dentro de la API
@RequestMapping("/api/v1/admin/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Anotacion para listar todos los usuarios de la BD
    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(usuarios);
    }

    //Anotacion para agregar un nuevo usuario en la BD
    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo); 
    }

    //Anotacion para buscar un usuario en la BD mediante el id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id){
        try{
            Usuario usuario = usuarioService.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //Anotacion para actualizar un usuario en la BD mediante el id
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        try{
            Usuario usu = usuarioService.findById(id);
            usu.setId(id);          
            usu.setNombres(usuario.getNombres());
            usu.setApellidos(usuario.getApellidos());
            usu.setCorreo(usuario.getCorreo());
            usu.setUserDireccion(usuario.getUserDireccion());

            usuarioService.save(usu);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //Anotacion para eliminar un usuario en la BD mediante el id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try{
            usuarioService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
