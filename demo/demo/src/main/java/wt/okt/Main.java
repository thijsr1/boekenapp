package wt.okt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/greet")
    public String greet(){
        return "Hello World!";
    }

    @GetMapping("/getlijst")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping(path="/addlijst") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody List<User> n) {

        userRepository.saveAll(n);
        return "Lijst toegevoegd";
    }

    @PostMapping(path="/addboek") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String titel, String auteur, int aantalExemplaren, String afbeeldingURL) {
        User n = new User();
        n.setTitel(titel);
        n.setAuteur(auteur);
        n.setAantalExemplaren(aantalExemplaren);
        n.setAfbeeldingURL(afbeeldingURL);
        userRepository.save(n);
        return "Boek toegevoegd";
    }

    @PutMapping("/update/{id}")
    public String updateUser (@PathVariable int id, @RequestBody User user) {
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setTitel(user.getTitel());
        userRepository.save(updatedUser);
        return " updated";
    }

    @DeleteMapping("/deleteBoek/{id}")
    public String deleteUser(@PathVariable int id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "User with id: " + id + " deleted.";
    }


    }



