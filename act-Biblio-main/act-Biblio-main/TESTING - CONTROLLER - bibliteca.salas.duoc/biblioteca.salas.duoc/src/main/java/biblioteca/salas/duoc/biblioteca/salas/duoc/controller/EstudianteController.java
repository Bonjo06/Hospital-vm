package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "Operaciones relacionadas con los estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes", description = "Lista todos los estudiantes registrados")
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar un estudiante", description = "Lista un estudiante especifico mediante ID")
    public Estudiante getEstudianteById(@PathVariable Integer id) {
        return estudianteService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un estudiante", description = "Registra un nuevo estudiante")
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un estudiante", description = "Actualiza un estudiante mediante el ID")
    public Estudiante updateEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteService.save(estudiante);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un estudiante", description = "Elimina un estudiante mediante el ID")
    public void deleteEstudiante(@PathVariable Integer id) {
        estudianteService.deleteById(id);
    }
}
