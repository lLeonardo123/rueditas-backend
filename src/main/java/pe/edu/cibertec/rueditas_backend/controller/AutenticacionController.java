package pe.edu.cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_backend.dto.AutoRequestDTO;
import pe.edu.cibertec.rueditas_backend.dto.AutoResponseDTO;
import pe.edu.cibertec.rueditas_backend.service.AutenticacionService;


@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/auto")
    public AutoResponseDTO datosAuto(@RequestBody AutoRequestDTO autoRequestDTO){

        try {
            String[] datosAuto = autenticacionService.validarAuto(autoRequestDTO);
            if (datosAuto == null){
                return new AutoResponseDTO("01", "Error no se encontro registrado la plata","","","","","");
            }
            return new AutoResponseDTO("00", "", datosAuto[0], datosAuto[1], datosAuto[2], datosAuto[3], datosAuto[4]);
        } catch (Exception e) {

            System.out.println(e.getMessage());

            return new AutoResponseDTO("99", "Error Ocurrio un problema","","","","","");
        }
    }
}
