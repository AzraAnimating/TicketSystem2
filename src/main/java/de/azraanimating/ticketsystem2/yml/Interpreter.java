package de.azraanimating.ticketsystem2.yml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class Interpreter {
    public String getToken(){
        String lToken = "";
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("config.yaml");
        Map<String, Object> objectMap = yaml.load(inputStream);
        System.out.println(objectMap);

        return lToken;
    }
}
