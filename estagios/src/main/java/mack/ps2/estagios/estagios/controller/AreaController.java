package mack.ps2.estagios.estagios.controller;

import mack.ps2.estagios.estagios.model.Area;
import mack.ps2.estagios.estagios.repository.AreaRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas") 
@CrossOrigin(origins = "*")
public class AreaController {

    @Autowired
    private AreaRepository areaRepository; 

    // 🔹 POST - Adicionar nova
    @PostMapping
    public Area adicionar(@RequestBody Area novaArea) {
        return areaRepository.save(novaArea);
    }

    // 🔹 GET - Listar todas
    @GetMapping
    public List<Area> listarAreas() {
        return areaRepository.findAll();
    }

    // 🔹 GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Area> buscarPorId(@PathVariable Long id) {
        return areaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Area> atualizar(@PathVariable Long id, @RequestBody Area areaAtualizada) {
        return areaRepository.findById(id)
                .map(area -> {
                    // Atualiza os campos da entidade existente
                    area.setNome(areaAtualizada.getNome());
                    // (Adicione outros campos aqui se a entidade 'Area' crescer)
                    
                    Area areaSalva = areaRepository.save(area);
                    return ResponseEntity.ok(areaSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (areaRepository.existsById(id)) {
            areaRepository.deleteById(id);
            return ResponseEntity.ok("Área removida com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }
}