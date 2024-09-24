package pe.edu.cibertec.rueditas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_backend.dto.AutoRequestDTO;
import pe.edu.cibertec.rueditas_backend.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarAuto(AutoRequestDTO autoRequestDTO) throws IOException {

        String[] datosAuto = null;
        Resource resource = resourceLoader.getResource("classpath:autos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String linea;
            while((linea = br.readLine()) != null){

                String [] datos = linea.split(";");
                if (autoRequestDTO.placa().equals(datos[1])){
                    datosAuto = new String[5];
                    datosAuto[0] = datos[2];
                    datosAuto[1] = datos[3];
                    datosAuto[2] = datos[4];
                    datosAuto[3] = datos[5];
                    datosAuto[4] = datos[6];

                }
            }
        } catch (IOException e){
            datosAuto = null;
            throw new IOException(e);
        }
        return datosAuto;
    }
}
