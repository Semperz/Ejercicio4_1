package demoapp.service;

import demoapp.controller.PersonForm;
import org.springframework.stereotype.Service;

@Service
public class FormularioService {

        public String formulario(PersonForm pf) {
            return pf.getName() + " de " + pf.getAge() + " años" + " con dni " + pf.getDni();
        }
}
