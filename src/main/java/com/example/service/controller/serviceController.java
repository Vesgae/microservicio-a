package com.example.service.controller;

import com.example.service.entity.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


@RestController
@RequestMapping("/service")
//http://localhost:8083/service/
public class serviceController {


    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private com.example.service.service.serviceService serviceService;

    @Autowired
    private com.example.service.service.transportService transportService;

    @Autowired
    private com.example.service.service.foodService foodService;

    @Autowired
    private com.example.service.service.entreService entreService;

    @Autowired
    private com.example.service.service.logService logService;

    @GetMapping("/services")
    public ResponseEntity<List<service>> getAllService() {
        return new ResponseEntity<>(serviceService.getALlServices(), HttpStatus.OK);
    }

    @PostMapping("/service")
    public ResponseEntity<String> saveService(@RequestBody service newService) {
        serviceService.saveService(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @PutMapping("/service")
    public ResponseEntity<String> updateService(@RequestBody service updateService) {
        int i = serviceService.updateService(updateService);
        if (i == 1) {
            return new ResponseEntity<>("Se ha modificado con exito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Intente de nuevo", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>("Se ha eliminado con exito", HttpStatus.OK);
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<String> getOneDetail(@PathVariable Integer id) {

        service serviceFound = serviceService.getJustOne(id);
        String countryDetail = countryDetail(serviceFound.getCountry());
        String weatherDetail= String.valueOf(weatherDetail(serviceFound.getCountry()));

        if (serviceFound.getCategory().equals("Food")) {
            serviceFood serviceFood = createServiceFood(serviceFound, id);
            return new ResponseEntity<>(serviceFood.toString() + "\nCountry Info: " + countryDetail + "\nWeather Info: " + weatherDetail, HttpStatus.OK);
        } else if (serviceFound.getCategory().equals("Transport")) {
            serviceTransport serviceTransport = createServiceTransport(serviceFound, id);
            return new ResponseEntity<>(serviceTransport.toString()+ "\nCountry Info: " + countryDetail + "\nWeather Info: " + weatherDetail, HttpStatus.OK);
        } else if (serviceFound.getCategory().equals("Entertainment")) {
            serviceEnter serviceEnter = createServiceEnter(serviceFound, id);
            return new ResponseEntity<>(serviceEnter.toString()+ "\nCountry Info: " + countryDetail + "\nWeather Info: " + weatherDetail, HttpStatus.OK);
        } else if (serviceFound.getCategory().equals("Logdment")) {
            serviceLogdment serviceLogdment = createServiceLog(serviceFound, id);
            return new ResponseEntity<>(serviceLogdment.toString()+ "\nCountry Info: " + countryDetail + "\nWeather Info: " + weatherDetail, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<String>> getAllCategory(@PathVariable String category) {
        List<service> serviceCategory = serviceService.getAllCategory(category);
        List<String> returnServices = new ArrayList<>();

        if (category.equals("Food")) {
            for (service serviceFound : serviceCategory) {

                serviceFood serviceFood = createServiceFood(serviceFound, serviceFound.getId_service());
                returnServices.add(serviceFood.toString());
            }


            return new ResponseEntity<>(returnServices, HttpStatus.OK);
        } else if (category.equals("Transport")) {
            for (service serviceFound : serviceCategory) {

                serviceTransport serviceTransport = createServiceTransport(serviceFound, serviceFound.getId_service());
                returnServices.add(serviceTransport.toString());
            }
            return new ResponseEntity<>(returnServices, HttpStatus.OK);

        } else if (category.equals("Entertainment")) {

            for (service serviceFound : serviceCategory) {

                serviceEnter serviceEnter = createServiceEnter(serviceFound, serviceFound.getId_service());
                returnServices.add(serviceEnter.toString());
            }
            return new ResponseEntity<>(returnServices, HttpStatus.OK);
        } else if (category.equals("Logdment")) {
            for (service serviceFound : serviceCategory) {

                serviceLogdment serviceLogdment = createServiceLog(serviceFound, serviceFound.getId_service());
                returnServices.add(serviceLogdment.toString());
            }
            return new ResponseEntity<>(returnServices, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);


    }


    @GetMapping("/keyWord/{word}")
    public ResponseEntity<List<String>> getAllCoincidence(@PathVariable String word) {
        List<String> returnCoindicence = new ArrayList<>();
        List<String> allServices = new ArrayList<>();
        List<service> serviceFoodList = serviceService.getAllCategory("Food");
        List<service> serviceLogList = serviceService.getAllCategory("Logdment");
        List<service> serviceTransList = serviceService.getAllCategory("Transport");
        List<service> serviceEnterList = serviceService.getAllCategory("Entertainment");

        for (service serviceFound : serviceFoodList) {
            serviceFood serviceFood = createServiceFood(serviceFound, serviceFound.getId_service());
            allServices.add(serviceFood.toString());
        }
        for (service serviceFound : serviceTransList) {

            serviceTransport serviceTransport = createServiceTransport(serviceFound, serviceFound.getId_service());
            allServices.add(serviceTransport.toString());
        }
        for (service serviceFound : serviceEnterList) {

            serviceEnter serviceEnter = createServiceEnter(serviceFound, serviceFound.getId_service());
            allServices.add(serviceEnter.toString());
        }
        for (service serviceFound : serviceLogList) {
            serviceLogdment serviceLogdment = createServiceLog(serviceFound, serviceFound.getId_service());
            allServices.add(serviceLogdment.toString());
        }

        for ( String auxAllServices:allServices ){
            if (auxAllServices.contains(word)){
                returnCoindicence.add(auxAllServices);
            }
        }

        return new ResponseEntity<>(returnCoindicence, HttpStatus.OK);


    }

    public List<String> getImages(String category) {
        List<service> serviceCategory = serviceService.getAllCategory(category);
        List<String> url = new ArrayList<>();
        int currentPhotoIndex = 0;


        if (category.equals("Food")) {
            for (service serviceFound : serviceCategory) {
                serviceFood serviceFood = createServiceFood(serviceFound, serviceFound.getId_service());
                url.add(serviceFood.getPhoto_url());
            }

        } else if (category.equals("Transport")) {
            for (service serviceFound : serviceCategory) {
                serviceTransport serviceTransport = createServiceTransport(serviceFound, serviceFound.getId_service());
                url.add(serviceTransport.getPhoto_url());
            }

        } else if (category.equals("Entertainment")) {

            for (service serviceFound : serviceCategory) {

                serviceEnter serviceEnter = createServiceEnter(serviceFound, serviceFound.getId_service());
                url.add(serviceEnter.getPhoto_url());
            }

        } else if (category.equals("Logdment")) {
            for (service serviceFound : serviceCategory) {

                serviceLogdment serviceLogdment = createServiceLog(serviceFound, serviceFound.getId_service());
                url.add(serviceLogdment.getPhoto_url());
            }

        }

        return url;


    }


    private void openPicture(List<String> url, HttpServletResponse response, int index) throws IOException {
        String urlService = url.get(index);
        URL imageUrl = new URL(urlService);
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "inline; filename=" + getImageFilename(urlService));
        InputStream inputStream = imageUrl.openStream();
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

    @GetMapping("/collage/{category}/{currentPhotoIndex}")
    public ResponseEntity<?> mostrarSiguienteFoto(@PathVariable String category, HttpServletResponse response, @PathVariable int currentPhotoIndex) throws IOException {
        if (currentPhotoIndex < getImages(category).size()) {
            openPicture(getImages(category), response, currentPhotoIndex);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>("Indice fuera del rango", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/serviceFood")
    public ResponseEntity<List<food>> saveServiceFood() {
        return new ResponseEntity<>(foodService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/serviceFood")
    public ResponseEntity<String> saveServiceFood(@RequestBody food newService) {
        foodService.saveFood(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @PutMapping("/serviceFood")
    public ResponseEntity<String> updateServiceFood(@RequestBody food newService) {
        foodService.saveFood(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @GetMapping("/serviceTransport")
    public ResponseEntity<List<transport>> saveServiceTransport() {
        return new ResponseEntity<>(transportService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/serviceTransport")
    public ResponseEntity<String> saveServiceTransport(@RequestBody transport newService) {
        transportService.saveTransport(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @PutMapping("/serviceTransport")
    public ResponseEntity<String> updateServiceTransport(@RequestBody transport  newService) {
        transportService.saveTransport(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @GetMapping("/serviceEntertainment")
    public ResponseEntity<List<entre>> saveServiceEnter() {
        return new ResponseEntity<>(entreService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/serviceEntertainment")
    public ResponseEntity<String> saveServiceEnter(@RequestBody entre newService) {
        entreService.saveService(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @PutMapping("/serviceEntertainment")
    public ResponseEntity<String> updateServiceEnter(@RequestBody entre newService) {
        entreService.saveService(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @GetMapping("/serviceLog")
    public ResponseEntity<List<log>> saveServiceLog() {
        return new ResponseEntity<>(logService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/serviceLog")
    public ResponseEntity<String> saveServiceLog(@RequestBody log newService) {
        logService.saveLog(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }

    @PutMapping("/serviceLog")
    public ResponseEntity<String> updateServiceLog(@RequestBody log newService) {
        logService.saveLog(newService);
        return new ResponseEntity<>("Se ha guardado con exito", HttpStatus.OK);
    }


    @GetMapping("/serviceShop")
    public List<String> getShoppingCartInfo() {
        List<String> shoppingCartInfos = new ArrayList<>();
        for (service shop : serviceService.getALlServices()) {
            shoppingCartInfo shoppingCartInfo = new shoppingCartInfo(shop.getAvailability(), shop.getPrice(), shop.getId_service());
            shoppingCartInfos.add(shoppingCartInfo.toString());
        }
        return shoppingCartInfos;
    }

    @PostMapping(value = "/serviceSold", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String shoppingCarInfo(@RequestBody List<String> info) {
        List<shoppingCartInfo> service =new ArrayList<>();
        for (String auxS : info) {
            String[] partes = auxS.split(",\\s*"); // Separar las partes del token
            String availability = partes[0].substring(partes[0].indexOf("=") + 1); // Obtener el valor de "availability"
            String price = partes[1].substring(partes[1].indexOf("=") + 1); // Obtener el valor de "price"
            String id_service = partes[2].substring(partes[2].indexOf("=") + 1); // Obtener el valor de "id_service"
            Integer auxAva = Integer.parseInt(availability);
            Integer auxId = Integer.parseInt(id_service);
            Double auxPrice = Double.parseDouble(price);
            service.add(new shoppingCartInfo(auxAva,auxPrice,auxId));
        }
        updateStock(serviceService.getALlServices(),service);
        return "ok";
    }

    private void updateStock(List<service> services, List<shoppingCartInfo> info){
        for(service aux: services){
            for(shoppingCartInfo shop:info){
                if(shop.getId_service()==aux.getId_service()){
                    aux.setAvailability(aux.getAvailability()-shop.getAvailability());
                    serviceService.updateService(aux);
                }
            }
        }
    }

    private String getImageFilename(String url) {
        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }

    private serviceFood createServiceFood(service serviceFound, Integer id) {
        food foodAux = foodService.getAllService(id);
        serviceFood serviceFood = new serviceFood(serviceFound.getCountry(),serviceFound.getId_supplier(),
                serviceFound.getDuration(), serviceFound.getPrice(), serviceFound.getPhoto_url(), serviceFound.getName(), serviceFound.getCategory(),
                serviceFound.getAvailability(), foodAux.getId_food(), foodAux.getPlace_type(), foodAux.getDiet_type(), foodAux.getFood_type(), foodAux.getId_service());
        return serviceFood;
    }

    private serviceEnter createServiceEnter(service serviceFound, Integer id) {
        entre entreAux = entreService.getAllService(id);
        serviceEnter serviceEnter = new serviceEnter(serviceFound.getId_supplier(),
                serviceFound.getDuration(), serviceFound.getPrice(), serviceFound.getPhoto_url(), serviceFound.getName(), serviceFound.getCategory(),
                serviceFound.getAvailability(), entreAux.getId_enter(), entreAux.getEnter_type(), entreAux.getTime_arrival(), entreAux.getTime_departure(),
                entreAux.getRestriction(), entreAux.getId_service(), serviceFound.getCountry());
        return serviceEnter;
    }

    private serviceLogdment createServiceLog(service serviceFound, Integer id) {
        log logAux = logService.getAllService(id);
        serviceLogdment serviceLogdment = new serviceLogdment(logAux.getId_logdment(), logAux.getLogdment_type(), logAux.getRoom_type(), logAux.getId_service(), serviceFound.getId_supplier(),
                serviceFound.getDuration(), serviceFound.getPrice(), serviceFound.getPhoto_url(), serviceFound.getName(), serviceFound.getCategory(),
                serviceFound.getAvailability(), serviceFound.getCountry());
        return serviceLogdment;
    }

    private serviceTransport createServiceTransport(service serviceFound, Integer id) {
        transport transportAux = transportService.getAllService(id);
        serviceTransport serviceTransport = new serviceTransport(transportAux.getId_transport(), transportAux.getVehicule_type(), transportAux.getPath_name(),
                transportAux.getTime_arrival(), transportAux.getTime_departure(), transportAux.getId_service(), serviceFound.getId_supplier(),
                serviceFound.getDuration(), serviceFound.getPrice(), serviceFound.getPhoto_url(), serviceFound.getName(), serviceFound.getCategory(),
                serviceFound.getAvailability(), serviceFound.getCountry());
        return serviceTransport;

    }

    private String countryDetail(String CountryName){
        String apiUrl = "https://restcountries.com/v3.1/name/" + CountryName;
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            return responseBody;
        } else {
            String responseError ="Error al obtener los detalles del país";
            return responseError;
        }
    }



    public  ResponseEntity<?> weatherDetail(String CountryName){
        System.out.println("hola perras");
        String pais = CountryName;
        String Location=obtenerLatitudLongitud(pais);
        String fields= "fields=temperature,cloudCover,humidity,windSpeed";
        String ApiKey= "apikey=3KW8it5jInExDjQN4f8aYNBrN9z5Sjx1";
        String timesteps= "timesteps=1d";
        String getTimelineURL = "https://api.tomorrow.io/v4/timelines?location=";

        System.out.println(getTimelineURL+Location+"&"+timesteps+"&"+ApiKey+"&"+fields);

        ResponseEntity<String> response = restTemplate.getForEntity(getTimelineURL+Location+"&"+timesteps+"&"+ApiKey+"&"+fields, String.class);
        return response;
    }

    public String obtenerLatitudLongitud(String pais) {
        try {
            String url = "https://nominatim.openstreetmap.org/search?country=" + pais + "&format=json";

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);

            String jsonResult = EntityUtils.toString(response.getEntity());
            JSONArray jsonArray = new JSONArray(jsonResult);

            if (jsonArray.length() > 0) {
                JSONObject firstResult = jsonArray.getJSONObject(0);
                double latitud = Double.parseDouble(firstResult.getString("lat"));
                double longitud = Double.parseDouble(firstResult.getString("lon"));

                String responseLat;
                responseLat= String.valueOf(latitud) +","+String.valueOf(longitud);
                System.out.println("Latitud: " + latitud);
                System.out.println("Longitud: " + longitud);
                return responseLat;
            } else {
                return "No se encontró la ubicación del país.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
