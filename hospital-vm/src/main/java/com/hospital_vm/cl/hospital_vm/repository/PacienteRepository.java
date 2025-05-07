package com.hospital_vm.cl.hospital_vm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital_vm.cl.hospital_vm.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
