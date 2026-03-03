package mack.ps2.estagios.estagios.controller;

import mack.ps2.estagios.estagios.model.Inscricao;
import mack.ps2.estagios.estagios.repository.InscricaoRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/inscricoes")
@CrossOrigin(origins = "*")
public class InscricaoController {

    @Autowired
    private InscricaoRepository inscricaoRepository; 


    @PostMapping
    public Inscricao adicionar(@RequestBody Inscricao novaInscricao) {
        return inscricaoRepository.save(novaInscricao); 
    }

    // 🔹 GET - Listar todas
    @GetMapping
    public List<Inscricao> listarInscricoes() {
        return inscricaoRepository.findAll(); 
    }

    // 🔹 GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Long id) {
        return inscricaoRepository.findById(id) 
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> atualizar(@PathVariable Long id, @RequestBody Inscricao inscricaoAtualizada) {
        return inscricaoRepository.findById(id) 
                .map(inscricaoExistente -> {
                    
                    inscricaoExistente.setDataInscricao(inscricaoAtualizada.getDataInscricao());
                    inscricaoExistente.setStatus(inscricaoAtualizada.getStatus());
                    inscricaoExistente.setMensagemApresentacao(inscricaoAtualizada.getMensagemApresentacao());

                    
                    inscricaoExistente.setEstudante(inscricaoAtualizada.getEstudante());
                    inscricaoExistente.setVaga(inscricaoAtualizada.getVaga());

                    Inscricao inscricaoSalva = inscricaoRepository.save(inscricaoExistente); 
                    return ResponseEntity.ok(inscricaoSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (inscricaoRepository.existsById(id)) { 
            inscricaoRepository.deleteById(id);
            return ResponseEntity.ok("Inscrição removida com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }
}