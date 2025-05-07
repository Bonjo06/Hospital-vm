package com.hospital_vm.cl.hospital_vm.repository;


import com.hospital_vm.cl.hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    //Encontrar pacientes por apellido
    List<Paciente> findByApellidos(String apellidos);

    //Encontrar pacientes por correo
    List<Paciente> findByCorreo(String correo);

    //Encontrar pacientes por nombre y apellido
    List<Paciente> findByNombresAndApellidos(String nombres, String apellidos);

}
