package com.rodrigofujioka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.entity.Paciente;

@RestController
@RequestMapping("/consumer")
public class ConsumerServiceController {

    @GetMapping
    public ResponseEntity<Paciente> consummerObject() {
    	try {
			Consumer consumer = new Consumer();
			Paciente paciente = consumer.run();
			
    		return ResponseEntity.ok(paciente);
    	}catch (Exception e) {
    		return ResponseEntity.badRequest().build();
		}
    }

}
