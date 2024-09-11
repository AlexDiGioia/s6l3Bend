package alexdigioia.s6l3Bend.controllers;

import alexdigioia.s6l3Bend.entities.Autore;
import alexdigioia.s6l3Bend.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    //Get http://localhost:3001/autori
    @GetMapping
    private List<Autore> getAllAutori() {
        return autoreService.findAll();
    }

    //Get http://localhost:3001/autori/{autoreId}
    //Get http://localhost:3001/autori/123
    @GetMapping("/{autoreId}")
    private Autore getBlogById(@PathVariable int autoreId) {
        return autoreService.findById(autoreId);
    }

    //Post http://localhost:3001/autori/  +BODY
    @PostMapping
    private Autore createAutore(@RequestBody Autore body) {
        return autoreService.saveAutore(body);
    }

    //Put http://localhost:3001/autori/{autoreId}  +BODY
    //Put http://localhost:3001/autori/123
    @PutMapping("/{autoreId}")
    private Autore findAutoreByIdAndUpdate(@PathVariable int autoreId, @RequestBody Autore body) {
        return autoreService.findByIdAndUpdate(autoreId, body);
    }

    //Delete http://localhost:3001/autori/{autoreId}
    //Delete http://localhost:3001/autori/123
    @DeleteMapping("/{autoreId}")
    private void findAutoreByIdAndDelete(@PathVariable int autoreId) {
        autoreService.findByIdAndDelete(autoreId);
    }
}
