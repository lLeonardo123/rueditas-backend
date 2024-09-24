package pe.edu.cibertec.rueditas_backend.service;

import pe.edu.cibertec.rueditas_backend.dto.AutoRequestDTO;

import java.io.IOException;

public interface AutenticacionService {
    String[] validarAuto(AutoRequestDTO autoRequestDTO) throws IOException;

}
