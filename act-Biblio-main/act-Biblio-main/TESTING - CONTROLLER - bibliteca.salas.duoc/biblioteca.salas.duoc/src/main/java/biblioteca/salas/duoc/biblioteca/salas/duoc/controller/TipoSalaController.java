package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-salas")
@Tag(name = "Tipo Salas", description = "Operaciones relacionadas a los tipo de salas")
public class TipoSalaController {
    @Autowired
    private TipoSalaService tipoSalaService;

    @GetMapping
    @Operation(summary = "Listar los tipos de sala", description = "Lista todos los tipos de sala registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación exitosa",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = TipoSala.class))),
        @ApiResponse(responseCode = "404", description = "Tipo de sala no registrada")
        })

    public List<TipoSala> getAllTipoSalas() {
        return tipoSalaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar un tipo de sala", description = "Lista un tipo de sala mediante ID")
    public TipoSala getTipoSalaById(@PathVariable Integer id) {
        return tipoSalaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un tipo de sala", description = "Registra un nuevo tipo de sala")
    public TipoSala createTipoSala(@RequestBody TipoSala tipoSala) {
        return tipoSalaService.save(tipoSala);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tipo de sala", description = "Actualiza un tipo de sala mediante ID")
    public TipoSala updateTipoSala(@PathVariable Integer id, @RequestBody TipoSala tipoSala) {
        tipoSala.setIdTipo(id);
        return tipoSalaService.save(tipoSala);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un tipo de sala", description = "Elimina un tipo de sala mediante ID")
    public void deleteTipoSala(@PathVariable Integer id) {
        tipoSalaService.deleteById(id);
    }
}
