package pp2.app2.controlador;

import pp2.app2.helpers.ApiConnector;

public class AppController {

    private ApiConnector api;

    // TODO obtenerCategorias en vez de obtenerMenuPrincipal
    // private static String url_categorias = "http://localhost:8080/superencasa/rest/catalogo/obtenerMenuPrincipal";
    // private static String url_categorias = "https://api.myjson.com/bins/guk23";

    public AppController() {
        this.api = new ApiConnector();
    }
    

}