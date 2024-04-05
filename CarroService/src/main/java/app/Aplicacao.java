package app;

import static spark.Spark.*;
import dao.CarroDao;
import model.Carro;


public class Aplicacao {
	
    public static void main(String[] args) {
        //port(6789);
        
        CarroDao cd = new CarroDao();
        staticFiles.location("/public");
        
        get("/readAll", (request,reponse) -> {
            return cd.get();
        });

        post("/inserir", (request, response) -> {
            Carro a = new Carro(4,"VolksWagem Voyage", 1984, "VolksWagem", 100000);
            return cd.insert(a);
        });

        delete("/delete", (request, response) -> {
            return cd.delete(1);
        });
        
        post("/produto/list/:orderby", (request, response) -> {
            Carro a = new Carro(4,"Voyage", 1984, "VolksWagem", 100000);
            return cd.update(a);
        });

        // get("/produto/update/:id", (request, response) -> produtoService.getToUpdate(request, response));
        
        // post("/produto/update/:id", (request, response) -> produtoService.update(request, response));
           
        // get("/produto/delete/:id", (request, response) -> produtoService.delete(request, response));

             
    }
}