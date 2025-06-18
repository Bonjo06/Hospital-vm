package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@Tag(name = "Carreras", description = "Operaciones relacionadas con las carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    @Operation(summary = "Listar todas las carreras", description = "Obtiene una lista de las carreras")
    public List<Carrera> getAllCarreras() {
        return carreraService.findAll();
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Listar una carrera", description = "Obtiene una carrera mediante el ID")
    public Carrera getCarreraByCodigo(@PathVariable String codigo) {
        return carreraService.findByCodigo(codigo);
    }

    @PostMapping
    @Operation(summary = "Registrar una carrera", description = "Registra una nueva carrera")
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/{codigo}")
    @Operation(summary = "Actualizar una carrera", description = "Actualiza los datos de una carrera mediante el ID")
    public Carrera updateCarrera(@PathVariable String codigo, @RequestBody Carrera carrera) {
        carrera.setCodigo(codigo);
        return carreraService.save(carrera);
    }

    @DeleteMapping("/{codigo}")
    @Operation(summary = "Eliminar una carrera", description = "Elimina una carrera mediante el ID")
    public void deleteCarrera(@PathVariable String codigo) {
        carreraService.deleteByCodigo(codigo);
    }
}
