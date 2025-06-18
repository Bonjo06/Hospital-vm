package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.SalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
@Tag(name = "Salas", description = "Operaciones relacionadas a las salas")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @GetMapping
    @Operation(summary = "Listar todas las salas", description = "Lista todas las salas registradas")
    public List<Sala> getAllSalas() {
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar una sala", description = "Listar sala mediante ID")
    public Sala getSalaById(@PathVariable Integer id) {
        return salaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar sala", description = "Registra una nueva sala")
    public Sala createSala(@RequestBody Sala sala) {
        return salaService.save(sala);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar sala", description = "Actualiza una sala mediante ID")
    public Sala updateSala(@PathVariable Integer id, @RequestBody Sala sala) {
        sala.setCodigo(id);
        return salaService.save(sala);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Sala", description = "Elimina una sala registrada mediante ID")
    public void deleteSala(@PathVariable Integer id) {
        salaService.deleteById(id);
    }
}
