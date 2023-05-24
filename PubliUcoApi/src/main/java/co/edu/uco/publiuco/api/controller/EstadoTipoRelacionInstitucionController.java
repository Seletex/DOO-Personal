package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.publiuco.api.controller.response.Response;
import org.slf4j.Logger;

import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.RegistrarEstadoTipoRelacionInstitucionValidation;
import co.edu.uco.publiuco.business.facade.EstadoTipoRelacionInstitucionFacade;
import co.edu.uco.publiuco.business.facade.impl.EstadoTipoRelacionInstitucionFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {

	private Logger log = LoggerFactory.getLogger(EstadoTipoRelacionInstitucionController.class);

	private EstadoTipoRelacionInstitucionFacade facade;



	@GetMapping("/dummy")

	public EstadoTipoRelacionInstitucionDTO dummy() {
		return EstadoTipoRelacionInstitucionDTO.crete();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>>  list(@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		List<EstadoTipoRelacionInstitucionDTO> list = new ArrayList<>();
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		
		List<String> messages = new ArrayList<>();
		messages.add("Estado de tipo relacion institucion consultados existosamente");
		Response<EstadoTipoRelacionInstitucionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>> listById(@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoTipoRelacionInstitucionDTO>();
		
		try {
			var result = RegistrarEstadoTipoRelacionInstitucionValidation.validate(dto);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>> create(
			@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<EstadoTipoRelacionInstitucionDTO>();

		try {
			var result = RegistrarEstadoTipoRelacionInstitucionValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade = new EstadoTipoRelacionInstitucionFacadeImpl();
				facade.register(dto);
				response.getMessageStrings()
						.add("El nuevo estado tipo relacion institucion se ha registrado de forma satisfacoria");

			} else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessageStrings(result.getMessages());
			}
		} catch (final PubliUcoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessageStrings().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()));

		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessageStrings().add("Se ha presentado un problema inesperado.Porfavor intentar de nuevo");
			log.error("Se ha presntado un problem inesperado. Porfavor validar la consola");
		}
		return new ResponseEntity<>(response, statusCode);
	}

	@PutMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id,
			@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		return dto.setIdenficador(id);
	}

	@DeleteMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id) {
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(id);
	}

}
