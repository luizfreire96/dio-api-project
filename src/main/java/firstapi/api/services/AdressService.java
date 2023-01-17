package firstapi.api.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import firstapi.api.model.Adress;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface AdressService {

    @GetMapping("/{cep}/json/")
    Adress cepQuery(@PathVariable("cep") String cep);

}
