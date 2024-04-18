package com.example.MessageTestDH;

import com.example.MessageTestDH.Model.Message;
import com.example.MessageTestDH.Service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessageTestDhApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MessageService messageService;

	@Test
	public void testProcessMessage() throws IOException {
		// Crea una entidad con datos de prueba
		Message messageEntity = new Message();
		messageEntity.setId(1L);

		String filePath = "/MessageServiceTestCases.json";

		// Crear un objeto File con la ruta del archivo JSON
		File file = new File(filePath);

		// Crear un ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		// Leer el archivo JSON y convertirlo en un objeto Java
		Message message = objectMapper.readValue(file, Message.class);


		messageEntity.setMessage(Arrays.asList("Este", "world"));


	}
}
