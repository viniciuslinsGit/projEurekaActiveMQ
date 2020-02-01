package com.rodrigofujioka;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.entity.Paciente;

@RestController
@RequestMapping("/producer")
public class ProducerServiceController {

//    @GetMapping
//    public String insertObject() {
//    	try {
//        	JavaProducer javaProducer = new JavaProducer();
//    		javaProducer.run();
//			return "Objeto inserido com uscesso na lista!";
//    	}catch (Exception e) {
//    		return "Erro ao inserir objeto na lista";
//		}
//    }

    @PostMapping
    public ResponseEntity<Paciente> addPaciente(@Valid @RequestBody Paciente paciente) {
    	
    	try {
    		
    		JavaProducer javaProducer = new JavaProducer();
    		javaProducer.run(paciente);
			
    		return ResponseEntity.ok(paciente);
    	}catch (Exception e) {
			
    		return ResponseEntity.badRequest().build();
		}
    	
    }
    
    
}
