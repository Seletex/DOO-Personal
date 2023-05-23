package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {

	@GetMapping("/dummy")

	public EstadoTipoRelacionInstitucionDTO dummy() {
		return EstadoTipoRelacionInstitucionDTO.crete();
	}

	@GetMapping
	public List<EstadoTipoRelacionInstitucionDTO> list(@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		List<EstadoTipoRelacionInstitucionDTO> list = new ArrayList<>();
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		return list;
	}
	
	@GetMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO listById(@PathVariable UUID id) {
		
	
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(id);
	}
	
	@PostMapping
	public EstadoTipoRelacionInstitucionDTO create(@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		return dto;
	}
	
	@PutMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id,@RequestBody EstadoTipoRelacionInstitucionDTO dto) {
		return dto.setIdenficador(id);
	}
	
	@DeleteMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id) {
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(id);
	}
	
	

}
