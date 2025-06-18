package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Operaciones relacionadas a reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    @Operation(summary = "Listar todas las reservas", description = "Lista todas las reservas registradas")
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar una reserva", description = "Lista una reserva mediante ID")
    public Reserva getReservaById(@PathVariable Integer id) {
        return reservaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Registrar reserva", description = "Registra una nueva reserva")
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva", description = "Actualiza una reserva mediante ID")
    public Reserva updateReserva(@PathVariable Integer id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva", description = "Elimina una reserva mediante ID")
    public void deleteReserva(@PathVariable Integer id) {
        reservaService.deleteById(id);
    }
}