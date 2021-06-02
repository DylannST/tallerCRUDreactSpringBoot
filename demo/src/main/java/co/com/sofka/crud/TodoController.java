package co.com.sofka.crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("api/todos")
    public Iterable<Todo> list() {
        return todoService.list();
    }

    @PostMapping("api/todo")
    public Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping("api/todo")
    public Todo update(@RequestBody Todo todo) {
        if (todo.getId() != null) {
            return todoService.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizarse");
    }

    @DeleteMapping("api/{id}/todo")
    public void delete(@PathVariable("id") Long id) {
        todoService.delete(id);
    }

    @GetMapping("api/{id}/todo")
    public Todo get(@PathVariable("id") Long id) {
        return todoService.get(id);
    }
}
